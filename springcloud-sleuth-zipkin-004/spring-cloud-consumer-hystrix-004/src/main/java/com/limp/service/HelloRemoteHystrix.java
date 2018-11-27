package com.limp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/15.
 */
@Component
public class HelloRemoteHystrix implements HelloService{

    @Override
    public String hello(String name) {
        return "error";
    }
}
