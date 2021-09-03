package com.bj.springcloud.controller;

import com.bj.springcloud.model.User;
import com.bj.springcloud.sercice.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService service;
    @RequestMapping("/test")
    public String test(){

        String result = service.test();
        return "feign consumer   "+result;
    }

    @RequestMapping("/testParams01")
    public String testParams01(){

        String result = service.testParams01("jack",33);
        return "feign consumer   "+result;
    }

    @RequestMapping("/testParams02")
    public String testParams02(){
        User user = new User("jack",34);
        String result = service.testParams02(user);
        return "feign consumer   "+result;
    }

    @RequestMapping("/testReturnUser")
    public String testReturnUser(){
        User result = service.testReturnUser();
        return "feign consumer   "+result;
    }

    @RequestMapping("/testReturnList")
    public String testReturnList(){
        List<User> result = service.testReturnList();
        for (User u:result
             ) {
            System.out.println(u);
        }
        return "feign consumer   "+result;
    }
}
