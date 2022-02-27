package com.raghavrs.mybank.statement_service.feighclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghavrs.mybank.statement_service.model.dto.response.AccountMonthlySummaryDTO;


@FeignClient(name = "FUNDTRANSFER-SERVICE/account")
public interface FundTransferServiceFeignClient {
	
	@GetMapping("/monthly-statement")
	public List<AccountMonthlySummaryDTO> monthlyStatement(@RequestParam Long accountNumber, @RequestParam int year,@RequestParam int month);
}
