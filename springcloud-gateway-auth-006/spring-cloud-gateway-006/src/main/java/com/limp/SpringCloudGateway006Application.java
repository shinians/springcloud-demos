package com.limp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGateway006Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGateway006Application.class, args);
	}

	/**
	 * 启动报错
	 * Parameter 0 of method modifyRequestBodyGatewayFilterFactory in org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' that could not be found.
	 * @return
	 */
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
		return ServerCodecConfigurer.create();
	}
}
