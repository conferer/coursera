package com.young.coursera.core.lang;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private static final String FAIL = "fail";
    public static final String SUCCESS = "success";
    public static final String SUCCESS_CODE = "200";
    public static final String FAIL_CODE = "400";

    /**
     * 结果数据
     */
    private T data;
    /**
     * 状态
     */
    private String status;
    /**
     * 代码
     */
    private String statusCode;

    /**
     * 错误消息
     */
    private String message;

    private Result(T data, String status, String statusCode, String message) {
        this.data = data;
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * 结果包装器: 成功时调用
     *
     * @param data data
     * @param <T>  data 泛型
     * @return Result<T>
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data, SUCCESS, SUCCESS_CODE, null);
    }

    /**
     * 结果包装器: 失败时调用
     *
     * @param message 错误消息
     * @param <T>     data 泛型
     * @return Result<T>
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(null, FAIL, FAIL_CODE, message);
    }

    /**
     * 结果包装器: 失败时调用
     *
     * @param statusCode
     * @param message
     * @param <T>        data 泛型
     * @return Result<T>
     */
    public static <T> Result<T> fail(String statusCode, String message) {
        return new Result<>(null, FAIL, statusCode, message);
    }
}
