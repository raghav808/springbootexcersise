package com.raghavrs.mybank.account_service.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.account_service.exception.CustomException;
import com.raghavrs.mybank.account_service.feignclient.CustomerServiceFeignClient;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.account_service.model.dto.response.AccountDTO;
import com.raghavrs.mybank.account_service.model.entity.Account;
import com.raghavrs.mybank.account_service.repository.AccountRepository;
import com.raghavrs.mybank.account_service.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerServiceFeignClient customerServiceFeignClient;

//	@Autowired
//	CustomerRepository customerRepository;

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
		Account fromCustomer = findByPhone(fundTransferWithPhoneDTO.getFromNumber());
		Account toCustomer = findByPhone(fundTransferWithPhoneDTO.getToNumber());

		Boolean deducted = 
				fundDeduction(new FundTransferDTO(fundTransferWithPhoneDTO.getAmount(),
//				fromCustomer.getAccounts().stream().findFirst().get().getAccountNumber(),
//				toCustomer.getAccounts().stream().findFirst().get().getAccountNumber(),
						fromCustomer.getAccountNumber(), toCustomer.getAccountNumber(),
						fundTransferWithPhoneDTO.getComments()));
		if(deducted) {
			return new ArrayList<>(List.of(fromCustomer.getAccountNumber(), toCustomer.getAccountNumber()));
		}
		return null;
	}

	@Override
	public Account findByPhone(Long phoneNumber) throws CustomException {
		return accountRepository.findByCustomerId(customerServiceFeignClient.findAccountByPhone(phoneNumber))
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Phone number - " + phoneNumber));
	}
	
	@Override
	public Account findByAccountNumber(Long accountNumber) throws CustomException {
		return accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Account number - " + accountNumber));
	}

	@Override
	public AccountDTO addAccount(Long customerId) {
		Account account = new Account();
		account.setAccountBalance(BigDecimal.valueOf(10000));
		account.setAccountNumber(customerId + 100000);
		account.setCustomerId(customerId);
		account.setWhenCreated(LocalDateTime.now());
		account = accountRepository.save(account);
		AccountDTO accountDTO = new AccountDTO(); 
		BeanUtils.copyProperties(account,accountDTO);
		return accountDTO;
	}

}
