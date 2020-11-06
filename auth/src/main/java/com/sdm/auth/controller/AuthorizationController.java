package com.sdm.auth.controller;


import com.sdm.auth.model.dto.LoginCodeEnumDTO;
import com.sdm.auth.model.dto.LoginPropertiesDTO;
import com.wf.captcha.base.Captcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/api/author")
@RestController
public class AuthorizationController {

    @Resource
    private LoginPropertiesDTO loginPropertiesDTO;

    @GetMapping("/getcaptcha")
    public ModelAndView getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取运算的结果
        Captcha captcha = loginPropertiesDTO.getCaptcha();
        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String uuid = UUID.randomUUID().toString();
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == LoginCodeEnumDTO.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }

        Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};

        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("captcha.png", "UTF-8"));
        // 实现文件下载
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(captcha.toBase64().substring(22))));//特殊编码头（data:image/png;base64,）
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
