package com.young.coursera.core.persist.service;

import com.young.coursera.core.lang.BaseEntity;
import com.young.coursera.core.lang.Entity;
import com.young.coursera.core.lang.PageQuery;
import com.young.coursera.core.lang.Query;

import java.util.List;

/**
 * 为了规范 方法命名，这里将常用的方法名定义在此，其他接口继承此类，以便保持命名统一
 * 如果 ID 实现有多个类型，这里也需要在泛型中引入该参数
 *
 * @param <T> Entity
 */
public interface BaseService<T extends Entity> {

    T insert(T entity);

    T update(Long id, T entity);

    void delete(Long id);

    T findById(Long id);

    /**
     * 这个方法如果使用 pageHelper,name 可以通过入参控制，是否分页，因此 findForPage() 方法在某种意义上是没有必要存在
     *
     * @param query Query
     * @return List<T extends BaseEntity>
     */
    List<T> findAll(Query query);

    List<T> findForPage(PageQuery query);

    T publish(Long id, Boolean flag);
}
