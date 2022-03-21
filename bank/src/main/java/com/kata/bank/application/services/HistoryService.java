package com.kata.bank.application.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.entities.Operation;
import com.kata.bank.application.ports.HistoryUseCase;
import com.kata.bank.application.ports.LoadBankAccountPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HistoryService implements HistoryUseCase{

	private LoadBankAccountPort loadBankAccountPort;
	

	@Override
	public Collection<Operation> history(Long id) {
		Optional<BankAccount> bankAccOptional = loadBankAccountPort.load(id);
		if(bankAccOptional.isEmpty())
			//could be managing this through an exception but i chose to return an empty Arraylist
			return new ArrayList<Operation>();
		BankAccount account = bankAccOptional.get();
		return account.getOperations();
	}

}
