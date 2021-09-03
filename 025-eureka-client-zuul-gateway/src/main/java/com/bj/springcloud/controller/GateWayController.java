package com.bj.springcloud.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {


    @RequestMapping("/api/local")
    public Object test(){
        return "zuul controller";
    }
}
