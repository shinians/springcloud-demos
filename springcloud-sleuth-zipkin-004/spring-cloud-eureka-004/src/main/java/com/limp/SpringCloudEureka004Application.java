package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka004Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka004Application.class, args);
		System.out.println("/************starting success **************/");
	}
}
