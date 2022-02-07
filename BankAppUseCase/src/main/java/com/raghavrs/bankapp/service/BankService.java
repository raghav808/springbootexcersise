package com.raghavrs.bankapp.service;

import java.time.LocalDate;
import java.util.List;

import com.raghavrs.bankapp.dto.request.CustomerDTO;
import com.raghavrs.bankapp.dto.request.FundTransferDTO;
import com.raghavrs.bankapp.dto.response.AccountMonthlySummaryDTO;

public interface BankService {

	String addCustomer(CustomerDTO customer);

	String fundTransfer(FundTransferDTO fundTransferDTO);

}
