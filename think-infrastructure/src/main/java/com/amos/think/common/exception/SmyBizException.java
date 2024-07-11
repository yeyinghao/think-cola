package com.amos.think.common.exception;

import cn.hutool.core.util.StrUtil;
import com.amos.think.common.constant.CommConstant;
import com.amos.think.common.constant.HttpConstant;
import com.amos.think.common.enums.CommErrorEnum;
import com.amos.think.common.enums.ErrorEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 业务异常
 *
 * @author yeyinghao
 * @date 2023/08/01
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class SmyBizException extends RuntimeException {

	/**
	 * http状态
	 */
	private static final List<Integer> HTTP_STATUSES = Arrays.asList(HttpConstant.INTERNAL_SERVER_ERROR, HttpConstant.SERVICE_UNAVAILABLE);

	/**
	 * 基本枚举
	 */
	private final ErrorEnum errorEnum;

	/**
	 * 异常描述
	 */
	private String message;

	public SmyBizException(Throwable ex) {
		super(ex);
		this.errorEnum = CommErrorEnum.SYSTEM_ERROR;
	}

	public SmyBizException(String message) {
		super(message);
		this.errorEnum = CommErrorEnum.BIZ_ERROR;
		this.message = message;
	}

	/**
	 * 业务异常
	 *
	 * @param errorEnum 基本枚举
	 * @param message   子消息
	 */
	public SmyBizException(ErrorEnum errorEnum, String message) {
		super(errorEnum.getDescription());
		this.errorEnum = errorEnum;
		this.message = message;
	}

	public SmyBizException(ErrorEnum errorEnum, String... message) {
		super(errorEnum.getDescription());
		this.errorEnum = errorEnum;
		this.message = getMessage(message);
	}

	private static String getMessage(String... message) {
		if (Objects.nonNull(message)) {
			StringBuilder msg = new StringBuilder();
			Arrays.asList(message).forEach(item -> {
				msg.append(CommConstant.DELIMITER).append(item);
			});
			return msg.toString();
		}
		return null;
	}

	public SmyBizException(ErrorEnum errorEnum, Throwable ex) {
		super(errorEnum.getDescription(), ex);
		this.errorEnum = errorEnum;
	}

	public SmyBizException(String messae, Throwable ex) {
		super(messae, ex);
		this.errorEnum = CommErrorEnum.SYSTEM_ERROR;
		this.message = messae;
	}

	public SmyBizException(ErrorEnum errorEnum, String message, Throwable ex) {
		super(message, ex);
		this.errorEnum = errorEnum;
		this.message = message;
	}

	public String getResult() {
		if (this.errorEnum == null) {
			return CommConstant.Y;
		}
		return HTTP_STATUSES.contains(this.errorEnum.getCode()) ? CommConstant.Y : CommConstant.N;
	}

	/**
	 * 消息
	 *
	 * @return {@link String }
	 */
	public String message() {

		if (this.errorEnum != null && StrUtil.isNotBlank(this.message)) {
			return this.errorEnum.getDescription() + CommConstant.COLON + this.message;
		}

		if (this.errorEnum != null && StrUtil.isBlank(this.message)) {
			return this.errorEnum.getDescription();
		}

		if (this.errorEnum == null && StrUtil.isNotBlank(this.message)) {
			return this.message;
		}

		return CommErrorEnum.BIZ_ERROR.getDescription();
	}
}
