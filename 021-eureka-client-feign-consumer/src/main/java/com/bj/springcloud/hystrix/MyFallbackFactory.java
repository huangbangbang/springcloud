package com.bj.springcloud.hystrix;

import com.bj.springcloud.model.User;
import com.bj.springcloud.sercice.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyFallbackFactory implements FallbackFactory<TestService>{
    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public String test() {
                System.out.println(throwable.getClass());
                System.out.println(throwable.getMessage());
                System.out.println(throwable.getCause());
                return "test hystrix";
            }

            @Override
            public String testParams01(String name, Integer age) {
                return null;
            }

            @Override
            public String testParams02(User user) {
                return null;
            }

            @Override
            public User testReturnUser() {
                return null;
            }

            @Override
            public List<User> testReturnList() {
                return null;
            }
        };
    }
}
