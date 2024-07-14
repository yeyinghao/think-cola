package com.amos.think.common.exception;

import com.amos.think.common.enums.ErrorEnum;

public class SmyBizExceptionFactory {

	public static SmyBizException bizException(ErrorEnum errorEnum) {
		return new SmyBizException(errorEnum);
	}

	public static SmyBizException bizException(ErrorEnum errorEnum, String errorMessage) {
		return new SmyBizException(errorEnum, errorMessage);
	}

	public static SmyBizException bizException(ErrorEnum errorEnum, Throwable ex) {
		return new SmyBizException(errorEnum, ex);
	}

	public static SmyBizException bizException(ErrorEnum errorEnum, String errorMessage, Throwable ex) {
		return new SmyBizException(errorEnum, errorMessage, ex);
	}

}
