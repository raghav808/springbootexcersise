package com.raghavrs.mybank.customer_service.service;

import java.util.List;

import javax.validation.Valid;

import com.raghavrs.mybank.customer_service.exception.CustomException;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.customer_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.customer_service.model.entity.Account;
import com.raghavrs.mybank.customer_service.model.entity.Customer;

public interface AccountService {

	Boolean fundDeduction(FundTransferDTO fundTransferDTO) throws CustomException;

	List<Long> fundDeductionWithPhoneNumbers(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException;

	Account findByAccountNumber(Long accountNumber) throws CustomException;

	Customer findByPhone(Long phoneNumber) throws CustomException;

}
