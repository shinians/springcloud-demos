package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProducter01002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducter01002Application.class, args);
		System.out.println("/***************success  producter1 8001 启动成功******************/");
	}
}
