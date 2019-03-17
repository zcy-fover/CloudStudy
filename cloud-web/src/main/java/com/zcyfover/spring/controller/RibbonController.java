package com.zcyfover.spring.controller;

import com.zcyfover.spring.ribbon.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return ribbonService.sayHello(name);
    }

}
