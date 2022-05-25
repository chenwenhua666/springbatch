package com.plm.platform.batch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author crystal
 */
@Data
@TableName("t_dict")
public class Dict implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 父主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long parentId;

	/**
	 * 字典码
	 */
	private String code;

	/**
	 * 字典值
	 */
	private String dictKey;

	/**
	 * 字典名称
	 */
	private String dictValue;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 字典备注
	 */
	private String remark;

	/**
	 * 是否已删除
	 */
	@TableLogic
	private Integer isDeleted;

}
