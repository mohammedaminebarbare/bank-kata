package com.kata.bank.application.ports;

import java.util.Collection;

import com.kata.bank.application.entities.Operation;

public interface HistoryUseCase {
	Collection<Operation> history(Long id);
}
