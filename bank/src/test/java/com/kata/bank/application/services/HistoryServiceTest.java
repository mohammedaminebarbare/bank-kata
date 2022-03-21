package com.kata.bank.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.entities.Operation;
import com.kata.bank.application.entities.OperationType;
import com.kata.bank.application.ports.LoadBankAccountPort;

@SpringBootTest
public class HistoryServiceTest {
	
	@Mock
	private LoadBankAccountPort loadBankAccountPortMock;
	
	@InjectMocks
	private HistoryService service;
	
	@Test
	void itShouldShowHistorySuccesfully() {
		// Given
		Long id = 10L;
		BigDecimal ammount = new BigDecimal("10");
		LocalDateTime now = LocalDateTime.now();
		BigDecimal balance = new BigDecimal("100");
		Operation operation = new Operation(id, now, OperationType.DEPOSIT, ammount, balance);
		Collection<Operation> operations = new ArrayList<Operation>();
		operations.add(operation);
		BankAccount account = new BankAccount(id, balance, operations);
		when(loadBankAccountPortMock.load(id)).thenReturn(Optional.of(account));
		
		// When
		Collection<Operation> result = service.history(id);
		
		// Then
		assertEquals(result, operations);
		
	}
	
	

	
}
