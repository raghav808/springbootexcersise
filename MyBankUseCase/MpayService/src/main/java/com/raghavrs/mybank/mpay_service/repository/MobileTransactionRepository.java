package com.raghavrs.mybank.mpay_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raghavrs.mybank.mpay_service.model.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.mybank.mpay_service.model.entity.MobileTransaction;

public interface MobileTransactionRepository extends JpaRepository<MobileTransaction, Long>{
	
	@Query("select new com.raghavrs.mybank.mpay_service.model.dto.response.AccountMonthlySummaryDTO(trn.transactionNumber,"
			+ "trn.transactionDate,"
			+ "trn.amount,"
			+ "case "
			+ "when trn.fromNumber = :phoneNumber "
			+ "then 'Debit' else 'Credit' "
			+ "end,"
			+ "case "
			+ "when trn.fromNumber = :phoneNumber "
			+ "then trn.toNumber else trn.fromNumber "
			+ "end,"
			+ "trn.comments)"
			+ "from MobileTransaction trn"
			+ " where year(trn.transactionDate) = :year "
			+ "and month(trn.transactionDate) = :month "
			+ "and :phoneNumber in (trn.fromNumber,trn.toNumber)")
	List<AccountMonthlySummaryDTO> monthlyStatement(Long phoneNumber, int year, int month);

}
