package com.kata.bank.application.ports;

import com.kata.bank.application.entities.BankAccount;

public interface SaveBankAccountPort {
	void save(BankAccount account);

}
