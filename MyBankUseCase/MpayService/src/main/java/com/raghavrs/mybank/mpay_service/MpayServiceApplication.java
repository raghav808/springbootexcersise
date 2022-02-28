package com.raghavrs.mybank.mpay_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MpayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpayServiceApplication.class, args);
	}

}
