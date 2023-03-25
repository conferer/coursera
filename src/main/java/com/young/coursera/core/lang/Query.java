package com.young.coursera.core.lang;

import java.io.Serializable;

/**
 * 查询过滤器
 */
public class Query implements Serializable {

    /**
     * 排序字段
     * example:  ["id asc", "name asc"]
     */
    private String[] orderBy;

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }
}
