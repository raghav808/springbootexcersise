package com.raghavrs.mybank.fundtransfer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raghavrs.mybank.fundtransfer_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.fundtransfer_service.model.entity.Transaction;

public interface FundTransferRepository extends JpaRepository<Transaction, Long>{
	
	@Query("select new com.raghavrs.mybank.fundtransfer_service.model.dto.response.AccountMonthlySummaryDTO(trn.transactionNumber,"
			+ "trn.transactionDate,"
			+ "trn.amount,"
			+ "case "
			+ "when trn.fromAccount = :accountNumber "
			+ "then 'Debit' else 'Credit' "
			+ "end,"
			+ "case "
			+ "when trn.fromAccount = :accountNumber "
			+ "then trn.toAccount else trn.fromAccount "
			+ "end)"
			+ "from Transaction trn"
			+ " where year(trn.transactionDate) = :year "
			+ "and month(trn.transactionDate) = :month "
			+ "and :accountNumber in (trn.fromAccount,trn.toAccount)")
	List<AccountMonthlySummaryDTO> monthlyStatement(Long accountNumber, int year, int month);

}
