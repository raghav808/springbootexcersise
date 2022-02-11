package com.raghavrs.orderservice.service;

import java.util.List;

import com.raghavrs.orderservice.dto.OrderDTO;

public interface OrderService {

	List<OrderDTO> getOrders(Long customerId);

	List<OrderDTO> getUpdatedOrders(Long customerId, OrderDTO order);

}
