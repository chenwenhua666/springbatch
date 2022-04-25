package com.plm.platform.batch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.plm.platform.batch.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
public interface UserService extends IService<User> {
    List<Map> findUserInfoByIds(String code, List<Long> userIds);
}
