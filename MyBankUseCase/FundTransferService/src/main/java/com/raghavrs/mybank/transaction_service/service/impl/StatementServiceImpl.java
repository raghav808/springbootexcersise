package com.raghavrs.mybank.transaction_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.transaction_service.feignclient.AccountServiceFeignClient;
import com.raghavrs.mybank.transaction_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.transaction_service.repository.TransactionRepository;
import com.raghavrs.mybank.transaction_service.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{
	
	@Autowired
	private AccountServiceFeignClient accountServiceFeignClient;
	
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatement(Long accountNumber, int year, int month) {
		if(accountServiceFeignClient.findAccount(accountNumber)) {
			return transactionRepository.monthlyStatement(accountNumber, year, month);
		}
		return null;
	}

	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatementWithPhoneNumber(Long phoneNumber, int year, int month) {
		return transactionRepository.monthlyStatement(accountServiceFeignClient.findAccountByPhone(phoneNumber), year, month);
	}
}
