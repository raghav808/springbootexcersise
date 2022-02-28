package com.raghavrs.mybank.account_service.service;

import java.util.List;

import javax.validation.Valid;

import com.raghavrs.mybank.account_service.exception.CustomException;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.account_service.model.dto.response.AccountDTO;
import com.raghavrs.mybank.account_service.model.entity.Account;


public interface AccountService {
	
	Boolean fundDeduction(FundTransferDTO fundTransferDTO) throws CustomException;

	List<Long> fundDeductionWithPhoneNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException;

	Account findByAccountNumber(Long accountNumber) throws CustomException;

	Account findByPhone(Long phoneNumber) throws CustomException;

	AccountDTO addAccount(Long customerId);

}
