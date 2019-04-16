package com.zcyfover.spring.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(value = "name") String name) {
        return hiService.sayHi(name);
    }
}
