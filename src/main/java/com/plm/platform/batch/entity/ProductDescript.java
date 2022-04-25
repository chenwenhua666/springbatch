package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author crystal
 */
@Data
@TableName("product_descript")
public class ProductDescript implements Serializable {

    @TableId
    private Long id;
    private Long productInfoId;
    private String descript;
    private Long storeInfoId;
}
