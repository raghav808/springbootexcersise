package com.raghavrs.bankapp.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.bankapp.dto.request.FundTransferDTO;
import com.raghavrs.bankapp.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.bankapp.entity.Account;
import com.raghavrs.bankapp.entity.Transaction;
import com.raghavrs.bankapp.exception.CustomException;
import com.raghavrs.bankapp.repository.AccountRepository;
import com.raghavrs.bankapp.repository.TransactionRepository;
import com.raghavrs.bankapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException {
		Account fromAccount = null, toAccount = null;
		String transactionId;

		if (fundTransferDTO.getFromAccount().equals(fundTransferDTO.getToAccount())) {
			return "unable to transfer amount to same account";
		}
		fromAccount = accountRepository.findByAccountNumber(fundTransferDTO.getFromAccount())
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Account number - " + fundTransferDTO.getFromAccount()));
		toAccount = accountRepository.findByAccountNumber(fundTransferDTO.getToAccount())
				.orElseThrow(() -> new CustomException(
						"Account is unavailable with Account number - " + fundTransferDTO.getToAccount()));

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
			throw new CustomException("Insufficient balance to transfer");

		return transactionId;
	}

	@Override
	public List<AccountMonthlySummaryDTO> monthlyStatement(Long accountNumber, int year, int month)
			throws CustomException {

		if (accountRepository.findByAccountNumber(accountNumber).isPresent()) {
			return transactionRepository.monthlyStatement(accountNumber, year, month);
		} else
			throw new CustomException("Account is unavailable with Account number - " + accountNumber);

	}

}
