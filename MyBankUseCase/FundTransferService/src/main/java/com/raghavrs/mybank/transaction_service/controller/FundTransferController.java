package com.raghavrs.mybank.transaction_service.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.transaction_service.exception.CustomException;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.transaction_service.service.FundTransferService;

@RestController
@RequestMapping("/fundTransfer")
public class FundTransferController {
	
	@Autowired
	private FundTransferService fundTransferService;
		
	@PostMapping("/account-numbers")
	public String fundTransferUsingAccountNumber(@RequestBody @Valid FundTransferDTO fundTransferDTO) throws CustomException {
		return fundTransferService.fundTransfer(fundTransferDTO);
	}
	
	@PostMapping("/phone-numbers")
	public String fundTransferUsingPhoneNumber(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		return fundTransferService.fundTransferWithNumbers(fundTransferWithPhoneDTO);
	}
}
