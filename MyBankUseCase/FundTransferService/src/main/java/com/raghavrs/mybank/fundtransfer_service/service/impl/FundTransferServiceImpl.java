package com.raghavrs.mybank.fundtransfer_service.service.impl;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.raghavrs.mybank.fundtransfer_service.exception.CustomException;
import com.raghavrs.mybank.fundtransfer_service.feignclient.AccountServiceFeignClient;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.fundtransfer_service.model.entity.Transaction;
import com.raghavrs.mybank.fundtransfer_service.repository.FundTransferRepository;
import com.raghavrs.mybank.fundtransfer_service.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService{
	
	@Autowired
	private FundTransferRepository fundTransferRepository;
	
	@Autowired
	private AccountServiceFeignClient accountServiceFeignClient;

	@Override
	public String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException {
		String transactionId = null;
		
		if(accountServiceFeignClient.fundDeduction(fundTransferDTO)) {
			Transaction transaction = new Transaction();
			BeanUtils.copyProperties(fundTransferDTO, transaction);
			transaction.setTransactionNumber("TRN" + Long.valueOf(new Random().nextLong(8999) + 1000));
			fundTransferRepository.save(transaction);
			transactionId = transaction.getTransactionNumber();
		}
		return transactionId;
	}

	@Override
	public String fundTransferWithNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		List<Long> accounts = accountServiceFeignClient.fundDeductionWithPhoneNumbers(fundTransferWithPhoneDTO);
		if(!accounts.isEmpty()) {
			return fundTransfer(new FundTransferDTO(fundTransferWithPhoneDTO.getAmount(),
					accounts.get(0), accounts.get(1), 
					fundTransferWithPhoneDTO.getComments(),
					fundTransferWithPhoneDTO.getTransactionDate()));
		}
		return null;
	}

	@Override
	public List<AccountMonthlySummaryDTO> monthyTransaction(Long accountNumber, int year, int month) {
		return fundTransferRepository.monthlyStatement(accountNumber, year, month);
//		return null;
	}

}
