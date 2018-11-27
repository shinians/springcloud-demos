package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class SpringcloudFeignHello011Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudFeignHello011Application.class, args);
	}
}
