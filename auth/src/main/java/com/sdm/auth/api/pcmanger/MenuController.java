package com.sdm.auth.api.pcmanger;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/menu")
@Component
@RestController
public class MenuController {

    @RequestMapping("/getmenu")
    @ResponseBody
    public String getmenu(HttpServletRequest request) {
        System.out.println("getmenu");
        return "Hello World!!!!!!!!" ;
    }
}
