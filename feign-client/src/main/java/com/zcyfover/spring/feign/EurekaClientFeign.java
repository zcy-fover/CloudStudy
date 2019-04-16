package com.zcyfover.spring.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程服务方法，注册需要的远程服务方法
 * 注解@FeignClient中的Value表示远程服务名
 * @author zcy-fover
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    /**
     * 此处的value是具体服务的uri路径
     * @param name 远程服务的参数名
     * @return 返回服务调用的结果
     */
    @GetMapping(value = "/eureka-client/hi")
    String sayHiFromFeignClient(@RequestParam(value = "name") String name);

}
