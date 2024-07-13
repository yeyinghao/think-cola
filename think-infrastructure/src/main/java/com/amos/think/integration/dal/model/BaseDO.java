/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.9
 */

package com.amos.think.integration.dal.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础PO
 *
 * @author yeyinghao
 * @date 2023/09/17
 */
@Data
@ToString
public class BaseDO implements Serializable {

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 扩展信息
	 */
	private String extInfo;

	/**
	 * 状态
	 */
	/**
	 * 是否删除
	 */
	@TableLogic
	private Boolean status;
}
