package com.raghavrs.mybank.customer_service.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.customer_service.model.entity.Account;
import com.raghavrs.mybank.customer_service.model.entity.Customer;
import com.raghavrs.mybank.customer_service.repository.AccountRepository;
import com.raghavrs.mybank.customer_service.repository.CustomerRepository;
import com.raghavrs.mybank.customer_service.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Boolean fundDeduction(FundTransferDTO fundTransferDTO) throws CustomException {
		Account fromAccount = null, toAccount = null;

		if (fundTransferDTO.getFromAccount().equals(fundTransferDTO.getToAccount())) {
			throw new CustomException("unable to transfer amount to same account");
		}
		fromAccount = findByAccountNumber(fundTransferDTO.getFromAccount());
		toAccount = findByAccountNumber(fundTransferDTO.getToAccount());

		if (fromAccount.getAccountBalance().compareTo(fundTransferDTO.getAmount()) > 0) {
			fromAccount.setAccountBalance(fromAccount.getAccountBalance().subtract(fundTransferDTO.getAmount()));
			accountRepository.save(fromAccount);

			toAccount.setAccountBalance(toAccount.getAccountBalance().add(fundTransferDTO.getAmount()));
			accountRepository.save(toAccount);

			return true;
		} else
			throw new CustomException("Insufficient balance to transfer");
	}

	@Override
	public List<Long> fundDeductionWithPhoneNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO)
			throws CustomException {
		Customer fromCustomer = findByPhone(fundTransferWithPhoneDTO.getFromNumber());
		Customer toCustomer = findByPhone(fundTransferWithPhoneDTO.getToNumber());

		Boolean deducted = fundDeduction(new FundTransferDTO(fundTransferWithPhoneDTO.getAmount(),
				fromCustomer.getAccounts().stream().findFirst().get().getAccountNumber(),
				toCustomer.getAccounts().stream().findFirst().get().getAccountNumber(),
				fundTransferWithPhoneDTO.getComments(), fundTransferWithPhoneDTO.getTransactionDate()));
		if(deducted) {
			return new ArrayList<>(List.of(fromCustomer.getAccounts().stream().findFirst().get().getAccountNumber(),
					toCustomer.getAccounts().stream().findFirst().get().getAccountNumber()));
		}
		return null;
	}

	@Override
	public Customer findByPhone(Long phoneNumber) throws CustomException {
		return customerRepository.findByPhone(phoneNumber)
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Phone number - " + phoneNumber));
	}
	
	@Override
	public Account findByAccountNumber(Long accountNumber) throws CustomException {
		return accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Account number - " + accountNumber));
	}

}
