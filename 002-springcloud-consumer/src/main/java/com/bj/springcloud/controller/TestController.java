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
        //RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8081/test",String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getHeaders());
        String body =result.getBody();
        return "consumer   "+body;
    }
}
