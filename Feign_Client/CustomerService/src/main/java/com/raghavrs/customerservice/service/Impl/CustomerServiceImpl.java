package com.raghavrs.customerservice.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.customerservice.dto.CustomerDTO;
import com.raghavrs.customerservice.dto.CustomerOrdersDTO;
import com.raghavrs.customerservice.dto.OrderDTO;
import com.raghavrs.customerservice.feignclient.OrderServiceClient;
import com.raghavrs.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private OrderServiceClient orderServiceClient;
	
	static Map<Long, CustomerDTO> userDetails = new HashMap<>();

	static {

		CustomerDTO customer = new CustomerDTO();
		customer.setId(101L);
		customer.setName("Cust1");

		userDetails.put(101L, customer);

		customer = new CustomerDTO();
		customer.setId(201L);
		customer.setName("Cust2");

		userDetails.put(201L, customer);

	}

	

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return new ArrayList<>(userDetails.values());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return userDetails.get(id);
	}

	@Override
	public CustomerOrdersDTO getOrdersByCustomerId(Long id) {
		return new CustomerOrdersDTO(getCustomerById(id), orderServiceClient.getOrdersByCustomerId(id));
	}

	@Override
	public CustomerOrdersDTO getCustomerOrders(Long id, OrderDTO order) {
		return new CustomerOrdersDTO(getCustomerById(id), orderServiceClient.getUpdatedOrdersByCustomerId(id,order));
//		return null;
	}

	@Override
	public String getPort() {
		return orderServiceClient.getPort();
	}

}
