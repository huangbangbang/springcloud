package com.bj.springcloud.hystrix;

import com.bj.springcloud.model.User;
import com.bj.springcloud.sercice.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFallback implements TestService {
    @Override
    public String test() {
        return "test hystrix";
    }

    @Override
    public String testParams01(String name, Integer age) {
        return "test hystrix";
    }

    @Override
    public String testParams02(User user) {
        return "test hystrix";
    }

    @Override
    public User testReturnUser() {
        return null;
    }

    @Override
    public List<User> testReturnList() {
        return null;
    }
}
