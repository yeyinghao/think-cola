package com.amos.think.user.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.amos.think.user.api.UserManager;
import com.amos.think.user.command.UserRegisterCmdExe;
import com.amos.think.user.command.query.UserInfoQueryExe;
import com.amos.think.user.dto.UserRegisterCmd;
import com.amos.think.user.dto.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户相关
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@Service
@CatchAndLog
public class UserManagerImpl implements UserManager {

    /**
     * xxxExe 避免 Service 膨胀利器
     */
    @Autowired
    private UserRegisterCmdExe userRegisterCmdExe;
    @Autowired
    private UserInfoQueryExe userInfoQueryExe;

    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }


}
