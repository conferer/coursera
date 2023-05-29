package com.young.coursera.city.service;


import com.young.coursera.city.domain.model.Product;

import java.util.List;

public interface ProductService {

    int insert(Product shopping);

    Product findById(Long id);

    List<Product> findAll();
}
