package com.raghavrs.mybank.mpay_service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.mpay_service.exception.CustomException;
import com.raghavrs.mybank.mpay_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.mpay_service.service.MobileStatementService;

@RestController
public class StatementController {
	@Autowired
	private MobileStatementService statementService;
	
	@GetMapping("/statement12")
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
		return statementService.monthlyStatement(phoneNumber, year, month);
	}
	
	@GetMapping("/statement")
	public List<AccountMonthlySummaryDTO> lastFiveTransactions(@RequestParam Long phoneNumber){
		return statementService.lastFiveTransactions(phoneNumber);
	}
}
