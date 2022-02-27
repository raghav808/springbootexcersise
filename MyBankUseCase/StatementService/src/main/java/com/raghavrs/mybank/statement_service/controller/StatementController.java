package com.raghavrs.mybank.statement_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.statement_service.exception.CustomException;
import com.raghavrs.mybank.statement_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.statement_service.service.StatementService;

@RestController
public class StatementController {
	
	@Autowired
	private StatementService statementService;
	
//	@GetMapping("/")
//	public String greet() {
//		return "Statement service";
//	}
	
	@GetMapping("/with-account-number")
	public List<AccountMonthlySummaryDTO> monthlyStatement(@RequestParam Long accountNumber, @RequestParam int year,
			@RequestParam int month) throws CustomException {
		if (!(month > 0 & month < 13)) {
			throw new CustomException("Invalid value for month");
		}
		if (LocalDate.now().getYear() < (year-1)) {
			throw new CustomException("Invalid value for year");
		}
		if (LocalDate.now().getYear() == year & LocalDate.now().getMonthValue() < month) {
			throw new CustomException("Invalid value for month");
		}
		return statementService.monthlyStatement(accountNumber, year, month);
	}
	
	@GetMapping("/with-phone-number")
	public List<AccountMonthlySummaryDTO> monthlyStatementWithPhoneNumber(@RequestParam Long phoneNumber, @RequestParam int year,
			@RequestParam int month) throws CustomException {
		if (!(month > 0 & month < 13)) {
			throw new CustomException("Invalid value for month");
		}
		if (LocalDate.now().getYear() < (year-1)) {
			throw new CustomException("Invalid value for year");
		}
		if (LocalDate.now().getYear() == year & LocalDate.now().getMonthValue() < month) {
			throw new CustomException("Invalid value for month");
		}
		return statementService.monthlyStatementWithPhoneNumber(phoneNumber, year, month);
	}

}
