package com.raghavrs.mybank.customer_service.controller;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.dto.response.CustomerResponseDTO;
import com.raghavrs.mybank.customer_service.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public CustomerResponseDTO addCustomer(@RequestBody @Valid CustomerDTO customer) throws CustomException {
		if (Period.between(customer.getDob(), LocalDate.now()).getYears() < 18) {
			throw new CustomException("18 is the minimum Age limit");
		}
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/")
	public Long findAccountByPhone(@RequestParam Long phoneNumber) throws CustomException {
		return customerService.findByPhoneNumber(phoneNumber);
	}
}
