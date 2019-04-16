package com.zcyfover.spring.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonService")
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    //    @HystrixCommand(fallbackMethod = "error")
    public String sayHello(String name) {
        String url = "http://eureka-client/eureka-client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    private String error(String name) {
        return "Hi, " + name + ". the server is done";
    }

}
