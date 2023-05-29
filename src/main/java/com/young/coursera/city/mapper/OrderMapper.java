package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.model.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int deleteById(Long id);

    int insert(Order row);

    Order findById(Long id);

    List<Order> findAll();

    int update(Order row);
}