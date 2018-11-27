package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServer007Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServer007Application.class, args);
		System.out.println("success。。。");
	}
}
