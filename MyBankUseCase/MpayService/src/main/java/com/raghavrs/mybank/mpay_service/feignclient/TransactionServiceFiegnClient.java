package com.raghavrs.mybank.mpay_service.feignclient;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raghavrs.mybank.mpay_service.model.dto.request.FundTransferWithPhoneDTO;

@FeignClient(name = "TRANSACTION-SERVICE/transaction/")
public interface TransactionServiceFiegnClient {

	@PostMapping("/phone-numbers")
	public String fundTransferUsingPhoneNumber(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO);
}
