package com.raghavrs.bankapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavrs.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	public Optional<Account> findByAccountNumber(Long accountNumber);
}
