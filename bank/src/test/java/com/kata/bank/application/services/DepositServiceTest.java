package com.kata.bank.application.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepositServiceTest {

	@Autowired
	private DepositService service;
	@Test
	void shouldDepositSuccesfully() {
		// Given
		String id = "id";
		BigDecimal ammount = new BigDecimal(10.00);
		
		// When
		service.deposit(ammount, id);
		
	}
	
}
