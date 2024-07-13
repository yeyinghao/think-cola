package com.amos.think.user.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.amos.think.domain.user.UserEntity;
import com.amos.think.domain.user.gateway.UserGateway;
import com.amos.think.user.assembler.UserAssembler;
import com.amos.think.user.dto.data.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户信息查询
 *
 * @author daoyuan
 * @date 2021/2/14 23:27
 */
@Component
public class UserInfoQueryExe {

    @Autowired
    private UserGateway userGateway;

    public SingleResponse<UserVO> execute(Long id) {
        UserEntity userEntity = userGateway.findById(id);
        if (Objects.isNull(userEntity)) {
        }

        return SingleResponse.of(UserAssembler.toValueObject(userEntity));
    }

}
