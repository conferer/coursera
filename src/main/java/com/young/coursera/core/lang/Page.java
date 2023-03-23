package com.young.coursera.core.lang;

import java.io.Serializable;
import java.util.List;

/**
 * 分页包装器
 *
 * @param <T> BaseEntity
 */
public class Page<T extends BaseEntity> implements Serializable {
    /**
     * 页数
     */
    private int page;
    /**
     * 分页条数
     */
    private int pageSize;
    /**
     * 总条数
     */
    private int totalCount;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 列表
     */
    private List<T> results;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
