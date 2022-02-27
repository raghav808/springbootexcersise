package com.raghavrs.mybank.fundtransfer_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.fundtransfer_service.exception.CustomException;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.fundtransfer_service.service.FundTransferService;

@RestController
public class FundTransferController {
	
	@Autowired
	private FundTransferService fundTransferService;
	
	@GetMapping("/")
	public String greet() {
		return "Transfer service";
	}
	
	@PostMapping("/accountnumbers")
	public String fundTransferUsingAccountNumber(@RequestBody @Valid FundTransferDTO fundTransferDTO) throws CustomException {
		return fundTransferService.fundTransfer(fundTransferDTO);
	}
	
	@PostMapping("/phonenumbers")
	public String fundTransferUsingPhoneNumber(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		return fundTransferService.fundTransferWithNumbers(fundTransferWithPhoneDTO);
	}
	
	@GetMapping("/monthly-statement")
	public List<AccountMonthlySummaryDTO> monthlyStatement(@RequestParam Long accountNumber, @RequestParam int year,
			@RequestParam int month){
		return fundTransferService.monthyTransaction(accountNumber, year,month);
	}
}
