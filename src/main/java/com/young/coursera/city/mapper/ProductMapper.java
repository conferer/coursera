package com.young.coursera.city.mapper;

import com.young.coursera.city.domain.model.Product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int deleteById(Long id);

    int insert(Product product);

    Product findById(Long id);

    List<Product> findAll();

    int update(Product row);
}