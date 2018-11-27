package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClient010Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClient010Application.class, args);
		System.out.println("success");
	}
}
