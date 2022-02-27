package com.raghavrs.mybank.customer_service.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.entity.Account;
import com.raghavrs.mybank.customer_service.model.entity.Customer;
import com.raghavrs.mybank.customer_service.repository.CustomerRepository;
import com.raghavrs.mybank.customer_service.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public String addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		Account account = new Account();
		account.setAccountBalance(BigDecimal.valueOf(10000));
		account.setAccountNumber(Long.valueOf(new Random().nextLong(899999) + 100000));
		account.setCustomer(customer);
		customer.setAccounts(new HashSet<Account>(Arrays.asList(account)));
		customerRepository.save(customer);
		return "Account number - " + account.getAccountNumber();
	}

}
