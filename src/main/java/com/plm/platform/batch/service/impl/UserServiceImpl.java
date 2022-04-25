package com.plm.platform.batch.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.plm.platform.batch.entity.User;
import com.plm.platform.batch.mapper.UserMapper;
import com.plm.platform.batch.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
@DS("sharding")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<Map> findUserInfoByIds(String code, List<Long> userIds) {
        return this.baseMapper.findUserInfoByIds(code, userIds);
    }
}
