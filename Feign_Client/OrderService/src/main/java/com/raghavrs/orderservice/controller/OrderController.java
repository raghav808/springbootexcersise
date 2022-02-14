package com.raghavrs.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.orderservice.dto.OrderDTO;
import com.raghavrs.orderservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Environment environment;

	@GetMapping("/port")
	public String getPort() {
		return "Order service is runnig on port : " + environment.getProperty("local.server.port");
	}

	@GetMapping("/{customerId}")
	public List<OrderDTO> getOrdersByCustomerId(@PathVariable Long customerId) {
		return orderService.getOrders(customerId);
	}

	@PostMapping("/{customerId}")
	public List<OrderDTO> getUpdatedOrdersByCustomerId(@PathVariable Long customerId, @RequestBody OrderDTO order) {
		return orderService.getUpdatedOrders(customerId, order);
	}
}
