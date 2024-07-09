package com.amos.think.common.template.util;


import com.amos.think.common.constant.CommConstant;
import com.amos.think.common.enums.BaseEnum;
import com.amos.think.common.exception.BizException;
import com.amos.think.common.util.LoggerUtil;
import com.amos.think.common.util.TimeUtil;
import org.slf4j.Logger;

import java.util.function.Supplier;

/**
 * 执行模板
 *
 * @author yeyinghao
 * @date 2024/04/11
 */
public class ExecuteTemplateUtil {

	/**
	 * 执行
	 *
	 * @param baseEnum 基础枚举
	 * @param supplier 供应商
	 * @return {@link R}
	 */
	public static <R> R execute(Logger logger, BaseEnum baseEnum, Supplier<R> supplier) {
		long startTime = System.currentTimeMillis();
		String result = CommConstant.N;
		try {
			result = CommConstant.Y;
			return supplier.get();
		} catch (BizException e) {
			result = e.getResult();
			throw e;
		} finally {
			LoggerUtil.info(logger, baseEnum, result, TimeUtil.getCostTime(startTime));
		}
	}

	/**
	 * 执行
	 *
	 * @param baseEnum 基础枚举
	 * @param runnable 可运行
	 */
	public static void execute(Logger logger, BaseEnum baseEnum, Runnable runnable) {
		long startTime = System.currentTimeMillis();
		String result = CommConstant.N;
		try {
			runnable.run();
			result = CommConstant.Y;
		} catch (BizException e) {
			result = e.getResult();
			throw e;
		} finally {
			LoggerUtil.info(logger, baseEnum, result, TimeUtil.getCostTime(startTime));
		}
	}
}
