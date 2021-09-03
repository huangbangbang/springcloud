package com.bj.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://004-eureka-client-provider/test",String.class);
        String body =result.getBody();
        return "eureka consumer   "+body;
    }
}
