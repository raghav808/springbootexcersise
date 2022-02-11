package com.raghavrs.customerservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raghavrs.customerservice.dto.OrderDTO;

//@FeignClient(value = "order-service",url = "http://localhost:8081/orders")
@FeignClient(name = "http://ORDER-SERVICE/orders")
public interface OrderServiceClient {

	@GetMapping("/{customerId}")
	public List<OrderDTO> getOrdersByCustomerId(@PathVariable Long customerId);
	
	@PostMapping("/{customerId}")
	public List<OrderDTO> getUpdatedOrdersByCustomerId(@PathVariable Long customerId, @RequestBody OrderDTO order);
}
