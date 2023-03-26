package com.young.coursera.core.persist.service;

import com.young.coursera.core.lang.BaseEntity;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T insert(T entity);

    T update(Long id, T entity);

    T findById(Long id);

    void delete(Long id);

    List<T> findAll(Query query);

    List<T> findForPage(PageQuery query);

    T publish(Long id, Boolean flag);
}
