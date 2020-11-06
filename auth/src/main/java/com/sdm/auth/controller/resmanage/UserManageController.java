package com.sdm.auth.controller.resmanage;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdm.auth.model.dto.SysUserDTO;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.service.UserManageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理类
 */
@RequestMapping("/api/resmanage/usermanage/")
@RestController
public class UserManageController {

    @Resource
    private UserManageService userManageService;

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/queryUser")
    public Map<String, Object> queryUser(HttpServletRequest request, @RequestBody Map<String, Object> data) {
        UserQuery userQuery= modelMapper.map(data.get("params"), UserQuery.class);
        //1）分页
        PageHelper.startPage(userQuery.getCurrent() ,userQuery.getPageSize());//1,10 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据

        List<SysUserDTO> list = userManageService.getUserListByAllRole(userQuery);

        // 3) 处理分页
        PageInfo<SysUserDTO> page = new PageInfo<SysUserDTO>(list);//PageInfo 包含分页信息

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
     * 新增用户
     * @param request
     * @param userQuery
     * @return
     */
    @PostMapping("/saveUser")
    public String saveUser(HttpServletRequest request, @RequestBody UserQuery userQuery) {
        userManageService.saveSysUser(userQuery);
        return "ok";
    }

    /**
     * 获取用户详细信息
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryUserById")
    public SysUser queryUserById(HttpServletRequest request,Long id) {
        return userManageService.getUserById(id);
    }

    /**
     * 修改用户信息
     * @param request
     * @param userQuery
     * @return
     */
    @PostMapping("/updateUser")
    public SysUser updateUser(HttpServletRequest request,@RequestBody UserQuery userQuery) {
        return userManageService.updateSysUser(userQuery);
    }

    /**
     * 修改用户状态
     * @param request
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateSysUserDisable")
    public SysUser updateSysUserDisable(HttpServletRequest request,Long id,String status) {
        return userManageService.updateSysUserDisable(id,status);
    }
}
