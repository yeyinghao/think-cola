/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.amos.think.handler;

import com.amos.think.common.enums.CommErrorEnum;
import com.amos.think.common.exception.SmyBizExceptionFactory;
import com.amos.think.common.response.SmyResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

/**
 * http状态代码增强
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@SuppressWarnings({"NullableProblems", "rawtypes"})
@ControllerAdvice
public class HttpStatusCodeAdvice implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return returnType.getParameterType().isAssignableFrom(SmyResponse.class);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof SmyResponse) {
			Integer status = ((SmyResponse) body).getCode();
			HttpStatus httpStatus = HttpStatus.resolve(status);
			response.setStatusCode(Optional.ofNullable(httpStatus).orElseThrow(() -> SmyBizExceptionFactory.bizException(CommErrorEnum.SYSTEM_ERROR)));
		}
		return body;
	}
}
