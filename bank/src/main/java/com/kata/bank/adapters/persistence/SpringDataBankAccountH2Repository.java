package com.kata.bank.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBankAccountH2Repository extends JpaRepository<BankAccountJpaEntity, String>{

}
