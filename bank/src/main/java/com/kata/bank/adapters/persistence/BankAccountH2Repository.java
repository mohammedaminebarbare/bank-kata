package com.kata.bank.adapters.persistence;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.ports.SaveBankAccountPort;
import com.kata.bank.application.ports.loadBankAccountPort;


@Repository
public class BankAccountH2Repository implements loadBankAccountPort, SaveBankAccountPort {
	
	@Autowired
	private SpringDataBankAccountH2Repository repository ;
	
	@Override
	public void save(BankAccount account) {
		repository.save(bankAccountJpaEntityMapper(account));
		
	}

	@Override
	public BankAccount load(String id) {
		return bankAccountMapper(repository.findById(id));
	}
	
	/**
	 * maps a BankAccount into a BankAccountJpaEntity
	 * @param account
	 * @return 
	 */
	private BankAccountJpaEntity bankAccountJpaEntityMapper (BankAccount account) {
		return new BankAccountJpaEntity(account.getId(), account.getBalance());
	}
	
	/**
	 * maps a BankAccountJpaEntity into a BankAccount
	 * @param account
	 * @return 
	 */
	private BankAccount bankAccountMapper(Optional<BankAccountJpaEntity> account) {
		if(!account.isPresent())
			// could be returning an optional in this method but for simplicity reasons chose to return a null
			// could also manage this through exceptions maybe ...
			return null;
		
		return new BankAccount(account.get().getId(), account.get().getBalance());
	}



}
