package com.sdm.auth.api.pcmanger;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/login")
@RestController
public class LoginController {
    /**
     *  ant.d.pro  登录请求
     * @param request
     * @return
     */
    @PostMapping ("/account")
    public  String  fakeAccountLogin(HttpServletRequest request,@RequestBody Map<String, String> date) {
        Map<String,Object> result = new HashMap<>();
        String userName = date.get("username");
        String password = date.get("password");
        String account = date.get("account");

        result.put("type","account");
        if (StringUtils.equals(userName,"admin")&&StringUtils.equals(password,"a123456")){
            result.put("status","ok");
            result.put("currentAuthority","admin");
            result.put("token","a123456");
        }else if (StringUtils.equals(userName,"user")&&StringUtils.equals(password,"a123456")){
            result.put("status","ok");
            result.put("currentAuthority","user");
            result.put("token","a123456");
        }else{
            result.put("status","error");
            result.put("currentAuthority","guest");
            result.put("errMsg", "账号错误");
        }
        System.out.println(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @RequestMapping("/captcha")
    @ResponseBody
    public String getFakeCaptcha() {
        System.out.println("captcha");

        return "Hello World!!!!!!!!" ;
    }


    /**
     *  ant.d.pro  退出请求
     * @param request
     * @return
     */
    @PostMapping ("/outLogin")
    public  String  outLogin(HttpServletRequest request,@RequestBody Map<String, String> date) {

        String token = date.get("userid");
        System.out.println("outLogin:----"+token);

        if(org.springframework.util.StringUtils.isEmpty(token)||token.equals("null")){
            return null;
        }else{

        }
        return "ok";
    }
}
