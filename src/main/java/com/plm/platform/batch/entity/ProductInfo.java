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
@TableName("product_info")
public class ProductInfo implements Serializable {

    @TableId
    private Long productInfoId;
    private Long storeInfoId;
    private String productName;
    private String spec;
    private String regionCode;
    private BigDecimal price;
    private String imageUrl;
}
