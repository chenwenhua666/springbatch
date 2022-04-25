package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.StoreInfo;
import com.plm.platform.batch.mapper.StoreInfoMapper;
import com.plm.platform.batch.service.StoreInfoService;
import org.springframework.stereotype.Service;

/**
 * @author crystal
 */
@DS("sharding")
@Service
public class StoreInfoServiceImpl extends ServiceImpl<StoreInfoMapper, StoreInfo> implements StoreInfoService {
}
