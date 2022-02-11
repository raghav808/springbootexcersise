package com.raghavrs.customerservice.service;

import java.util.List;

import com.raghavrs.customerservice.dto.CustomerDTO;
import com.raghavrs.customerservice.dto.CustomerOrdersDTO;
import com.raghavrs.customerservice.dto.OrderDTO;

public interface CustomerService {

	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById(Long id);

	CustomerOrdersDTO getOrdersByCustomerId(Long id);

	CustomerOrdersDTO getCustomerOrders(Long id, OrderDTO order);

}
