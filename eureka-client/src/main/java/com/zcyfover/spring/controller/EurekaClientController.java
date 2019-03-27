package com.zcyfover.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("eureka-client")
public class EurekaClientController {

    @Value("${server.port}")
    String port;

    @GetMapping
    @RequestMapping("/hi")
    public String home(@RequestParam("name") String name) {
        return "hi " + name + ", I am from port: " + port;
    }

}
