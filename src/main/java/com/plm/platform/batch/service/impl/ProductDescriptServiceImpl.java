package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.ProductDescript;
import com.plm.platform.batch.mapper.ProductDescriptMapper;
import com.plm.platform.batch.service.ProductDescriptService;
import org.springframework.stereotype.Service;

/**
 * @author crystal
 */
@DS("shardingSphere")
@Service
public class ProductDescriptServiceImpl extends ServiceImpl<ProductDescriptMapper, ProductDescript> implements ProductDescriptService {
}
