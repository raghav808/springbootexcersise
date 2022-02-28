package com.raghavrs.mybank.mpay_service.service;


import javax.validation.Valid;

import com.raghavrs.mybank.mpay_service.exception.CustomException;
import com.raghavrs.mybank.mpay_service.model.dto.request.FundTransferWithPhoneDTO;


public interface MobileFundTransferService {

	String fundTransfer(@Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException;

}
