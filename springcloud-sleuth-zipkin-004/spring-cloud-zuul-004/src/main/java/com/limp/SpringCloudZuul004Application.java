package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringCloudZuul004Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuul004Application.class, args);
		System.out.println("/***********zuul starting success**********/");
	}
}
