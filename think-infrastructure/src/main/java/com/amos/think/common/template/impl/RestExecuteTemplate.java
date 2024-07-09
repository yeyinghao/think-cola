package com.amos.think.common.template.impl;

import com.amos.think.common.constant.LoggerConstant;
import com.amos.think.common.enums.BaseEnum;
import com.amos.think.common.template.util.ExecuteTemplateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * 执行模板实现
 *
 * @author yeyinghao
 * @date 2024/04/19
 */
@Slf4j(topic = LoggerConstant.REST_MONITOR_LOGGER)
public class RestExecuteTemplate {

	public static <R> R execute(BaseEnum baseEnum, Supplier<R> supplier) {
		return ExecuteTemplateUtil.execute(log, baseEnum, supplier);
	}

	public static void execute(BaseEnum baseEnum, Runnable runnable) {
		ExecuteTemplateUtil.execute(log, baseEnum, runnable);
	}

}
