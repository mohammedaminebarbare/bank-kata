package com.kata.bank.adapters.api;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.bank.application.ports.DepositUseCase;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class BankAccountController {
	
	private DepositUseCase depositUseCase;

	@PostMapping("/deposit/{accountId}/{ammount}")
	 ResponseEntity<Boolean> deposit(@PathVariable final String accountId, @PathVariable final BigDecimal ammount) {
		Boolean result = depositUseCase.deposit(ammount, accountId);
		if(result)
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return new ResponseEntity<Boolean>(result, HttpStatus.NOT_FOUND);		
	}
}
