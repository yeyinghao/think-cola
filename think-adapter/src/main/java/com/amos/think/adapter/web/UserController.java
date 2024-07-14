package com.amos.think.adapter.web;

import com.amos.think.common.enums.CommErrorEnum;
import com.amos.think.common.exception.SmyAssert;
import com.amos.think.common.response.SmyResponse;
import com.amos.think.user.api.UserManager;
import com.amos.think.user.dto.UserRegisterCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserManager userService;


	@PostMapping(value = "/register")
	public SmyResponse register(@RequestBody UserRegisterCmd cmd) {
		userService.register(cmd);
		SmyAssert.isTrue(false, CommErrorEnum.ILLEGAL_PARAMETER, "失败了={}", "第一次");
		return SmyResponse.buildSuccess();
	}

}

