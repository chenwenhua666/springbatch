package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.ProductInfo;
import com.plm.platform.batch.mapper.ProductInfoMapper;
import com.plm.platform.batch.service.ProductInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
@DS("shardingSphere")
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
    @Override
    public List<Map> findProductDetail(long pageNum, long pageSize) {

        long start = (pageNum - 1) * pageSize;
        return baseMapper.findProductDetail(start, pageSize);
    }

    @Override
    public IPage<Map> findProductDetailByPage(long pageNum, long pageSize) {
        Page<Map> page = new Page<>(pageNum, pageSize);
        return baseMapper.findProductDetailByPage(page);
    }

    @Override
    public List<Map> findProductGroupList() {
        return baseMapper.findProductGroupList();
    }
}
