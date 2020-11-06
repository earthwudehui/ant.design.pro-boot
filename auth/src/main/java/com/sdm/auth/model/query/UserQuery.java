package com.sdm.auth.model.query;

import lombok.Data;

/**
 * 管理用查询Query
 */

@Data
public class UserQuery extends PageInfoQuery{

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 角色
     */
    private String roleId;

    /**
     * 密码
     */
    private String password;

}

