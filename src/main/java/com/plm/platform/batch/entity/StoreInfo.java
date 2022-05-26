package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author crystal
 */
@Data
@TableName("t_store_info")
public class StoreInfo implements Serializable {
    @TableId
    private Long id;

    private String storeName;

    private Integer reputation;
    
    private String regionCode;

}
