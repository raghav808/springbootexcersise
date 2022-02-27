package com.raghavrs.mybank.account_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavrs.mybank.account_service.model.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
	public Optional<Account> findByAccountNumber(Long accountNumber);
	public Optional<Account> findByCustomerId(Long phoneNumber);
}
