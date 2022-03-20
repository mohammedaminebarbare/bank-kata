package com.kata.bank.application.services;

import java.math.BigDecimal;
import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.LoadBankAccountPort;
import com.kata.bank.application.ports.SaveBankAccountPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepositService implements DepositUseCase{

	private LoadBankAccountPort loadBankAccountPort;
	private SaveBankAccountPort saveBankAccountPort;
	
	@Override
	public boolean deposit(BigDecimal ammount, String id) {
		Optional<BankAccount> bankAccOptional = loadBankAccountPort.load(id);
		if(bankAccOptional.isEmpty())
			return false;
		BankAccount account = bankAccOptional.get();
		account.deposit(ammount);
		saveBankAccountPort.save(account);
		
		return true;
	}

}
