package com.raghavrs.bankapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.bankapp.dto.request.CustomerDTO;
import com.raghavrs.bankapp.dto.request.FundTransferDTO;
import com.raghavrs.bankapp.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.bankapp.entity.Account;
import com.raghavrs.bankapp.entity.Customer;
import com.raghavrs.bankapp.entity.Transaction;
import com.raghavrs.bankapp.repository.AccountRepository;
import com.raghavrs.bankapp.repository.CustomerRepository;
import com.raghavrs.bankapp.repository.TransactionRepository;
import com.raghavrs.bankapp.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public String addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		Account account = new Account();
		account.setAccountBalance(BigDecimal.valueOf(10000));
		account.setAccountNumber(Long.valueOf(new Random().nextLong(899999) + 100000));
		customer.setAccount(account);
		customerRepository.save(customer);
		return "Account number - " + account.getAccountNumber();
	}

	@Override
	public String fundTransfer(FundTransferDTO fundTransferDTO) {
		Account fromAccount = null, toAccount = null;
		String transactionId;

		if (fundTransferDTO.getFromAccount().equals(fundTransferDTO.getToAccount())) {
			return "unable to transfer amount to same account";
		}
		try {
			fromAccount = accountRepository.findByAccountNumber(fundTransferDTO.getFromAccount()).orElseThrow();
			toAccount = accountRepository.findByAccountNumber(fundTransferDTO.getToAccount()).orElseThrow();
		} catch (Exception e) {
			return "Account is unavailable";
		}

		if (fromAccount.getAccountBalance().compareTo(fundTransferDTO.getAmount()) > 0) {
			fromAccount.setAccountBalance(fromAccount.getAccountBalance().subtract(fundTransferDTO.getAmount()));
			accountRepository.save(fromAccount);

			toAccount.setAccountBalance(toAccount.getAccountBalance().add(fundTransferDTO.getAmount()));
			accountRepository.save(toAccount);

			Transaction transaction = new Transaction();
			BeanUtils.copyProperties(fundTransferDTO, transaction);
			transaction.setTransactionNumber("TRN" + Long.valueOf(new Random().nextLong(8999) + 1000));
			transactionRepository.save(transaction);
			transactionId = transaction.getTransactionNumber();
		} else
			return "Insufficient balance to transfer";

		return transactionId;
	}

}
