package com.bj.springcloud.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return null;
    }
    @RequestMapping("/error")
    public @ResponseBody String error(){
        ZuulException exception = (ZuulException) RequestContext.getCurrentContext().getThrowable();
        return exception.nStatusCode+exception.getMessage();
    }
}
