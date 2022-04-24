package com.plm.platform;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.plm.platform.batch.entity.Order;
import com.plm.platform.batch.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            //order.setOrderId(1L);
            order.setPrice(new BigDecimal(i));
            order.setUserId(1L);
            order.setOrderStatus("finish");
            orderService.save(order);
        }
    }

    @Test
    public void query() {
        List<Long> ids = new ArrayList<>();
        ids.add(724967845791793153L);
        ids.add(724967844172791808L);
        List<Order> orderList = orderService.listByIds(ids);
        log.info("结果={}",orderList);
    }

}
