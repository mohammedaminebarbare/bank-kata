package com.kata.bank.adapters.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.bank.application.entities.BankAccount;

@SpringBootTest
public class BankAccountPersistenceTest {
	
	@Autowired
	private BankAccountH2Repository repository;
	
	@Test
	void itShouldSave() {
		// given
		String id = "id";
		BigDecimal balance = new BigDecimal(100);
		BankAccount bankAccount = new BankAccount(id, balance);
		
		// when 
		repository.save(bankAccount);
		
		//then
		BankAccount persistedBankAccount = repository.load(id);
		assertTrue(persistedBankAccount != null);
		assertEquals(persistedBankAccount.getId(), id);
		assertTrue(balance.compareTo(persistedBankAccount.getBalance()) == 0);
		
	}

}
