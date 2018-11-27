package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaClient008Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaClient008Application.class, args);
		System.out.println("/***********8001***********/");
	}
}
