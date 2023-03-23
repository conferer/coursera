package com.young.coursera.core.exception.util;

import com.young.coursera.core.exception.ServiceException;
import com.young.coursera.core.lang.Err;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;


/**
 * @Description 简化异常使用的工具类
 * @Author LiuYang
 * @Date 2021/3/10 3:09 PM
 * @Version V1.0
 */
public class Asserts {
    private Asserts() {
    }

    /**
     * 如果当前对象为空，则抛出指定的错误信息
     *
     * @param object 需要检查的对象
     * @param err    错误信息
     */
    public static void notNull(Object object, Err err) {
        if (object == null) {
            throw new ServiceException(err);
        }
    }


    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new ServiceException(message);
        }
    }


    /**
     * 如果当前对象为空，则抛出指定的错误信息
     *
     * @param collection 需要检查的对象
     * @param err        错误信息
     */
    public static void notEmpty(Collection<?> collection, Err err) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ServiceException(err);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ServiceException(message);
        }
    }

    /**
     * 如果当前字符串没有内容，则抛出指定的错误信息
     *
     * @param text 需要检查的对象
     * @param err  错误信息
     */
    public static void hasText(String text, Err err) {
        if (!StringUtils.hasText(text)) {
            throw new ServiceException(err);
        }
    }

    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new ServiceException(message);
        }
    }

    /**
     * 如果当前表达式不成立，则抛出指定的错误信息
     *
     * @param expression 需要检查的对象
     * @param err        错误信息
     */
    public static void isTrue(boolean expression, Err err) {
        if (!expression) {
            throw new ServiceException(err);
        }
    }


    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ServiceException(message);
        }
    }
}