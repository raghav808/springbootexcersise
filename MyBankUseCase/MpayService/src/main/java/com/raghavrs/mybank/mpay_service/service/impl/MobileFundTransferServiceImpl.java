package com.raghavrs.mybank.mpay_service.service.impl;

import java.time.LocalDateTime;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.mpay_service.exception.CustomException;
import com.raghavrs.mybank.mpay_service.feignclient.TransactionServiceFiegnClient;
import com.raghavrs.mybank.mpay_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.mpay_service.model.entity.MobileTransaction;
import com.raghavrs.mybank.mpay_service.repository.MobileTransactionRepository;
import com.raghavrs.mybank.mpay_service.service.MobileFundTransferService;

@Service
public class MobileFundTransferServiceImpl implements MobileFundTransferService{
	
	@Autowired
	private MobileTransactionRepository transactionRepository;
	
	@Autowired
	private TransactionServiceFiegnClient transactionServiceFiegnClient;

	@Override
	public String fundTransfer(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		String transactionId = null;
		
		transactionId = transactionServiceFiegnClient.fundTransferUsingPhoneNumber(fundTransferWithPhoneDTO);
		
		if(StringUtils.isNotEmpty(transactionId)) {
			return addTransaction(fundTransferWithPhoneDTO);
		}
		return null;
	}
	
	private String addTransaction(FundTransferWithPhoneDTO fundTransferWithPhoneDTO) {
		MobileTransaction transaction = new MobileTransaction();
		BeanUtils.copyProperties(fundTransferWithPhoneDTO, transaction);
		transaction.setTransactionNumber("TRN" + Long.valueOf(new Random().nextLong(8999) + 1000));
		transaction.setTransactionDate(LocalDateTime.now());
		transactionRepository.save(transaction);
		return transaction.getTransactionNumber();
	}
}
