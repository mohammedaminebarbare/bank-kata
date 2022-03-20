package com.kata.bank.application.ports;

import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;

public interface loadBankAccountPort {
	Optional<BankAccount> load(String id);
}
