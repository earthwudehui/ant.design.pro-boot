package com.sdm.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring/applicationContext-transaction.xml")
@SpringBootApplication//SpringBoot入口配置
@ServletComponentScan//SpringBoot Servlet 扫描
@MapperScan("com.sdm.auth.dao") //mybatis 将项目中对应的Dao类的路径加进来就可以了,不启用该注解需要再DAO上采用@Mapper注解
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
