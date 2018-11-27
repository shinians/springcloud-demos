package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudClient006Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudClient006Application.class, args);
		System.out.println("启动成功...");
	}
}
