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


    @PostMapping ("/currentUser")
    public  String  currentUser(HttpServletRequest request,@RequestBody Map<String, String> date) {
        String userid = date.get("userid");

        System.out.println("currentUser:----"+userid);

        if(StringUtils.isEmpty(userid)||userid.equals("null")){
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("name", "admin");
        result.put("userid", userid);
        result.put("avatar", "https://shoudanmaodata.oss-cn-shanghai.aliyuncs.com/logo/logo_%E7%94%BB%E6%9D%BF%201.png");
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
