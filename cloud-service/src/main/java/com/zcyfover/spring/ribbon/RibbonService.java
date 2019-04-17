package com.zcyfover.spring.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonService")
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 配置Hystrix熔断器，当服务提供方done后，可以配置执行fallback方法
     * 在执行的时候：服务提供方有两个，当停止一个后，在短时间内请求，仍然可以负载done掉的服务上面。所以并不是实时的
     * @param name 参数名
     * @return 返回结果
     */
    @HystrixCommand(fallbackMethod = "error")
    public String sayHello(String name) {
        String url = "http://eureka-client/eureka-client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    private String error(String name) {
        return "Hi, " + name + ". the server is done";
    }

}
