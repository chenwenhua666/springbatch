package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author crystal
 */
@Data
@TableName("t_order")
public class Order implements Serializable {
    @TableId
    private Long orderId;

    private BigDecimal price;

    private Long userId;

    private String orderStatus;

}
