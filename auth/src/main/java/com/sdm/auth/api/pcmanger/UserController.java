package com.sdm.auth.api.pcmanger;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserController {


    @GetMapping ("/currentUser")
    public  String  currentUser(HttpServletRequest request,String token) {

        System.out.println("token:----"+token);
        if(StringUtils.isEmpty(token)){
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("name", "admin");
        result.put("userid", "admin");
        result.put("avatar", "https://shoudanmaodata.oss-cn-shanghai.aliyuncs.com/logo/logo_%E7%94%BB%E6%9D%BF%201.png");
        System.out.print(result);
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
