package com.lth.weather.controller;

import com.lth.weather.aspect.ExecutionTarget;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    @ExecutionTarget
    public String hello() {
        System.out.println("方法体执行了");
        return "hello";
    }

    @GetMapping("/error")
    public String error(){
        int a = 1/0;
        System.out.println("闭包报错");
        return "报错了";
    }
}
