package com.amos.think.integration.satoken.handler;


import cn.dev33.satoken.exception.NotLoginException;
import com.amos.think.common.enums.CommErrorEnum;
import com.amos.think.common.response.SmyResponse;
import com.amos.think.common.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理程序
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class SaTokenExceptionHandler {

	/**
	 * sa-token-未登录异常
	 *
	 * @param e e
	 * @return {@link SmyResponse}<{@link String}>
	 */
	@ExceptionHandler(NotLoginException.class)
	public SmyResponse notLoginExceptionHandler(NotLoginException e) {
		LoggerUtil.info(log, e.getMessage());
		return SmyResponse.buildFailure(CommErrorEnum.FORBIDDEN, "禁止访问");
	}

}
