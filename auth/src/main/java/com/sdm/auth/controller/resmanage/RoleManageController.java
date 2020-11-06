package com.sdm.auth.controller.resmanage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.service.RoleManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理类
 */
@RequestMapping("/api/rolemanage")
@RestController
public class RoleManageController {

    @Resource
    private RoleManageService roleManageService;
    /**
     * 角色管理
     * @return
     */
    @PostMapping("/getRoleList")
    public Map<String, Object> getRoleList(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        //1) 获取参数
        Map<String, Object> params =  (Map<String, Object>)data.get("params");
        int current = (int)params.get("current");
        int pageSize = (int)params.get("pageSize");
        String sorter = String.valueOf( params.get("sorter"));

        //2）分页
        PageHelper.startPage(current , pageSize);//1,10 获取第1页，10条内容，默认查询总数count
        SysRole sysRole = new SysRole();
        if(params.get("description")!=null){
            sysRole.setDescription(params.get("description").toString());
        }
        // 3）获取业务数据
        List<SysRoleDTO> list = roleManageService.getRoleListbyAll(sysRole);

        // 4) 处理分页
        PageInfo<SysRoleDTO> page = new PageInfo<SysRoleDTO>(list);//PageInfo 包含分页信息

        // 5）返回值
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data",list);
        result.put("total",page.getTotal());
        result.put("success",true);
        result.put("pageSize",page.getPageSize());
        result.put("current",page.getSize());
        return result;
    }

    /**
     * 新增角色
     * @param request
     * @param sysRole
     */
    @PostMapping("/saveRole")
    public String saveRole(HttpServletRequest request, @RequestBody SysRole sysRole) {
        sysRole = roleManageService.saveSysRole(sysRole);
        return "ok";
    }

}
