package com.kata.bank.adapters.persistence;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class BankAccountPersistenceTest {
	
	private BankAccountRepository repository;
	
	@Test
	void itShouldSave () {
		// given
		String id = "id";
		BigDecimal ammount = new BigDecimal(10);
		BigDecimal balance = new BigDecimal(100);
		BankAccount bankAccount = new BankAccount(id, balance);
		// when 
		repository.save(bankAccount);
	}

}
