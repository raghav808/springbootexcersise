package com.raghavrs.mybank.statement_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.statement_service.feighclient.AccountServiceFeighClient;
import com.raghavrs.mybank.statement_service.feighclient.FundTransferServiceFeignClient;
import com.raghavrs.mybank.statement_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.statement_service.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	private AccountServiceFeighClient accountServiceFeighClient;
	
	@Autowired
	private FundTransferServiceFeignClient fundTransferServiceFeignClient;
	
	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatement(Long accountNumber, int year, int month) {
		if(accountServiceFeighClient.findAccount(accountNumber)) {
			return fundTransferServiceFeignClient.monthlyStatement(accountNumber, year, month);
		}
		return null;
	}

	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatementWithPhoneNumber(Long phoneNumber, int year, int month) {
		return fundTransferServiceFeignClient.monthlyStatement(accountServiceFeighClient.findAccountByPhone(phoneNumber), year, month);
	}

}
