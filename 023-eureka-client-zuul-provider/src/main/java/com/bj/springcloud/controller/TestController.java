package com.bj.springcloud.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "eureka zuul provider";
    }

    @RequestMapping("/test02")
    public String test02(){
        return "eureka zuul provider";
    }
}
