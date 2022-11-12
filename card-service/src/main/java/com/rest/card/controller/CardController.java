package com.rest.card.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.card.config.MQSenderqueue;
import com.rest.card.model.Card;
import com.rest.card.service.CardService;

@RestController
public class CardController {
	
	Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardsService;

	@RequestMapping("/cards")
	public List<Card> getAllCards()
	{
		return cardsService.getAllCards();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/card")
	public Card addCard(@RequestBody @Valid Card card) throws MethodArgumentNotValidException
	{
		cardsService.addCard(card);
			
		logger.info("Card Service - New card");
		updatecardcount(card.bankid);
		
			
		send();
		
		return card;
		
	 	}
	
	public void updatecardcount(long bankid){
	
//	String uri = "http://localhost:8062/bank/cardcount/{bankid}";
	String uri = "http://localhost:8762/bank-service/bank/cardcount/{bankid}";
	RestTemplate restTemplate = new RestTemplate();
	restTemplate.put(uri,null,bankid);
	
 }
	
	 @Autowired
	    private MQSenderqueue senderqueue;
	
	
	 public void send(){
	        senderqueue.send("New Card issued for Bankid 10080");
	
	 }	
	

	 
		@RequestMapping(method = RequestMethod.PUT, value="/card")
		public Card updateCard(@RequestBody @Valid Card card)
		{
			cardsService.updateCard(card);
			return card;
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value="/card/{cardno}")
		public void deleteById(@PathVariable String cardno)
		{
			cardsService.deleteById(cardno);
			
		}
		
		
		@RequestMapping(method = RequestMethod.GET, value="/card/{cardno}")
		public  Optional<Card> findById(@PathVariable String cardno)
		{
			return cardsService.findById(cardno);
			
		}
	 

	
	
}