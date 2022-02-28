package com.raghavrs.mybank.customer_service.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.feignclient.AccountServiceFeignClient;
import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.dto.response.AccountDTO;
import com.raghavrs.mybank.customer_service.model.dto.response.CustomerResponseDTO;
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
	public CustomerResponseDTO addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
//		customer = customerRepository.save(customer);
//		accountServiceFeignClient.addAccount(customer.getId());
		
		CustomerResponseDTO responseDTO = new CustomerResponseDTO();
		BeanUtils.copyProperties(customerRepository.save(customer),responseDTO);
		
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		accountList.add(accountServiceFeignClient.addAccount(customer.getId()));
		
		responseDTO.setAddedAccount(accountList);
		return responseDTO;
	}

	@Override
	public Long findByPhoneNumber(Long phoneNumber) throws CustomException {
		Optional<Customer> optional = customerRepository.findByPhone(phoneNumber);
		if(optional.isPresent()) {
			return optional.get().getId();
		}else {
			throw new CustomException("Customer is unavailable with Phone number - " + phoneNumber);
		}
	}

}
