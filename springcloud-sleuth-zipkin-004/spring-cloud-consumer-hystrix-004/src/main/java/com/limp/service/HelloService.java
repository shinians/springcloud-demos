package com.limp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-provider-004",fallback = HelloRemoteHystrix.class)
public interface HelloService {
    @RequestMapping(value = "hello")
    public String hello(@RequestParam(value = "name") String name);
}
