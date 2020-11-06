package com.sdm.auth.service;

import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;

import java.util.List;

/**
 * 角色业务处理类
 */
public interface RoleManageService {

    /**
     * 获取角色数据
     * @param sysRole
     * @return
     */
    public List<SysRoleDTO> getRoleListbyAll(SysRole sysRole);

    /**
     *
     * @param sysRole
     * @return
     */
    public SysRole saveSysRole(SysRole sysRole);

}
