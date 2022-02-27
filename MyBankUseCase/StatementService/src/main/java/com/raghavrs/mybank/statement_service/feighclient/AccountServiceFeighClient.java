package com.raghavrs.mybank.statement_service.feighclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE/customer")
public interface AccountServiceFeighClient {
	
	@GetMapping("/check-account")
	public Boolean findAccount(@RequestParam Long accountNumber);
	
	@GetMapping("/check-account-by-phonenumber")
	public Long findAccountByPhone(@RequestParam Long phoneNumber);
}
