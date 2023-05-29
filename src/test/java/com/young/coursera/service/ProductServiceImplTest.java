package com.young.coursera.service;

import com.young.coursera.CourseraApplicationTests;
import com.young.coursera.city.domain.model.Product;
import com.young.coursera.city.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

public class ProductServiceImplTest extends CourseraApplicationTests {
    @Autowired
    private ProductService shoppingService;

    // 测试节点是否可用
    @Test
    void insert() {
        Product product = new Product();
        product.setId(99999999L);
        product.setName("竹子");
        product.setPrice(1111);
        shoppingService.insert(product);
    }

    // 测试分库策略是有效
    @Test
    void batchInsert() {
        for (int i = 1; i <= 20; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setName("黄金" + i + "号竹子");
            product.setPrice(1111 * i);
            shoppingService.insert(product);
        }
    }

    @Test
    void batchInsertSelective() {
        IntStream.range(0, 20).forEach(i -> {
            Product product = new Product();
            product.setName("白玉" + i + "号竹子");
            product.setPrice(i * 88);
            shoppingService.insert(product);
        });
    }


    @Test
    void findById() {
        shoppingService.findById(1L);
    }

    //查询所有商品信息
    @Test
    void findAll() {
        shoppingService.findAll();
    }
}
