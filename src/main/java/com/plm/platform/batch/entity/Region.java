package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author crystal
 */
@Data
@TableName("t_region")
public class Region implements Serializable {
    @TableId
    private Long id;

    private String regionCode;

    private String regionName;

    private Integer level;

    private String parentRegionCode;

}
