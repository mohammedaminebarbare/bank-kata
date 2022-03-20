package com.kata.bank.adapters.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.bank.application.entities.BankAccount;

@SpringBootTest
public class BankAccountPersistenceTest {
	
	@Autowired
	private BankAccountRepository repository;
	
	@Test
	void itShouldSave () {
		// given
		String id = "id";
		BigDecimal balance = new BigDecimal(100);
		BankAccount bankAccount = new BankAccount(id, balance);
		
		// when 
		repository.save(bankAccount);
		
		//then
		BankAccount persistedBankAccount = repository.load(id);
		assertThat(persistedBankAccount != null);
		assertEquals(persistedBankAccount.getId(), id);
		assertEquals(persistedBankAccount.getBalance(), balance);
		
	}

}
