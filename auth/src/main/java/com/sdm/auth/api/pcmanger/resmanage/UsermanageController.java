package com.sdm.auth.api.pcmanger.resmanage;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/resmanage/usermanage/")
@RestController
public class UsermanageController {


    @PostMapping("/queryAdmin")
    public Map<String, Object> queryAdmin(HttpServletRequest request, @RequestBody Map<String, Object> date) {

        String current = String.valueOf(date.get("current"));
        String pageSize = String.valueOf(date.get("pageSize"));
        String sorter =String.valueOf( date.get("sorter"));
        //filter
//        filter?: { [key: string]: any[] };
//        sorter?: { [key: string]: any };

        List<Map<String,Object>> list =new ArrayList();
        Map<String, Object> map1 = new HashMap<String, Object>();

        map1.put("avatar","https://gw.alipayobjects.com/zos/rmsportal/udxAbMEhpwthVVcjLXik.png");
        map1.put("callNo",372);
        map1.put("createdAt","2020-10-22T07:16:57.553Z");
        map1.put("desc","4");
        map1.put("href","https://ant.design");
        map1.put("key", 10);
        map1.put("name","4");
        map1.put("owner","曲丽丽");
        map1.put("progress",89);
        map1.put("status","1");
        map1.put("updatedAt","2020-10-22T07:16:57.553Z");


        list.add(map1);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data",list);
        result.put("total",1);
        result.put("success",true);
        result.put("pageSize","1");
        result.put("current",1);
        return result;
    }
}
