package com.raghavrs.orderservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.raghavrs.orderservice.dto.OrderDTO;
import com.raghavrs.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	static Map<Long, List<OrderDTO>> userOrders = new HashMap<>();

	static {
		List<OrderDTO> orders = new ArrayList<>();

		OrderDTO order = new OrderDTO();
		order.setId(101);
		order.setDes("Order11");
		orders.add(order);

		order = new OrderDTO();
		order.setId(102);
		order.setDes("Order12");
		orders.add(order);

		userOrders.put(101L, orders);

		orders = new ArrayList<>();

		order = new OrderDTO();
		order.setId(201);
		order.setDes("Order21");
		orders.add(order);

		order = new OrderDTO();
		order.setId(202);
		order.setDes("Order22");
		orders.add(order);

		userOrders.put(201L, orders);
	}
	
	@Override
	public List<OrderDTO> getOrders(Long customerId) {
		return userOrders.get(customerId);
	}

	@Override
	public List<OrderDTO> getUpdatedOrders(Long customerId, OrderDTO order) {
		List<OrderDTO> orders = userOrders.get(customerId);
		orders.add(order);
		userOrders.put(customerId, orders);
		return userOrders.get(customerId);
	}

}
