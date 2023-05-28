package com.young.coursera.shopping.service;

import com.young.coursera.shopping.domain.Shopping;
import com.young.coursera.shopping.mapper.ShoppingMapper;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    public ShoppingServiceImpl(ShoppingMapper shoppingMapper) {
        this.shoppingMapper = shoppingMapper;
    }

    private final ShoppingMapper shoppingMapper;

    @Override
    public int insert(Shopping shopping) {
        return shoppingMapper.insert(shopping);
    }
}
