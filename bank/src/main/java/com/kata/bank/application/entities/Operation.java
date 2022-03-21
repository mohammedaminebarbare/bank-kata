package com.kata.bank.application.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Operation {
	
	
	private Long accountId; //Account Id
	private LocalDateTime date;
	private OperationType type;
	private BigDecimal ammount;
	private BigDecimal balance; // the balance after the operation
}
