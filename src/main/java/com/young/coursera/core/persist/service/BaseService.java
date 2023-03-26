package com.young.coursera.core.persist.service;

import com.young.coursera.core.lang.BaseEntity;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T create(T entity);

    T update(Long id, T entity);

    T get(Long id);

    void delete(Long id);

    List<T> list(Query query);

    List<T> listForPage(PageQuery query);

    T publish(Long id, Boolean flag);
}
