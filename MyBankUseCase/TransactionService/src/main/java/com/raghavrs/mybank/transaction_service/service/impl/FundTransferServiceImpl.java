package com.raghavrs.mybank.transaction_service.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.transaction_service.exception.CustomException;
import com.raghavrs.mybank.transaction_service.feignclient.AccountServiceFeignClient;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.transaction_service.model.entity.Transaction;
import com.raghavrs.mybank.transaction_service.repository.TransactionRepository;
import com.raghavrs.mybank.transaction_service.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountServiceFeignClient accountServiceFeignClient;

	@Override
	public String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException {
		
		if(accountServiceFeignClient.fundDeduction(fundTransferDTO)) {
			return saveTransaction(fundTransferDTO, "Account");
		}
		return null;
	}

	@Override
	public String fundTransferWithNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		List<Long> accounts = accountServiceFeignClient.fundDeductionWithPhoneNumbers(fundTransferWithPhoneDTO);
		if(!accounts.isEmpty()) {
			return saveTransaction(new FundTransferDTO(fundTransferWithPhoneDTO.getAmount(),
					accounts.get(0), accounts.get(1), 
					fundTransferWithPhoneDTO.getComments()), "Mobile");
		}
		return null;
	}
	
	private String saveTransaction(FundTransferDTO fundTransferDTO, String Transactiontype) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(fundTransferDTO, transaction);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactionNumber("TRN" + Long.valueOf(new Random().nextLong(8999) + 1000));
		transaction.setTransactionMode(Transactiontype);
		transactionRepository.save(transaction);
		return transaction.getTransactionNumber();
	}
}
