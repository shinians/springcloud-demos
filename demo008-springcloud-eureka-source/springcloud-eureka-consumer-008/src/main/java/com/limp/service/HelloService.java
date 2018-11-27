package com.limp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "springcloud-eureka-client-008")
public interface HelloService {
    @RequestMapping(value = "hello")
    public String hello();
}
