package com.young.coursera.city.service;

import com.young.coursera.city.domain.model.Product;
import com.young.coursera.city.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductMapper shoppingMapper) {
        this.shoppingMapper = shoppingMapper;
    }

    private final ProductMapper shoppingMapper;

    @Override
    public int insert(Product shopping) {
        return shoppingMapper.insert(shopping);
    }

    @Override
    public Product findById(Long id) {
        return shoppingMapper.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return shoppingMapper.findAll();
    }
}
