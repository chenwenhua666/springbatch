package com.plm.platform;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.plm.platform.batch.entity.Order;
import com.plm.platform.batch.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertOrder() {
        Order order = new Order();
        order.setOrderId(4L);
        order.setPrice(new BigDecimal(2.86));
        order.setUserId(1L);
        order.setOrderStatus("finish");
        orderService.save(order);
    }

}
