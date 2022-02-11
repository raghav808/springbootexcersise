package com.raghavrs.customerservice.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrdersDTO {
	
	private CustomerDTO customerDTO = new CustomerDTO();
	
	private List<OrderDTO> orders = new ArrayList<>();

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public CustomerOrdersDTO(CustomerDTO customerDTO, List<OrderDTO> orders) {
		super();
		this.customerDTO = customerDTO;
		this.orders = orders;
	}
	
	

}
