package com.raghavrs.mybank.customer_service.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.customer_service.service.AccountService;
import com.raghavrs.mybank.customer_service.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/")
	public String greet() {
		return "Customer service";
	}
	
	@PostMapping("/")
	public String addCustomer(@RequestBody @Valid CustomerDTO customer) throws CustomException {
		if (Period.between(customer.getDob(), LocalDate.now()).getYears() < 18) {
			throw new CustomException("18 is the minimum Age limit");
		}
		return customerService.addCustomer(customer);
	}
}
