package com.raghavrs.mybank.mpay_service.service;

import java.util.List;

import com.raghavrs.mybank.mpay_service.model.dto.response.AccountMonthlySummaryDTO;


public interface MobileStatementService {

	List<AccountMonthlySummaryDTO> monthlyStatement(Long phoneNumber, int year, int month);

}
