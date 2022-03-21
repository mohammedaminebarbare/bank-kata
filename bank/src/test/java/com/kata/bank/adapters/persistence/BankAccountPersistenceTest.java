package com.kata.bank.adapters.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.bank.application.entities.BankAccount;

@SpringBootTest
public class BankAccountPersistenceTest {
	
	@Autowired
	private BankAccountRepository repository;
	
	@Test
	void itShouldSave() {
		// given
		Long accountId = 10L;
		BigDecimal balance = new BigDecimal(100);
		BankAccount bankAccount = new BankAccount(accountId, balance);
		
		// when 
		repository.save(bankAccount);
		
		//then
		Optional<BankAccount> persistedBankAccount = repository.load(accountId);
		assertTrue(persistedBankAccount.isPresent());
		assertEquals(persistedBankAccount.get().getId(), accountId);
		assertTrue(balance.compareTo(persistedBankAccount.get().getBalance()) == 0);
		
	}

}
