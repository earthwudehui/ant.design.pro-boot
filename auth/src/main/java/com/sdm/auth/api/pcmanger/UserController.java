package com.sdm.auth.api.pcmanger;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserController {


    @PostMapping ("/currentUser")
    public  String  currentUser(HttpServletRequest request,@RequestBody Map<String, String> date) {
        String userid = date.get("userid");

        System.out.println("currentUser:----"+userid);

        if(StringUtils.isEmpty(userid)||userid.equals("null")){
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("access", "admin");
        result.put("name", "admin");
        result.put("userid", userid);
        result.put("avatar", "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");

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
        // 3.1
        Map<String, Object> resultbuz1 = new HashMap<String, Object>();
        resultbuz1.put("path","/welcome");
        resultbuz1.put("name","欢迎");
        resultbuz1.put("icon","smile");
        resultbuz1.put("component","./Welcome");
        list.add(resultbuz1);

        // 3.2
        Map<String, Object> resultbuz2 = new HashMap<String, Object>();
        resultbuz2.put("path","/admin");
        resultbuz2.put("name","管理");
        resultbuz2.put("icon","crown");
        resultbuz2.put("access","canAdmin");//权限
        resultbuz2.put("component","./Admin");

        List<Map<String, Object>> buzlist2 = new ArrayList<>();

        Map<String, Object>buzChildren2 = new HashMap<String, Object>();
        resultLoginChildren.put("name","子菜单");
        resultLoginChildren.put("path","/admin/sub-page");
        resultLoginChildren.put("component","./Welcome");
        buzlist2.add(buzChildren2);
        resultbuz2.put("routes",listLogin);
        list.add(resultbuz2);

        //4）404
        Map<String, Object> result404 = new HashMap<String, Object>();
        result404.put("component","./404");
        list.add(result404);


        Map<String, Object> resultData = new HashMap<String, Object>();
        resultData.put("routes",list);
        result.put("menudata",list);
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("data",resultData);
//        result.put("success",true);

        System.out.println(result);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/queryCurrent")
    @ResponseBody
    public String queryCurrent() {
        System.out.println("queryCurrent");

        return "Hello World!!!!!!!!" ;
    }
    @RequestMapping("/notices")
    @ResponseBody
    public String notices() {
        System.out.println("notices");

        return "Hello World!!!!!!!!" ;
    }
}
