/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.amos.think.common.model;

import com.amos.think.common.base.DP;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件信息
 *
 * @author yeyinghao
 * @date 2024/01/02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileDP extends DP {

	/**
	 * 文件名称
	 */
	public String fileName;

	/**
	 * 文件key
	 */
	public String fileKey;
}
