package com.raghavrs.mybank.transaction_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raghavrs.mybank.transaction_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.transaction_service.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	@Query("select new com.raghavrs.mybank.transaction_service.model.dto.response.AccountMonthlySummaryDTO(trn.transactionNumber,"
			+ "trn.transactionDate,"
			+ "trn.amount,"
			+ "case "
			+ "when trn.fromAccount = :accountNumber "
			+ "then 'Debit' else 'Credit' "
			+ "end,"
			+ "case "
			+ "when trn.fromAccount = :accountNumber "
			+ "then trn.toAccount else trn.fromAccount "
			+ "end,"
			+ "trn.comments,"
			+ "trn.transactionMode)"
			+ "from Transaction trn"
			+ " where year(trn.transactionDate) = :year "
			+ "and month(trn.transactionDate) = :month "
			+ "and :accountNumber in (trn.fromAccount,trn.toAccount)")
	List<AccountMonthlySummaryDTO> monthlyStatement(@Param("accountNumber") Long accountNumber, @Param("year") int year, @Param("month") int month);

}
