package com.zcyfover.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description TODO
 * @author zcy-fover
 * @date 2019-04-17 22:27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulClientApplication.class, args);
    }

}
