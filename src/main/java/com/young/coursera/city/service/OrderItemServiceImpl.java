package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.OrderItem;
import com.young.coursera.city.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    public OrderItemServiceImpl(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    private final OrderItemMapper orderItemMapper;

    @Override
    public int deleteById(Long id) {
        return orderItemMapper.deleteById(id);
    }

    @Override
    public int insert(OrderItem row) {
        return orderItemMapper.insert(row);
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemMapper.findById(id);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemMapper.findAll();
    }

    @Override
    public int update(OrderItem row) {
        return orderItemMapper.update(row);
    }
}
