package com.bj.springcloud.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println(10/0);
        return "hystrix eureka provider";
    }

    @RequestMapping("/test02")
    public String test02() throws InterruptedException {
        Thread.sleep(4000);
        return "hystrix eureka provider";
    }

    @RequestMapping("/test03")
    public String test03(){
        System.out.println(10/0);
        return "hystrix eureka provider";
    }

    @RequestMapping("/test04")
    public String test04(){
        System.out.println(10/0);
        return "hystrix eureka provider";
    }
}
