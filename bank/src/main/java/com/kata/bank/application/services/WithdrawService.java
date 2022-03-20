package com.kata.bank.application.services;

import java.math.BigDecimal;
import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.LoadBankAccountPort;
import com.kata.bank.application.ports.SaveBankAccountPort;
import com.kata.bank.application.ports.WithdrawUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithdrawService implements WithdrawUseCase{

	private LoadBankAccountPort loadBankAccountPort;
	private SaveBankAccountPort saveBankAccountPort;
	

	@Override
	public boolean withdraw(BigDecimal ammount, String id) {
		Optional<BankAccount> bankAccOptional = loadBankAccountPort.load(id);
		if(bankAccOptional.isEmpty())
			//could be managing this through an exception but i chose to return a false and manage it in the api
			return false;
		BankAccount account = bankAccOptional.get();
		boolean withdrew = account.withdraw(ammount);
		if(!withdrew)
			return false;
		saveBankAccountPort.save(account);
		return true;
		
	}

}
