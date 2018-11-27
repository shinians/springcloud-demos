package com.limp.service;

import com.limp.config.HelloFeignServiceConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2018/11/21 10:31
 * @website： www.shinians.com
 */
@FeignClient(name = "githup-api",url = "https://api.github.com",configuration = HelloFeignServiceConfig.class)
public interface HelloFeignService {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);


    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    ResponseEntity<byte[]> searchRepoGzip(@RequestParam("q") String queryStr);

    /**
     *
     * feign请求结果是一个图片流，怎么接收
     * 生成图片验证码
     * @param imagekey
     * @return
     */
    @RequestMapping(value = "createImagesCode")
    public Response createImageCode(@RequestParam("imagekey") String imagekey);



}
