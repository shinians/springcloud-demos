package com.limp.service.fallback;

import com.limp.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2019/1/5 10:06
 * @website： www.shinians.com
 */
@Component
public class HelloServiceFallbackFactory implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello(String name) {
                return "连接超时,稍后重试";
            }
        };
    }
}
