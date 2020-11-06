package com.sdm.auth.service;

import com.sdm.auth.model.dto.SysUserDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.query.UserQuery;

import java.util.List;

/**
 * 用户管理业务处理
 */
public interface UserManageService {

    /**
     * 获取User列表带有角色信息
     * @param userQuery
     * @return
     */
    public List<SysUserDTO> getUserListByAllRole(UserQuery userQuery);

    /**
     * 新增User
     * @param userQuery
     * @return
     */
    public SysUser saveSysUser(UserQuery userQuery);

    /**
     * id获取User
     * @param id
     * @return
     */
    public SysUser getUserById(Long id);


    /**
     * 修改User
     * @param userQuery
     * @return
     */
    public SysUser updateSysUser(UserQuery userQuery);

    /**
     * 禁用User
     * @param id
     * @param status
     * @return
     */
    public SysUser  updateSysUserDisable(Long id,String status);

    /**
     * 用户角色
     * @param id
     * @param roleList
     * @return
     */
    public SysUser updateSysUserRole(Long id, List<SysRole> roleList);

}
