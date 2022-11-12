package com.rest.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.bank.model.Bank;
import com.rest.bank.repo.BankRepository;
import com.rest.bank.exception.NoDataFoundException;



@Service
public class BankService {
	@Autowired
	public BankRepository bankRepo;

	public List<Bank> getAllBanks()
	{
		List<Bank> banks = new ArrayList<>();
		bankRepo.findAll().forEach(banks::add);
        if (banks.isEmpty()) {

            throw new NoDataFoundException();
        }	
		return banks;
	}

	public Bank addBank(Bank bank) {
		bankRepo.save(bank);
		return bank;
		
	}
	
	
	public Optional<Bank> findById(Long bankid) {

        return bankRepo.findById(bankid);
	}	
	
	
	public void updatecardcount(Long bankid) {
		bankRepo.updatecardcount(bankid);
		
	}
	
	
	
	public Bank updateBank(Bank bank) {
		bankRepo.save(bank);
		return bank;
		
	}
	
	
	public void deleteById(Long bankid) {

        bankRepo.deleteById(bankid);
	}	
	
	
	
	
	
	
}