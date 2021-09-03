package com.bj.springcloud.controller;

import com.bj.springcloud.hystrix.MyHystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://016-eureka-client-hystrix-provider/test",String.class);
        String body =result.getBody();
        return "hystrix eureka consumer   "+body;
    }



    @RequestMapping("/test02")
    @HystrixCommand(fallbackMethod = "error" ,commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="6000")} )
    public String test02(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://016-eureka-client-hystrix-provider/test02",String.class);
        String body =result.getBody();
        return "hystrix eureka consumer   "+body;
    }

    @RequestMapping("/test03")
    @HystrixCommand(fallbackMethod = "error" ,
                    commandProperties={
                                       @HystrixProperty(
                                               name="execution.isolation.thread.timeoutInMilliseconds",
                                               value="1500")},
                    ignoreExceptions = {HttpServerErrorException.InternalServerError.class})
    public String test03(){
        //String str =null;
        //System.out.println(str.length());
        ResponseEntity<String> result = restTemplate.getForEntity("http://016-eureka-client-hystrix-provider/test03",String.class);
        String body =result.getBody();
        return "hystrix eureka consumer   "+body;
    }


    @RequestMapping("/test04")
    @HystrixCommand(fallbackMethod = "error" ,
            commandProperties={
                    @HystrixProperty(
                            name="execution.isolation.thread.timeoutInMilliseconds",
                            value="1500")},
            ignoreExceptions = {HttpServerErrorException.InternalServerError.class})
    public String test04(){
        MyHystrixCommand commend = new MyHystrixCommand(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                restTemplate,"http://016-eureka-client-hystrix-provider/test04");
        String body = (String) commend.execute();
        return "hystrix eureka consumer============"+body;
    }


    public String error(Throwable throwable){
        System.out.println(throwable.getClass());
        System.out.println(throwable.getMessage());
        return "hystrix";
    }
}
