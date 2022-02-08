package com.raghavrs.bankapp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.bankapp.dto.request.CustomerDTO;
import com.raghavrs.bankapp.entity.Account;
import com.raghavrs.bankapp.entity.Customer;
import com.raghavrs.bankapp.repository.CustomerRepository;
import com.raghavrs.bankapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		Account account = new Account();
		account.setAccountBalance(BigDecimal.valueOf(10000));
		account.setAccountNumber(Long.valueOf(new Random().nextLong(899999) + 100000));
		account.setCustomer(customer);
		customer.setAccounts(new ArrayList<Account>(Arrays.asList(account)));
		customerRepository.save(customer);
		return "Account number - " + account.getAccountNumber();
	}
}
