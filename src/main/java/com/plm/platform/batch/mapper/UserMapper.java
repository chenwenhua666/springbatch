package com.plm.platform.batch.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plm.platform.batch.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author crystal
 */
public interface UserMapper extends BaseMapper<User> {
    List<Map> findUserInfoByIds(@Param("code") String code, @Param("userIds") List<Long> userIds);
}
