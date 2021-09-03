package com.bj.springcloud.controller;

import com.bj.springcloud.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/getForEntity01")
    public String getForEntity01(){

        ResponseEntity<User> result = restTemplate.getForEntity("http://localhost:8081/getForEntity01",User.class);

        User body =result.getBody();
        return "consumer   "+body;
    }

    @RequestMapping("/getForEntity02")
    public String getForEntity02(){

        ResponseEntity<List> result = restTemplate.getForEntity("http://localhost:8081/getForEntity02", List.class);

        List<User> body =result.getBody();
        for (Object o:body
             ) {
            System.out.println(o.getClass());
        }
        return "consumer   "+body;
    }

    @RequestMapping("/getForEntityParams01")
    public String getForEntityParams01(){

        Object[] params = {2L,"jack",24};
        ResponseEntity<User> result = restTemplate.getForEntity(
                "http://localhost:8081/getForEntityParams01?id={0}&name={1}&age={2}", User.class,params);

        User body =result.getBody();
        return "consumer   "+body;
    }

    @RequestMapping("/getForEntityParams02")
    public String getForEntityParams02(){

        Map<String,Object> params = new HashMap();
        params.put("id",3L);
        params.put("name","jack");
        params.put("age",20);
        ResponseEntity<User> result = restTemplate.getForEntity(
                "http://localhost:8081/getForEntityParams02?id={id}&name={name}&age={age}", User.class,params);
        User body =result.getBody();
        return "consumer   "+body;
    }

    @RequestMapping("/getForObject")
    public String getForObject(){

        String url = "http://localhost:8081/getForObject";
        User user = restTemplate.getForObject(url,User.class);
        return "==========="+user;
    }


    @RequestMapping("/postForObject")
    public String postForObject(){

        //User user1 = new User(4L,"mary",34);
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("name","mary");
        params.add("id",4L);
        params.add("age",32);
        String url = "http://localhost:8081/postForObject";
        User user = restTemplate.postForObject(url,params,User.class);
        return "==========="+user;
    }

    @RequestMapping("/put")
    public String put(){

        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("name","jack");
        params.add("id",8L);
        params.add("age",43);
        String url = "http://localhost:8081/put";
        restTemplate.put(url,params);
        return "===========";
    }

    @RequestMapping("/delete")
    public String delete(){

        String url = "http://localhost:8081/delete?id={0}";
        restTemplate.delete(url,8L);
        return "===========";
    }
}
