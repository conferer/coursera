package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.Order;
import com.young.coursera.city.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    private final OrderMapper orderMapper;

    @Override
    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }
}
