package com.kata.bank.application.ports;

import java.math.BigDecimal;

public interface DepositUseCase {
	boolean deposit(BigDecimal ammount, Long id);
}
