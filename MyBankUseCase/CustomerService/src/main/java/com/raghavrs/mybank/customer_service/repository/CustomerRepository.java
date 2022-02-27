package com.raghavrs.mybank.customer_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavrs.mybank.customer_service.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByPhone(Long phoneNumber);

}
