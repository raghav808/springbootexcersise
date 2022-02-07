package com.raghavrs.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavrs.bankapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
