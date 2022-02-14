package com.raghavrs.rs_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsGatewayApplication.class, args);
	}

}
