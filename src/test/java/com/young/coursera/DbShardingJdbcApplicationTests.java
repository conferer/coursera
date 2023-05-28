package com.young.coursera;

import com.young.coursera.shopping.domain.Shopping;
import com.young.coursera.shopping.service.ShoppingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbShardingJdbcApplicationTests {
    @Test
    void contextLoads() {
    }


    // shoping商品表的测试类
    static class ShopingServiceImplTest extends DbShardingJdbcApplicationTests {

        @Autowired
        private ShoppingService shoppingService;

        // 测试数据插入的方法
        @Test
        void insertSelective() {
            for (int i = 1; i <= 20; i++){
                Shopping shoping = new Shopping();
                shoping.setShopingId((long) i);
                shoping.setShopingName("黄金"+ i +"号竹子");
                shoping.setShopingPrice(1111 * i);
                shoppingService.insert(shoping);
            }


        }
    }
}
