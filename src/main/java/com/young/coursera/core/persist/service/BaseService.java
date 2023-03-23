package com.young.coursera.core.persist.service;

import com.young.coursera.core.lang.BaseEntity;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;

import java.util.List;

public interface BaseService<T extends BaseEntity, Q extends Query, P extends PageQuery> {

    T create(T entity);

    T update(Long id, T entity);

    T get(Long id);

    void delete(Long id);

    List<T> list(Q query);

    List<T> listForPage(T query);

    default T publish(Long id, Boolean flag) {
        return null;
    }
}
