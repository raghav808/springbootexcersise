package com.raghavrs.mybank.customer_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghavrs.mybank.customer_service.model.dto.response.AccountDTO;

@FeignClient(name = "ACCOUNT-SERVICE/account")
public interface AccountServiceFeignClient {

	@PostMapping("/")
	public AccountDTO addAccount(@RequestParam Long customerId);
}
