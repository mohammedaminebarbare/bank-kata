package com.kata.bank.adapters.api;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
public class BankAccountApiTest {

	@Autowired
	private WebTestClient client;

	@Test
	void itShouldDeposit() {
		String accountId = "id1";
		BigDecimal ammount = new BigDecimal("10");
		client.post().uri("/deposit/" + accountId + "/" + ammount)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk();
	}

}