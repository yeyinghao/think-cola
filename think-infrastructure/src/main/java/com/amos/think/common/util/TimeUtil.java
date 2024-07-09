/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.12
 */

package com.amos.think.common.util;


import com.amos.think.common.constant.CommConstant;

public class TimeUtil {

	/**
	 * 获得Cost时间
	 *
	 * @param startTime 开始时间
	 * @return {@link String}
	 */
	public static String getCostTime(long startTime) {
		return (System.currentTimeMillis() - startTime) + CommConstant.COST_TIME_MILL_SECOND;
	}
}
