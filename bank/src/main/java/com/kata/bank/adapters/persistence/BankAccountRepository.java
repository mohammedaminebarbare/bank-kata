package com.kata.bank.adapters.persistence;

import org.springframework.stereotype.Repository;

import com.kata.bank.application.entities.BankAccount;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class BankAccountRepository {

	public void save(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		
	}

	public BankAccount load(String id) {
		return null;
	}

}
