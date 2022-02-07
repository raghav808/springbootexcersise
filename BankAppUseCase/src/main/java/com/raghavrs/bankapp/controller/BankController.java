package com.raghavrs.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.bankapp.dto.request.CustomerDTO;
import com.raghavrs.bankapp.dto.request.FundTransferDTO;
import com.raghavrs.bankapp.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.bankapp.service.BankService;

@RestController
@RequestMapping("/mybank")
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/customer")
	public String addCustomer(@RequestBody CustomerDTO customer) {
		return bankService.addCustomer(customer);
	}

	@PostMapping("/customer/account")
	public String fundTransfer(@RequestBody FundTransferDTO fundTransferDTO) {
		return bankService.fundTransfer(fundTransferDTO);
	}

	@GetMapping("/customer/account")
	public List<AccountMonthlySummaryDTO> monthlyStatement(@RequestParam Long accountNumber, @RequestParam int year,
			@RequestParam int month) {
		return "statement";
	}
}
