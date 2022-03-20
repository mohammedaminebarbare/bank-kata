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

@WebFluxTest
public class BankAccountApiTest {
	
	
	@Autowired
	private WebTestClient client;
	
	@MockBean
	private DepositUseCase depositUseCase;
	

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
		// When
		client.post().uri("/withdraw/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
		// Then
			.expectStatus().isOk();
	}
	

}
