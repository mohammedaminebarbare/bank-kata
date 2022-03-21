package com.kata.bank.adapters.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.kata.bank.application.entities.BankAccount;
import com.kata.bank.application.entities.Operation;
import com.kata.bank.application.ports.SaveBankAccountPort;
import com.kata.bank.application.ports.LoadBankAccountPort;

@Repository
public class BankAccountRepository implements LoadBankAccountPort, SaveBankAccountPort {

	@Autowired
	private SpringDataBankAccountH2Repository repository;

	@Override
	public void save(BankAccount account) {
		repository.save(bankAccountJpaEntityMapper(account));

	}

	@Override
	public Optional<BankAccount> load(Long id) {
		return bankAccountMapper(repository.findById(id));
	}

	/**
	 * maps a BankAccount into a BankAccountJpaEntity
	 * 
	 * @param account
	 * @return
	 */
	private BankAccountJpaEntity bankAccountJpaEntityMapper(BankAccount account) {
		return new BankAccountJpaEntity(account.getId(), account.getBalance(),
				operationJpaMapper(account.getOperations()));
	}

	/**
	 * maps a BankAccountJpaEntity into a BankAccount
	 * 
	 * @param account
	 * @return
	 */
	private Optional<BankAccount> bankAccountMapper(Optional<BankAccountJpaEntity> account) {
		if (!account.isPresent())
			return Optional.empty();

		return Optional.of(new BankAccount(account.get().getId(), account.get().getBalance(),
				operationMapper(account.get().getOperations())));
	}

	private Collection<Operation> operationMapper(Collection<OperationJpaEntity> coperations) {
		if (CollectionUtils.isEmpty(coperations))
			return new ArrayList<Operation>();
		return coperations.stream().map(operation -> new Operation(operation.getId(), operation.getDate(),
				operation.getType(), operation.getAmmount(), operation.getBalance())).collect(Collectors.toList());
	}

	private Collection<OperationJpaEntity> operationJpaMapper(Collection<Operation> coperations) {
		if (CollectionUtils.isEmpty(coperations))
			return new ArrayList<OperationJpaEntity>();
		return coperations
				.stream().map(operation -> new OperationJpaEntity(operation.getAccountId(), operation.getDate(),
						operation.getType(), operation.getAmmount(), operation.getBalance()))
				.collect(Collectors.toList());
	}

}
