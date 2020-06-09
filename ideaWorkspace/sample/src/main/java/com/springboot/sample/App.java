package com.springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class);
        System.err.println("项目启动成功,小火箭飞起！！");
    }
}
