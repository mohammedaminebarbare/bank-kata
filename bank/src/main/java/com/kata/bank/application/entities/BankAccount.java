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
		// TODO Auto-generated method stub
		
	}
	
	

}
