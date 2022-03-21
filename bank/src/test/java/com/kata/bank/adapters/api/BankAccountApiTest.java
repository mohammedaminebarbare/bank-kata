package com.kata.bank.adapters.api;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.internal.Lists;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.kata.bank.application.entities.Operation;
import com.kata.bank.application.entities.OperationType;
import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.HistoryUseCase;
import com.kata.bank.application.ports.WithdrawUseCase;

@WebFluxTest
public class BankAccountApiTest {
	
	
	@Autowired
	private WebTestClient client;
	
	@MockBean
	private DepositUseCase depositUseCase;
	
	@MockBean
	private WithdrawUseCase withdrawUseCase ;
	
	@MockBean
	private HistoryUseCase historyUseCase;
	

	@Test
	void itShouldDeposit() {
		// Given
		Long accountId = 12L;
		BigDecimal ammount = new BigDecimal("10");
		when(depositUseCase.deposit(ammount, accountId)).thenReturn(true);
		// When
		client.post().uri("/deposit/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isOk();
	}
	
	@Test
	void itShoulNotdDeposit() {
		// Given
		Long accountId = 13L;
		BigDecimal ammount = new BigDecimal("10");
		when(depositUseCase.deposit(ammount, accountId)).thenReturn(false);
		// When
		client.post().uri("/deposit/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isCreated();
	}
	
	@Test
	void itShouldWithdraw() {
		// Given
		Long accountId = 12L;
		BigDecimal ammount = new BigDecimal("10");
		when(withdrawUseCase.withdraw(ammount, accountId)).thenReturn(true);
		// When
		client.get().uri("/withdraw/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isOk();
	}
	
	@Test
	void itShouldNotWithdraw() {
		// Given
		Long accountId = 17L;
		BigDecimal ammount = new BigDecimal("10");
		when(withdrawUseCase.withdraw(ammount, accountId)).thenReturn(false);
		// When
		client.get().uri("/withdraw/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isBadRequest();
	}
	
	
	@Test
	void itShouldGetHistory() {
		// Given
		Long accountId = 10L;
		BigDecimal ammount = new BigDecimal("10");
		LocalDateTime now = LocalDateTime.now();
		BigDecimal balance = new BigDecimal("100");
		Operation operation = new Operation(accountId, now, OperationType.DEPOSIT, ammount, balance);
		Collection<Operation> operations = new ArrayList<Operation>();
		operations.add(operation);
		when(historyUseCase.history(accountId)).thenReturn(operations);
		// When
		client.get().uri("/history/" + accountId)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isOk();
	}
	
}
