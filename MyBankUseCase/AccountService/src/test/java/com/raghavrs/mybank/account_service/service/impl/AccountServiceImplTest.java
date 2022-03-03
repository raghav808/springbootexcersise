package com.raghavrs.mybank.account_service.service.impl;


import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.raghavrs.mybank.account_service.exception.CustomException;
import com.raghavrs.mybank.account_service.model.dto.request.FundTransferDTO;
import com.raghavrs.mybank.account_service.repository.AccountRepository;

@ExtendWith(SpringExtension.class)
public class AccountServiceImplTest{
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	@Test
	public void testSameAccount() {

		CustomException thrown = Assertions.assertThrows(CustomException.class, () -> {
			accountServiceImpl.fundDeduction(new FundTransferDTO(BigDecimal.valueOf(1000.00), 100005l, 100005l, "Test"));
	  });

	  Assertions.assertEquals("unable to transfer amount to same account", thrown.getMessage());
	}
	
	@Test
	public void testRequiredBalance() {
		CustomException thrown = Assertions.assertThrows(CustomException.class, () -> {
			accountServiceImpl.fundDeduction(new FundTransferDTO(BigDecimal.valueOf(1000.00), 100002l, 100001l, "Test"));
	  });

	  Assertions.assertEquals("unable to transfer amount to same account", thrown.getMessage());
	}

}
