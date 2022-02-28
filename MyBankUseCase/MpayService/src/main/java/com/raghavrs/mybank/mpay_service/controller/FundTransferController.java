package com.raghavrs.mybank.mpay_service.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.mybank.mpay_service.exception.CustomException;
import com.raghavrs.mybank.mpay_service.model.dto.request.FundTransferWithPhoneDTO;
import com.raghavrs.mybank.mpay_service.service.MobileFundTransferService;

@RestController
public class FundTransferController {
	
	@Autowired
	private MobileFundTransferService fundTransferService;
		
	@PostMapping("/fundTransfer")
	public String fundTransferUsingPhoneNumber(@RequestBody @Valid FundTransferWithPhoneDTO fundTransferWithPhoneDTO) throws CustomException {
		return "Fund transfer is successfull with transaction id - " + fundTransferService.fundTransfer(fundTransferWithPhoneDTO);
	}
}
