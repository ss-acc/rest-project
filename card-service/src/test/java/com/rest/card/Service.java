package com.rest.card;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.card.model.Card;
import com.rest.card.service.CardService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class Service {
	
	@Autowired
	private CardService cardservice;
	
	
	@Test
	public void testAddCard() {
		
		// add a card
		Card card = new Card();
		card.setCardno("1234567812345670");
		card.setCardholdername("David Hull");
		card.setCardbalance(5000.50);
		card.setCardissueddate(LocalDate.of(2022, 9, 28));
		card.setCardexpirydate(LocalDate.of(2025, 9, 30));
		card.setCardstatus("ISSUED");
		card.setBankid(10080);
		
		//Test adding a card
		Card newcard = cardservice.addCard(card);
		
		
		//Verify the results
		assertNotNull(newcard);
		assertNotNull(newcard.getCardno());
		assertEquals("David Hull",newcard.getCardholdername());
		
	}

}
