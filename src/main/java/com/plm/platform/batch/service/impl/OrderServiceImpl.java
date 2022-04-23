package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.Order;
import com.plm.platform.batch.mapper.OrderMapper;
import com.plm.platform.batch.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author crystal
 */
@DS("sharding")
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
