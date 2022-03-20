package com.kata.bank.application.services;

import java.math.BigDecimal;

import com.kata.bank.application.ports.DepositUseCase;
import com.kata.bank.application.ports.LoadBankAccountPort;
import com.kata.bank.application.ports.SaveBankAccountPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DepositService implements DepositUseCase{

	private LoadBankAccountPort loadBankAccountPort;
	private SaveBankAccountPort saveBankAccountPort;
	
	@Override
	public void deposit(BigDecimal ammount, String id) {
		// TODO Auto-generated method stub
		
	}

}
