package com.sdm.analysis;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class Test {

    @RequestMapping("/add")
    @ResponseBody
    public String addUser() {
        return "Hello World!!!!!!!!" ;
    }

}
