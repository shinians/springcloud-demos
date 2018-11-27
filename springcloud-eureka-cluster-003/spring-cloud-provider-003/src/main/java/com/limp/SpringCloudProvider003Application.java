package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProvider003Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProvider003Application.class, args);
		System.out.println("/***********provider 8001***************/");
	}
}
