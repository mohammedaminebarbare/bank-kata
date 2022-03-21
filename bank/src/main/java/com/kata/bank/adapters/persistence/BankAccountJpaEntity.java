package com.kata.bank.adapters.persistence;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class BankAccountJpaEntity {
	
	@Id
	private Long id;
	@Column(scale = 2)
	private BigDecimal balance;
	@OneToMany(mappedBy="accountId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<OperationJpaEntity> Operations;
}
