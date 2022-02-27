package com.raghavrs.mybank.fundtransfer_service.service;

import java.util.List;

import javax.validation.Valid;

import com.raghavrs.mybank.fundtransfer_service.exception.CustomException;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.fundtransfer_service.model.dto.response.AccountMonthlySummaryDTO;

public interface FundTransferService {

	String fundTransfer(FundTransferDTO fundTransferDTO) throws CustomException;

	String fundTransferWithNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException;

	List<AccountMonthlySummaryDTO> monthyTransaction(Long accountNumber, int year, int month);

}
