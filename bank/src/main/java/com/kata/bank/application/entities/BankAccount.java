package com.kata.bank.application.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BankAccount {
	
	private Long id;
	private BigDecimal balance;
	private Collection<Operation> operations = new ArrayList<>();;
	
	
	
	public void deposit(BigDecimal ammount) {
		balance = balance.add(ammount);
		Operation operation = new Operation(id, LocalDateTime.now() , OperationType.DEPOSIT, ammount, balance);
		operations = Arrays.asList(operation);
	}
	
	public boolean withdraw(BigDecimal ammount) {
		// no #decouvert ;)
		// did not manage the ammount == 0 case and other cases ...
		if(BigDecimal.ZERO.compareTo(balance) == 1 || BigDecimal.ZERO.compareTo(balance) == 0 || balance.compareTo(ammount) == -1)
			return false;
		balance = balance.subtract(ammount); 
		Operation operation = new Operation(id, LocalDateTime.now() , OperationType.WITHDRAWAL, ammount, balance);
		operations = Arrays.asList(operation);
		return true;
	}
	

	public BankAccount(Long id, BigDecimal balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public BankAccount(Long id, BigDecimal balance, Operation operation) {
		super();
		this.id = id;
		this.balance = balance;
		operations = Arrays.asList(operation);
	}
	
	
	
	
	

}
