package com.bj.springcloud.controller;


import com.bj.springcloud.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println(10/0);
        return "eureka feign provider";
    }

    @RequestMapping("/testParams01")
    public String testParams01(String name,Integer age){
        return "eureka feign provider" +name+age;
    }

    @RequestMapping("/testParams02")
    public String testParams02(@RequestBody User user){
        return "eureka feign provider" +user.getName()+user.getAge();
    }

    @RequestMapping("/testReturnUser")
    public Object testReturnUser(){
        User user = new User("jack",89);
        return user;
    }

    @RequestMapping("/testReturnList")
    public Object testReturnList(){
        User user = new User("jack",89);
        User user1 = new User("jack",89);
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        return list;
    }
}

