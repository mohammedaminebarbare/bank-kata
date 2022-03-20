package com.kata.bank.application.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BankAccount {
	
	private String id;
	private BigDecimal balance;
	
	
	public void deposit(BigDecimal ammount) {
		balance = balance.add(ammount);
	}
	
	public boolean withdraw(BigDecimal ammount) {
		// no #decouvert ;)
		// did not manage the ammount == 0 case and other cases ...
		if(BigDecimal.ZERO.compareTo(balance) == 1 || BigDecimal.ZERO.compareTo(balance) == 0 || balance.compareTo(ammount) == -1)
			return false;
		balance = balance.subtract(ammount); 
		return true;
	}
	
	

}
