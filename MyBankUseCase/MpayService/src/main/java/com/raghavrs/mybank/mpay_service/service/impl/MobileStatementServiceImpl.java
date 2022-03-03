package com.raghavrs.mybank.mpay_service.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.mpay_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.mpay_service.repository.MobileTransactionRepository;
import com.raghavrs.mybank.mpay_service.service.MobileStatementService;

@Service
public class MobileStatementServiceImpl implements MobileStatementService{
	
	@Autowired
	private MobileTransactionRepository transactionRepository;

	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatement(Long phoneNumber, int year, int month) {
		return transactionRepository.monthlyStatement(phoneNumber, year, month);
	}

	@Override
	public List<AccountMonthlySummaryDTO> lastFiveTransactions(Long phoneNumber) {
		return transactionRepository.last5Transactions(phoneNumber).stream()
				.sorted(Comparator.comparing(AccountMonthlySummaryDTO::getTransactionDate).reversed()).limit(5)
				.collect(Collectors.toList());
	}
}