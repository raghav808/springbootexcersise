package com.raghavrs.mybank.customer_service.service;

import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;

public interface CustomerService {
	String addCustomer(CustomerDTO customer);
}
