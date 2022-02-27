package com.raghavrs.mybank.fundtransfer_service.feignclient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferWithPhoneDTO;

@FeignClient(name = "CUSTOMER-SERVICE/customer")
public interface AccountServiceFeignClient {
	
	@PostMapping("/fund-deduction")
	public Boolean fundDeduction(FundTransferDTO fundTransferDTO);
	
	@PostMapping("/fund-deduction-with-phonenumber")
	public List<Long> fundDeductionWithPhoneNumbers(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO);
}
