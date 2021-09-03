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
        String result = restTemplate.getForObject("http://025-eureka-client-zuul-gateway/test",String.class);

        return "eureka no zuul consumer   "+result;
    }

    @RequestMapping("/test02")
    public String test02(String token){
        String result = restTemplate.getForObject("http://025-eureka-client-zuul-gateway/api-zuul/test?token="+token,String.class);

        return "eureka  zuul consumer   "+result;
    }
}
