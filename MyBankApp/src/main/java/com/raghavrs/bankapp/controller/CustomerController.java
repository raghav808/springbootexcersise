package com.raghavrs.bankapp.controller;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.bankapp.dto.request.CustomerDTO;
import com.raghavrs.bankapp.exception.CustomException;
import com.raghavrs.bankapp.service.CustomerService;

@RestController
@RequestMapping("/mybank")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public String addCustomer(@RequestBody @Valid CustomerDTO customer) throws CustomException {
		if (Period.between(customer.getDob(), LocalDate.now()).getYears() < 18) {
			throw new CustomException("18 is the minimum Age limit");
		}
		return customerService.addCustomer(customer);
	}
}
