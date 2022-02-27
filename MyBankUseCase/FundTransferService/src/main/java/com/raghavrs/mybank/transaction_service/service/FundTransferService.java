package com.raghavrs.mybank.transaction_service.service;


import javax.validation.Valid;

import com.raghavrs.mybank.transaction_service.exception.CustomException;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.transaction_service.model.dto.request.FundTransferWithPhoneDTO;

public interface FundTransferService {

	String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException;

	String fundTransferWithNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException;

//	List<AccountMonthlySummaryDTO> monthyTransaction(Long accountNumber, int year, int month);

}
