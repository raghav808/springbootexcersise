package com.raghavrs.bankapp.service;

import java.util.List;

import com.raghavrs.bankapp.dto.request.FundTransferDTO;
import com.raghavrs.bankapp.dto.response.AccountMonthlySummaryDTO;
import com.raghavrs.bankapp.exception.CustomException;

public interface AccountService {
	String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException;

	List<AccountMonthlySummaryDTO> monthlyStatement(Long accountNumber, int year, int month) throws CustomException;
}
