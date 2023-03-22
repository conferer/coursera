package com.young.coursera.core.persist.service;

import com.young.coursera.core.persist.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T create(T entity);

    T update(Long id, T entity);

    T get(Long id);

    void delete(Long id);

    List<T> list();

    List<T> listForPage();
}
