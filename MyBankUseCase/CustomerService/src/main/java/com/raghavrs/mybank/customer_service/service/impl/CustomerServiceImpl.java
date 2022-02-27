package com.raghavrs.mybank.customer_service.service.impl;


import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.feignclient.AccountServiceFeignClient;
import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.entity.Customer;
import com.raghavrs.mybank.customer_service.repository.CustomerRepository;
import com.raghavrs.mybank.customer_service.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private AccountServiceFeignClient accountServiceFeignClient;
	
	@Override
	public String addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customer = customerRepository.save(customer);
		return "Account number - " + accountServiceFeignClient.addAccount(customer.getId());
	}

	@Override
	public Long findByPhoneNumber(Long phoneNumber) throws CustomException {
//		return customerRepository.findByPhone(phoneNumber).ifPresentOrElse(customer -> customer.getId(),
//				() -> {throw new CustomException("Account is unavailable with Phone number - " + phoneNumber);});
		

		Optional<Customer> optional = customerRepository.findByPhone(phoneNumber);
		if(optional.isPresent()) {
			return optional.get().getId();
		}else {
			throw new CustomException("Customer is unavailable with Phone number - " + phoneNumber);
		}
	}

}
