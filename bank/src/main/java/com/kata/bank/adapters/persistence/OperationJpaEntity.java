package com.kata.bank.adapters.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kata.bank.application.entities.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation")
public class OperationJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long accountId;
	private LocalDateTime date;
	private OperationType type;
	private BigDecimal ammount;
	private BigDecimal balance; // the balance after the operation
	
	
	public OperationJpaEntity(Long accountId, LocalDateTime date, OperationType type, BigDecimal ammount,
			BigDecimal balance) {
		super();
		this.accountId = accountId;
		this.date = date;
		this.type = type;
		this.ammount = ammount;
		this.balance = balance;
	}
	
	
}
