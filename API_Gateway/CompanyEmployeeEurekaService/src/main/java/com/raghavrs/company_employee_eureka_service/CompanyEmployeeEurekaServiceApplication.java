package com.raghavrs.company_employee_eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CompanyEmployeeEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyEmployeeEurekaServiceApplication.class, args);
	}

}
