package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.Dict;
import com.plm.platform.batch.mapper.DictMapper;
import com.plm.platform.batch.service.DictService;
import org.springframework.stereotype.Service;

/**
 * @author crystal
 */
@DS("sharding")
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
