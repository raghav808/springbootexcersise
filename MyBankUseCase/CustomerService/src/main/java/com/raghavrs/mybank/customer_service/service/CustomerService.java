package com.raghavrs.mybank.customer_service.service;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.model.dto.request.CustomerDTO;
import com.raghavrs.mybank.customer_service.model.dto.response.CustomerResponseDTO;

public interface CustomerService {
	CustomerResponseDTO addCustomer(CustomerDTO customer);
	Long findByPhoneNumber(Long phoneNumber) throws CustomException;
}
