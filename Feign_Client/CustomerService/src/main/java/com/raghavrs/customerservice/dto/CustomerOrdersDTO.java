package com.raghavrs.customerservice.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrdersDTO {
	
	private CustomerDTO customer = new CustomerDTO();
	
	private List<OrderDTO> orders = new ArrayList<>();

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customerDTO) {
		this.customer = customerDTO;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public CustomerOrdersDTO(CustomerDTO customerDTO, List<OrderDTO> orders) {
		super();
		this.customer = customerDTO;
		this.orders = orders;
	}
	
	

}
