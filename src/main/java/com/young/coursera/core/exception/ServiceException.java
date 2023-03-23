package com.young.coursera.core.exception;

import com.young.coursera.core.exception.enums.CommonError;
import com.young.coursera.core.lang.Err;

/**
 * 业务逻辑错误
 */
public class ServiceException extends RuntimeException {
    /**
     * 错误信息， 包含错误编码和错误消息
     */
    private Err err;
    /**
     * 扩展信息，
     */
    private Object[] args;

    public ServiceException(Err err) {
        super(err.getMsg());
        this.err = err;
    }

    public ServiceException(Err err, Object[] args) {
        super(err.getMsg());
        this.err = err;
        this.args = args;
    }

    public ServiceException(String message) {
        super(message);
        this.err = CommonError.BAD_REQUEST;
    }

    public ServiceException(String message, Object[] args) {
        super(message);
        this.args = args;
        this.err = CommonError.BAD_REQUEST;
    }

    public ServiceException(Err err, Throwable cause) {
        super(err.getMsg(), cause);
        this.err = err;
    }

    public Err getErr() {
        return err;
    }

    public Object[] getArgs() {
        return args;
    }
}
