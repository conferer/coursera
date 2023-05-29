package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    int deleteById(Long id);

    int insert(OrderItem row);

    OrderItem findById(Long id);

    List<OrderItem> findAll();

    int update(OrderItem row);
}