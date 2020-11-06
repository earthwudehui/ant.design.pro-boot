/**
 * CopyRight © 2018 上海分忧. All Rights Reserved
 * 2020-10-27 Created
 */
package com.sdm.auth.model.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Description: 系统菜单表
 * @see: 此处填写需要参考的类
 * @version 2020年10月27日 下午 15:36:50
 * @autor 
 */
@Data
public class SysMenuDTO {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 图标
     */
    private String icon;

    /**
     * 编码
     */
    private String path;

    /**
     * 请求连接
     */
    private String component;

    /**
     * 是否在菜单中显示（1：显示；0：不显示）
     */
    private String isShow;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上级菜单id
     */
    private Long parentMenuId;

    private Date deletedat;

}