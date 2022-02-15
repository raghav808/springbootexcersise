package com.raghavrs.employee_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "COMPANY-SERVICE/company")
public interface CompanyServiceClient {

	@GetMapping("/port")
	String getPortNumber();
}
