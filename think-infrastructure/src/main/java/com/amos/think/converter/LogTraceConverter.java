/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.amos.think.converter;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.amos.think.common.util.TraceIdUtil;

public class LogTraceConverter extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent iLoggingEvent) {
		return TraceIdUtil.getThreadTraceId();
	}
}