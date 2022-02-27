package com.raghavrs.mybank.customer_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT-SERVICE/account")
public interface AccountServiceFeignClient {

	@PostMapping("/")
	public Long addAccount(@RequestParam Long customerId);
}
