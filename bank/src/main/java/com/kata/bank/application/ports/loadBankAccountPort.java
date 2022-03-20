package com.kata.bank.application.ports;

import com.kata.bank.application.entities.BankAccount;

public interface loadBankAccountPort {
	BankAccount load(String id);
}
