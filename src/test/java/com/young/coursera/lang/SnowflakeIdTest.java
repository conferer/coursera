package com.young.coursera.lang;

import com.young.coursera.core.lang.SnowflakeId;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class SnowflakeIdTest {
    public static final Logger log = LoggerFactory.getLogger(SnowflakeIdTest.class);

    @Test
    void testNextId() {
        IntStream.range(0, 100).forEach(index -> {
            log.info("{}", SnowflakeId.nextId());
        });
    }

    @Test
    void test64KIdIn1Sec() {
        for (int i = 0; i < 65534; i++) {
            SnowflakeId.nextId();
        }
        assertEquals(0b1111111111111111_00000L, SnowflakeId.nextId() & 0b1111111111111111_00000L);
        assertEquals(0b01_00000L, SnowflakeId.nextId() & 0b1111111111111111_00000L);
        assertEquals(0b10_00000L, SnowflakeId.nextId() & 0b1111111111111111_00000L);
    }

}
