package com.kata.bank.adapters.api;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@PostMapping("/deposit/{accountId}/{ammount}")
	void deposit(@PathVariable final String accountId, @PathVariable final BigDecimal ammount) {
	}
	
	
}
