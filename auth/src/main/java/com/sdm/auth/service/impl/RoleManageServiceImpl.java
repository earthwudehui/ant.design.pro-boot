package com.sdm.auth.service.impl;

import com.sdm.auth.dao.SysRoleDao;
import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.service.RoleManageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleManageServiceImpl implements RoleManageService {

    @Resource
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRoleDTO> getRoleListbyAll(SysRole sysRole) {
        List<SysRole> list = sysRoleDao.findAllList(sysRole);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(list,new TypeToken<List<SysRoleDTO>>() {}.getType());
    }

    @Override
    public SysRole saveSysRole(SysRole sysRole) {
        int i = sysRoleDao.insert(sysRole);
        if (i==0){

        }
        return sysRole;
    }
}
