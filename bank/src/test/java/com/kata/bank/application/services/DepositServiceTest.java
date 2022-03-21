package com.kata.bank.application.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.ports.LoadBankAccountPort;
import com.kata.bank.application.ports.SaveBankAccountPort;

@SpringBootTest
public class DepositServiceTest {
	
	@Mock
	private LoadBankAccountPort loadBankAccountPortMock;
	@Mock
	private SaveBankAccountPort saveBankAccountPortMock;
	
	@InjectMocks
	private DepositService service;
	
	@Test
	void itShouldDepositSuccesfully() {
		// Given
		Long id = 10L;
		BigDecimal ammount = new BigDecimal(10.00);
		BigDecimal balance = new BigDecimal(10.00);
		BankAccount account = new BankAccount(id, balance);
		when(loadBankAccountPortMock.load(id)).thenReturn(Optional.of(account));
		
		// When
		boolean result = service.deposit(ammount, id);
		
		// Then
		assertTrue(result);
		
	}
	
	@Test
	void itShouldNotDepositSuccesfully() {
		// Given
		Long id = 10L;
		BigDecimal ammount = new BigDecimal(10.00);
		when(loadBankAccountPortMock.load(id)).thenReturn(Optional.empty());
		
		// When
		boolean result = service.deposit(ammount, id);
		
		// Then
		assertFalse(result);
		
	}
	
}
