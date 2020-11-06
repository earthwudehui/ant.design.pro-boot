/**
 * CopyRight © 2018 上海分忧. All Rights Reserved
 * 2020-10-27 Created
 */
package com.sdm.auth.dao;

import com.sdm.auth.model.po.SysRole;

import java.util.List;

public interface SysRoleDao {
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
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysRole record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SysRole findById(Long id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllList(SysRole record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysRole record);
}