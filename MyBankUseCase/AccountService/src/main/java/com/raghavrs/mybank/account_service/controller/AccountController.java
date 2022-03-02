package com.raghavrs.mybank.account_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.account_service.exception.CustomException;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.account_service.model.dto.response.AccountDTO;
import com.raghavrs.mybank.account_service.service.AccountService;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/fund-deduction")
	public Boolean fundDeduction(@RequestBody @Valid FundTransferDTO fundTransferDTO) throws CustomException {
		return accountService.fundDeduction(fundTransferDTO);
	}
	
	@PostMapping("/fund-deduction-with-phonenumber")
	public List<Long> fundDeductionWithPhoneNumbers(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		return accountService.fundDeductionWithPhoneNumbers(fundTransferWithPhoneDTO);
	}
	
	@GetMapping("/check-account")
	public Boolean findAccount(@RequestParam Long accountNumber) throws CustomException {
		return accountService.findByAccountNumber(accountNumber).getAccountNumber().equals(accountNumber);
	}
	
	@GetMapping("/check-account-by-phonenumber")
	public Long findAccountByPhone(@RequestParam Long phoneNumber) throws CustomException {
		return accountService.findByPhone(phoneNumber).getAccountNumber();
	}
	
	@PostMapping("/")
	public AccountDTO addAccount(@RequestParam Long customerId) {
		return accountService.addAccount(customerId);
	}
	
	@GetMapping("/")
	public String view() {
		return "Hiiiii";
	}
}
