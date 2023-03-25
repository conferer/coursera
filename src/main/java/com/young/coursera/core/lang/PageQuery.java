package com.young.coursera.core.lang;

import java.io.Serial;

/**
 * 分页查询过滤器
 */
public class PageQuery extends Query {
    @Serial
    private static final long serialVersionUID = -1897118078758531718L;
    /**
     * 页数
     */
    private Integer page;
    /**
     * 分页条数
     */
    private Integer pageSize;

    /**
     * 计算总数， 默认总是计算，除非设置为 false
     */
    private Boolean countTotal = true;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Boolean countTotal) {
        this.countTotal = countTotal;
    }
}
