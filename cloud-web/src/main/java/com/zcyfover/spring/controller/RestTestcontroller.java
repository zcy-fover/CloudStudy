package com.zcyfover.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * rest
 */
@RestController
@RequestMapping("rest")
public class RestTestcontroller {

    @GetMapping("/getTest")
    public String restTest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com", String.class);
    }

}
