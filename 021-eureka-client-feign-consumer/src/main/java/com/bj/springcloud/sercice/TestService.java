package com.bj.springcloud.sercice;


import com.bj.springcloud.hystrix.MyFallback;
import com.bj.springcloud.hystrix.MyFallbackFactory;
import com.bj.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "020-EUREKA-CLIENT-FEIGN-PROVIDER",fallback = MyFallback.class)
@FeignClient(name = "020-EUREKA-CLIENT-FEIGN-PROVIDER",fallbackFactory = MyFallbackFactory.class)
public interface TestService {
    @RequestMapping("/test")
    String test();

    @RequestMapping("/testParams01")
    String testParams01(@RequestParam String name,@RequestParam Integer age);

    @RequestMapping("/testParams02")
    String testParams02(@RequestBody User user);

    @RequestMapping("/testReturnUser")
    User testReturnUser();

    @RequestMapping("/testReturnList")
    List<User> testReturnList();
}
