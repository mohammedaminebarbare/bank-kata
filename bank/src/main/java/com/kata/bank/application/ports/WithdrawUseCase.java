package com.kata.bank.application.ports;

import java.math.BigDecimal;

public interface WithdrawUseCase {
	boolean withdraw(BigDecimal ammount, Long id);
}
