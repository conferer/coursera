package com.young.coursera.core.persist.mapper;

import java.io.Serializable;

@Deprecated
public interface BaseMapper<PK, T extends Serializable> {

    /**
     * 根据id获得对象
     */
    T get(PK id);

    /**
     * 保存对象
     */
    int insert(T entity);

    /**
     * 更新对象
     */
    int update(T entity);

    /**
     * 根据主键id删除对象
     */
    int delete(PK id);
}
