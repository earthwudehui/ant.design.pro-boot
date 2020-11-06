package com.sdm.auth.controller.resmanage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/hello")  
public class HelloController {

    @RequestMapping("/sts")
    public String helloworld(){  
        return "使用spring-tool-suite插件";  
    }  
}

