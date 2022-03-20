package com.kata.bank.application.ports;

import java.math.BigDecimal;

public interface DepositUseCase {
	void deposit(BigDecimal ammount, String id);
}
