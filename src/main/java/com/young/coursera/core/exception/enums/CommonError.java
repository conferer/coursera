package com.young.coursera.core.exception.enums;

import com.young.coursera.core.lang.Err;
import org.springframework.http.HttpStatus;

/**
 * 通用的错误码定义
 * Exception 的 status 根据状态码确定，总共可改概括为一下几种
 * 200 - 请求成功，response body 为返回的业务数据，无任何其它包装（无status、code、data等）
 * <p>
 * 400 - 请求参数错误，例如创建课程时，请求参数中课程名称为空。
 * 401 - 未登录，所请求的资源需要登录后才能访问，例如未登录用户访问“我的在学课程”接口。
 * 403 - 无权限，当前用户已登陆，但无权限访问所请求的资源，例如学生用户试图删除某个课程。
 * 404 - 资源不存在，所请求的URL或资源不存在，例如获取课程详情时，所传入的课程UID错误。
 * 409 - 资源冲突，所请求的资源与已存在的资源冲突，例如创建课程分类时，分类代码已存在。
 * 429 - 请求超出上限，例如报名线下活动的人数超过限制人数。
 * <p>
 * 500 - 服务内部错误，代码中未捕获或未进行特殊处理，例如由于手工删除数据库中数据造成代码错误。
 * 503 - 服务不可用，例如所访问网校已停止服务。
 * <p>
 * Code 各式
 * INVALID_REQUEST https://developer.paypal.com/api/rest/responses/
 * invalidRequest https://cloud.google.com/storage/docs/json_api/v1/status-codes#409-conflict
 * InvalidRequest https://help.aliyun.com/document_detail/31973.html?spm=a2c4g.11186623.6.1609.23975c9cjCf71z
 */
public enum CommonError implements Err {

    BAD_REQUEST("400", "请求错误"),

    UNAUTHORIZED("401", "请求未授权"),

    FORBIDDEN("403", "访问被禁止"),

    NOT_FOUND("404", "资源不存在"),

    CONFLICT("409", "资源冲突"),

    TOO_MANY_REQUESTS("429", "请求次数过多"),

    INTERNAL_ERROR("500", "服务内部错误"),

    SERVICE_UNAVAILABLE("503", "服务暂不可用");

    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    CommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
