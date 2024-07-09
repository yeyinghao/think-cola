/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.12
 */

package com.amos.think.common.util;

import cn.hutool.core.util.RandomUtil;

/**
 * 签名工具类
 *
 * @author yeyinghao
 * @date 2023/12/25
 */
public class CodeUtil {

	/**
	 * 生成指定位数的字符串,不包含数字,
	 * 返回的str都大写
	 */
	public static String randomString(Integer length) {
		return RandomUtil.randomStringWithoutStr(length, "0123456789").toUpperCase();
	}
}
