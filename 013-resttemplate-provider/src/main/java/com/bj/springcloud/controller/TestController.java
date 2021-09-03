package com.bj.springcloud.controller;

import com.bj.springcloud.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/getForEntity01")
    public Object getForEntity01(){
        User user = new User(1L,"jack",23);

        return user;
    }

    @RequestMapping("/getForEntity02")
    public Object getForEntity02(){
        User user1 = new User(1L,"jack",23);
        User user2 = new User(1L,"jack",23);
        User user3 = new User(1L,"jack",23);
        User user4 = new User(1L,"jack",23);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list;
    }

    @RequestMapping("/getForEntityParams01")
    public Object getForEntityParams01(User user){
        user.setName(user.getName()+"provider");

        return user;
    }

    @RequestMapping("/getForEntityParams02")
    public Object getForEntityParams02(User user){
        user.setName(user.getName()+"provider");

        return user;
    }

    @RequestMapping("/getForObject")
    public Object getForObject(){
        User user = new User(1L,"jack",23);
        return user;
    }

    @RequestMapping("/postForObject")
    public Object postForObject(User user){
        user.setName(user.getName()+"provider");
        return user;
    }

    @RequestMapping("/put")
    public Object put(User user){
        user.setName(user.getName()+"provider");
        System.out.println(user.getAge());
        System.out.println(user.getName());
        System.out.println(user.getId());
        return user;
    }

    @RequestMapping("/delete")
    public Object delete(Integer id){
        System.out.println(id);
        return "delete success";
    }
}
