package com.kata.bank.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kata.bank.BankApplication;
import com.kata.bank.adapters.persistence.BankAccountRepository;
import com.kata.bank.application.services.DepositService;

@ComponentScan(basePackageClasses = BankApplication.class)
@Configuration
public class ApplicationConfiguration {

	
	@Bean
	DepositService depositService(BankAccountRepository bankAccountRepository) {
		return new DepositService(bankAccountRepository, bankAccountRepository);
	}
}
