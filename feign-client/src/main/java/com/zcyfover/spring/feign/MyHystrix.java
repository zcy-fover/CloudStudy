package com.zcyfover.spring.feign;

import org.springframework.stereotype.Component;

/**
 * @description 自定义熔断器
 * @author zcy-fover
 * @date 2019-04-16 22:43
 */
@Component
public class MyHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromFeignClient(String name) {
        return "hi, " + name + ", server error";
    }
}
