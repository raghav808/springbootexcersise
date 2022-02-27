package com.raghavrs.mybank.account_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE/customer")
public interface CustomerServiceFeignClient {
	
	@GetMapping("/")
	public Long findAccountByPhone(@RequestParam Long phoneNumber);
}
