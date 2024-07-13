package com.amos.think.adapter.web;

import com.amos.think.common.response.SmyResponse;
import com.amos.think.user.api.UserManager;
import com.amos.think.user.dto.UserRegisterCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return SmyResponse.buildSuccess();
    }

}

