package com.kata.bank.application.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.entities.Operation;
import com.kata.bank.application.entities.OperationType;
import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.LoadBankAccountPort;
import com.kata.bank.application.ports.SaveBankAccountPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepositService implements DepositUseCase{

	private LoadBankAccountPort loadBankAccountPort;
	private SaveBankAccountPort saveBankAccountPort;
	
	@Override
	public boolean deposit(BigDecimal ammount, Long id) {
		Optional<BankAccount> bankAccOptional = loadBankAccountPort.load(id);
		if(bankAccOptional.isEmpty()) {
			//could be managing this through an exception but i chose to return a false and manage it in the api
			// in this example i will create the account ( if it does not exist) with the ammount of the deposit as the balance
			BankAccount newAccount = new BankAccount(id, ammount, new Operation(id, LocalDateTime.now(), OperationType.CREATE_ACCOUNT, ammount, ammount));
			saveBankAccountPort.save(newAccount);
			return false;
		}
			
		BankAccount account = bankAccOptional.get();
		account.deposit(ammount);
		saveBankAccountPort.save(account);
		
		return true;
	}

}
