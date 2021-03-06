package com.kata.bank.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kata.bank.BankApplication;
import com.kata.bank.adapters.persistence.BankAccountRepository;
import com.kata.bank.application.services.DepositService;
import com.kata.bank.application.services.HistoryService;
import com.kata.bank.application.services.WithdrawService;

@ComponentScan(basePackageClasses = BankApplication.class)
@Configuration
public class ApplicationConfiguration {

	
	@Bean
	DepositService depositService(BankAccountRepository bankAccountRepository) {
		return new DepositService(bankAccountRepository, bankAccountRepository);
	}
	
	@Bean
	WithdrawService withdrawService(BankAccountRepository bankAccountRepository) {
		return new WithdrawService(bankAccountRepository, bankAccountRepository);
	}
	
	@Bean
	HistoryService historyService(BankAccountRepository bankAccountRepository) {
		return new HistoryService(bankAccountRepository);
	}
}
