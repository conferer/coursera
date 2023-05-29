package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.model.OrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper {
    int deleteById(Long id);

    int insert(OrderItem row);

    OrderItem findById(Long id);

    List<OrderItem> findAll();

    int update(OrderItem row);
}