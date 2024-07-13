package com.amos.think.user.model;

import com.amos.think.integration.dal.model.BaseDP;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * UserDO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/1/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseDP {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 姓名（较常用，故放在用户主表）
     */
    private String name;

    /**
     * 附加信息主键ID
     */
    private Long infoId;

}
