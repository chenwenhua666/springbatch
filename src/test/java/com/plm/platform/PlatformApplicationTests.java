package com.plm.platform;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

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
            order.setUserId(8L);
            order.setOrderStatus("finish");
            orderService.save(order);
        }
    }

    @Test
    public void query() {
        List<Long> ids = new ArrayList<>();
        ids.add(725060320611008512L);
        //ids.add(725017878729850881L);
        List<Order> orderList = orderService.listByIds(ids);
        log.info("结果={}",orderList);
    }

    @Test
    public void query2() {
        List<Long> ids = new ArrayList<>();
        ids.add(725060320611008512L);
        ids.add(725017878729850881L);
        LambdaQueryWrapper<Order> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(Order::getOrderId, ids);
        queryWrapper.eq(Order::getUserId, 4L);

        List<Order> orderList = orderService.list(queryWrapper);
        log.info("结果={}",orderList);
    }

}
