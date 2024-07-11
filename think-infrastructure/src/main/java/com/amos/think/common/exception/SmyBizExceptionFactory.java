package com.amos.think.common.exception;

import com.amos.think.common.enums.ErrorEnum;

public class SmyBizExceptionFactory {

	public static SmyBizException bizException(ErrorEnum errorEnum) {
		return new SmyBizException(errorEnum);
	}

	public static SmyBizException bizException(ErrorEnum errorEnum, String errorMessage) {
		return new SmyBizException(errorEnum, errorMessage);
	}

}
