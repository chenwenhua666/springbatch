package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.Region;
import com.plm.platform.batch.mapper.RegionMapper;
import com.plm.platform.batch.service.RegionService;
import org.springframework.stereotype.Service;

/**
 * @author crystal
 */
@DS("shardingSphere")
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
}
