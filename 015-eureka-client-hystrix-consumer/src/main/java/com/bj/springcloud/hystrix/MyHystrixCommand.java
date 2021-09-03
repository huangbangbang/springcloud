package com.bj.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class MyHystrixCommand extends HystrixCommand {
    private RestTemplate restTemplate;
    private String url;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate, String url) {
        super(setter);
        this.restTemplate=restTemplate;
        this.url=url;
    }

    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject(url,Object.class);
    }

    @Override
    protected Object getFallback() {
        System.out.println(super.getFailedExecutionException().getClass());
        System.out.println(super.getFailedExecutionException().getMessage());
        return "my hystrix";
    }
}
