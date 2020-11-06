package com.sdm.auth.dao;

import com.sdm.auth.model.po.SysUser;

import java.util.List;

public interface SysUserDao {
    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(Long id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysUser sysUser);

    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SysUser findById(Long id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllList(SysUser sysUser);

    /**
     *
     * @Description  返回用户信息角色信息
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllRoleList(SysUser sysUser);

    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysUser sysUser);
}