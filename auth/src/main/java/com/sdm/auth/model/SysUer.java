package com.sdm.auth.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUer {
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 创建人ID
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 账号状态 0 正常 1 禁用
     */
    private String status;

    /**
     * 最近登陆IP
     */
    private String loginIp;

    /**
     * 最近登陆日期
     */
    private Date loginDate;

    /**
     * 最后更新人ID
     */
    private String updateBy;

    /**
     * 最后更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 头像地址
     */
    private String photo;


}