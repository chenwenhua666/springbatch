package com.plm.platform.batch.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plm.platform.batch.entity.ProductInfo;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
public interface ProductInfoService extends IService<ProductInfo> {
    List<Map> findProductDetail(long pageNum, long pageSize);
    IPage<Map> findProductDetailByPage(long pageNum, long pageSize);
    List<Map> findProductGroupList();
}
