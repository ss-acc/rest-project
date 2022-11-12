package com.rest.bank.repo;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.bank.model.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {
	
	
	@Transactional
	@Modifying
	@Query("update Bank b set b.cardcount = b.cardcount+1 where b.bankid = ?1")
	void updatecardcount(Long bankid);
	

}
