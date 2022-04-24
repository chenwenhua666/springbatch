package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author crystal
 */
@Data
@TableName("t_user")
public class User implements Serializable {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private String username;

    private String userType;

}
