package com.sdm.auth.service.impl;

import com.sdm.auth.dao.SysUserDao;
import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.dto.SysUserDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.service.UserManageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<SysUserDTO> getUserListByAllRole(UserQuery userQuery) {
        return sysUserDao.findAllRoleList(modelMapper.map(userQuery, SysUser.class));
    }

    @Override
    public SysUser saveSysUser(UserQuery userQuery) {
        SysUser sysUser = modelMapper.map(userQuery, SysUser.class);
        sysUser.getPassword();//加密处理
        sysUser.setCreateDate(new Date());
        sysUser.setStatus("0");
        int i = sysUserDao.insert(sysUser);
        return sysUser;
    }

    @Override
    public SysUser getUserById(Long id){
        return sysUserDao.findById(id);
    }

    @Override
    public SysUser updateSysUser(UserQuery userQuery) {
        SysUser sysUser = modelMapper.map(userQuery, SysUser.class);
        sysUser.setUpdateDate(new Date());
        SysUser sysUserDB =sysUserDao.findById(sysUser.getId());
        if(sysUserDB==null){

        }
        sysUser.setUpdateDate(new Date());
        int i = sysUserDao.update(sysUser);
        return sysUser;
    }

    @Override
    public SysUser updateSysUserDisable(Long id,String status) {
        SysUser sysUser = sysUserDao.findById(id);
        sysUser.setStatus(status);
        int i = sysUserDao.update(sysUser);
        return sysUser;
    }

    @Override
    public SysUser updateSysUserRole(Long id, List<SysRole> roleList) {
        return null;
    }
}
