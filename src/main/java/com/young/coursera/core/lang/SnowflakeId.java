package com.young.coursera.core.lang;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.liaoxuefeng.com/article/1280526512029729
 * 53 bits unique id:
 * 为什么采用最多53位整型，而不是64位整型？这是因为考虑到大部分应用程序是Web应用，
 * 如果要和JavaScript打交道，由于JavaScript支持的最大整型就是53位，超过这个位数，
 * JavaScript将丢失精度。因此，使用53位整数可以直接由JavaScript读取，而超过53位时，
 * 就必须转换成字符串才能保证JavaScript处理正确，这会给API接口带来额外的复杂度.
 * 这也是为什么新浪微博的API接口会同时返回id和idstr的原因。
 * <p>
 * |--------|--------|--------|--------|--------|--------|--------|--------|
 * |00000000|00011111|11111111|11111111|11111111|11111111|11111111|11111111|
 * |--------|---xxxxx|xxxxxxxx|xxxxxxxx|xxxxxxxx|xxx-----|--------|--------|
 * |--------|--------|--------|--------|--------|---xxxxx|xxxxxxxx|xxx-----|
 * |--------|--------|--------|--------|--------|--------|--------|---xxxxx|
 * <p>
 * Maximum ID = 11111_11111111_11111111_11111111_11111111_11111111_11111111
 * <p>
 * Maximum TS = 11111_11111111_11111111_11111111_111
 * <p>
 * Maximum NT = ----- -------- -------- -------- ---11111_11111111_111 = 65535
 * <p>
 * Maximum SH = ----- -------- -------- -------- -------- -------- ---11111 = 31
 * <p>
 * It can generate 64k unique id per IP and up to 2106-02-07T06:28:15Z.
 */
public final class SnowflakeId {

    private static final Logger logger = LoggerFactory.getLogger(SnowflakeId.class);

    //机器标识采用简单的主机名方案，只要主机名符合host-1，host-2就可以自动提取机器标识，无需配置。
    private static final Pattern PATTERN_HOSTNAME = Pattern.compile("^.*\\D+([0-9]+)$");

    private static final long OFFSET = LocalDate.of(2020, 1, 1).atStartOfDay(ZoneId.of("Z")).toEpochSecond();

    private static final long MAX_NEXT = 0b11111_11111111_111L;

    private static final long SHARD_ID = getServerIdAsLong();

    private static long offset = 0;

    private static long lastEpoch = 0;

    public static long nextId() {
        return nextId(System.currentTimeMillis() / 1000);
    }

    public static long generate() {
        return nextId();
    }

    private static synchronized long nextId(long epochSecond) {
        if (epochSecond < lastEpoch) {
            // warning: clock is turn back:
            logger.warn("clock is back: " + epochSecond + " from previous:" + lastEpoch);
            epochSecond = lastEpoch;
        }
        if (lastEpoch != epochSecond) {
            lastEpoch = epochSecond;
            reset();
        }
        offset++;
        long next = offset & MAX_NEXT;
        if (next == 0) {
            logger.warn("maximum id reached in 1 second in epoch: " + epochSecond);
            return nextId(epochSecond + 1);
        }
        return generateId(epochSecond, next);
    }

    private static void reset() {
        offset = 0;
    }

    private static long generateId(long epochSecond, long next) {
        return ((epochSecond - OFFSET) << 21) | (next << 5) | SnowflakeId.SHARD_ID;
    }

    private static long getServerIdAsLong() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            Matcher matcher = PATTERN_HOSTNAME.matcher(hostname);
            if (matcher.matches()) {
                long n = Long.parseLong(matcher.group(1));
                if (n >= 0 && n < 8) {
                    logger.info("detect server id from host name {}: {}.", hostname, n);
                    return n;
                }
            }
        } catch (UnknownHostException e) {
            logger.warn("unable to get host name. set server id = 0.");
        }
        return 0;
    }
}