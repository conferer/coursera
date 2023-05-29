package com.young.coursera.service;

import com.young.coursera.CourseraApplicationTests;
import com.young.coursera.city.domain.model.Order;
import com.young.coursera.city.domain.model.OrderItem;
import com.young.coursera.city.service.OrderItemService;
import com.young.coursera.city.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImplTest extends CourseraApplicationTests {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderInfoService;

    //测试绑定表
    @Test
    void insert() {
        Order order = new Order();
        order.setUserId(111110L);
        order.setPrice(100000);
        orderService.insert(order);
        for (int i = 1; i < 3; i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductName("黄金1号竹子");
            orderItem.setProductPrice(8888);
            orderInfoService.insert(orderItem);
        }
    }

}
