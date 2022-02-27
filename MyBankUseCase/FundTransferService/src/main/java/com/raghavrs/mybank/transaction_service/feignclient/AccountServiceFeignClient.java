package com.raghavrs.mybank.transaction_service.feignclient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferWithPhoneDTO;

@FeignClient(name = "ACCOUNT-SERVICE/account")
public interface AccountServiceFeignClient {
	
	@PostMapping("/fund-deduction")
	public Boolean fundDeduction(FundTransferDTO fundTransferDTO);
	
	@PostMapping("/fund-deduction-with-phonenumber")
	public List<Long> fundDeductionWithPhoneNumbers(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO);
	
	@GetMapping("/check-account")
	public Boolean findAccount(@RequestParam Long accountNumber);
	
	@GetMapping("/check-account-by-phonenumber")
	public Long findAccountByPhone(@RequestParam Long phoneNumber);
}
