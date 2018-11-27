package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProducter2002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducter2002Application.class, args);
		System.out.println("/***************success  producter2 8002 启动成功******************/");

	}
}
