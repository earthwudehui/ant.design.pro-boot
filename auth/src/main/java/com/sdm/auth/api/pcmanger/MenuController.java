package com.sdm.auth.api.pcmanger;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/menu")
@Component
@RestController
public class MenuController {

    @PostMapping("/getMenu")
    public Map<String, Object> getmenu(HttpServletRequest request,@RequestBody Map<String, String> date) {
        String token = date.get("userid");
        System.out.print("getmenu:----"+token);

        if(StringUtils.isEmpty(token)||token.equals("null")){
            return null;
        }
        /**
         {
         path: '/welcome',
         name: 'welcome',
         icon: 'smile',
         component: './Welcome',
         },
         {
         path: '/admin',    // 路径
         name: 'admin',
         icon: 'crown',     // 图标
         access: 'canAdmin',  // 权限
         component: './Admin',  //配置 location 和 path 匹配后用于渲染的 React 组件路径。可以是绝对路径，也可以是相对路径，如果是相对路径，会从 src/pages 开始找起。
         routes: [             //配置子路由，通常在需要为多个路径增加 layout 组件时使用。
         {
         path: '/admin/sub-page',
         name: 'sub-page',
         icon: 'smile',
         component: './Welcome',
         },
         ],
         },
         {
         name: 'list.table-list',
         icon: 'table',
         path: '/list',
         component: './ListTableList',
         },

         {
         name: '分析页',
         icon: 'smile',
         path: '/dashboardanalysis',
         component: './DashboardAnalysis',
         },
         */
        List<Map<String, Object>> list = new ArrayList<>();

        //1）登录路由
        Map<String, Object> resultLogin = new HashMap<String, Object>();
        resultLogin.put("path","/user");
        resultLogin.put("layout","false");

        List<Map<String, Object>> listLogin = new ArrayList<>();

        Map<String, Object> resultLoginChildren = new HashMap<String, Object>();
        resultLoginChildren.put("name","login");
        resultLoginChildren.put("path","user/login");
        resultLoginChildren.put("component","./user/login");
        listLogin.add(resultLoginChildren);
        resultLogin.put("routes",listLogin);
        list.add(resultLogin);

        // 2)首页
        Map<String, Object> resultfirst = new HashMap<String, Object>();
        resultfirst.put("path","/");
        resultfirst.put("redirect","/welcome");
        list.add(resultfirst);

        // 3）功能菜单
        Map<String, Object> resultbuz = new HashMap<String, Object>();
        resultbuz.put("path","/welcome");
        resultbuz.put("name","welcome");
        resultbuz.put("icon","smile");
        resultbuz.put("component","./Welcome");
        list.add(resultbuz);

        //4）404
        Map<String, Object> result404 = new HashMap<String, Object>();
        result404.put("component","./404");
        list.add(result404);


        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("routes",list);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data",resultData);
        result.put("success",true);
        return result;
    }
}
