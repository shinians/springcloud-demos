package com.limp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/8 16:46
 * @website： www.shinians.com
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello 2";
    }
}
