package com.springboot.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//Controller
public class indexController {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${sex}")
    private String sex;
    @Value("${server.port}")
    private volatile String port;

    @RequestMapping("/")
    public String index(){
        System.out.println(name+age+sex+port);
//        return "user/user";
//        return name+age+sex+ port;
        return "第一个springboot测试项目";
    }

}
