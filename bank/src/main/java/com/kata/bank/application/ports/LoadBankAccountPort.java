package com.kata.bank.application.ports;

import java.util.Optional;

import com.kata.bank.application.entities.BankAccount;

public interface LoadBankAccountPort {
	Optional<BankAccount> load(Long id);
}
