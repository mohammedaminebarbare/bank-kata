package com.kata.bank.adapters.api;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.WithdrawUseCase;

@WebFluxTest
public class BankAccountApiTest {
	
	
	@Autowired
	private WebTestClient client;
	
	@MockBean
	private DepositUseCase depositUseCase;
	
	@MockBean
	private WithdrawUseCase withdrawUseCase ;
	

	@Test
	void itShouldDeposit() {
		// Given
		String accountId = "id1";
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
		String accountId = "id2";
		BigDecimal ammount = new BigDecimal("10");
		when(depositUseCase.deposit(ammount, accountId)).thenReturn(false);
		// When
		client.post().uri("/deposit/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isNotFound();
	}
	
	@Test
	void itShouldWithdraw() {
		// Given
		String accountId = "id3";
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
		String accountId = "id3";
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
		String accountId = "id4";
		// When
		client.get().uri("/history/" + accountId)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isOk();
	}
	
}
