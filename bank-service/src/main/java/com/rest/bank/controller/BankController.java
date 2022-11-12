package com.rest.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bank.model.Bank;
import com.rest.bank.service.BankService;


@RestController
public class BankController {
	
	Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Value("${server.port}")
	private int serverPort;
	
	@Autowired
	private BankService banksService;

	@RequestMapping("/banks")
	public List<Bank> getAllBanks()
	{
		return banksService.getAllBanks();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/bank")
	public Bank addBank(@RequestBody @Valid Bank bank)
	{
		banksService.addBank(bank);
		return bank;
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/bank")
	public Bank updateBank(@RequestBody @Valid Bank bank)
	{
		banksService.updateBank(bank);
		return bank;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/bank/{bankid}")
	public void deleteById(@PathVariable Long bankid)
	{
		banksService.deleteById(bankid);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/bank/{bankid}")
	public  Optional<Bank> findById(@PathVariable Long bankid)
	{
		return banksService.findById(bankid);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/bank/cardcount/{bankid}")
	public void updatecardcount(@PathVariable Long bankid)
	{
			banksService.updatecardcount(bankid);
			System. out. println(serverPort);
			logger.info("Bank Service - Card count update",serverPort,bankid);
			
			
			
			
	}
	
	
			
}