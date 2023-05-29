package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.Order;

import java.util.List;

public interface OrderService {
    int deleteById(Long id);

    int insert(Order order);

    Order findById(Long id);

    List<Order> findAll();

    int update(Order row);
}
