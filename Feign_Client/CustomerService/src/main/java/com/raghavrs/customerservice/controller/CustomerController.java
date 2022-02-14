package com.raghavrs.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.customerservice.dto.CustomerDTO;
import com.raghavrs.customerservice.dto.CustomerOrdersDTO;
import com.raghavrs.customerservice.dto.OrderDTO;
import com.raghavrs.customerservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Environment environment;

	@GetMapping("/port")
	public String getPort() {
		return "Customer service is runnig on port : " + environment.getProperty("local.server.port")
		+" And " + customerService.getPort();
	}
	
	@GetMapping("/")
	public List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public CustomerDTO getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/{id}/orders")
	public CustomerOrdersDTO getUserAndOrdersByUserIdPathvar(@PathVariable Long id) {
		return customerService.getOrdersByCustomerId(id);
	}

	@PostMapping("/{id}/orders")
	public CustomerOrdersDTO updateUserOrders(@PathVariable Long id, @RequestBody OrderDTO order) {
		return customerService.getCustomerOrders(id, order);
	}
	
}
