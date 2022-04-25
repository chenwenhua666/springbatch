package com.plm.platform.batch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plm.platform.batch.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<Map> findProductDetail(@Param("start") long start,@Param("pageSize") long pageSize);
    IPage<Map> findProductDetailByPage(Page<Map> page);
    List<Map> findProductGroupList();
}
