package com.rest.card.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="card")
public class Card {
	
	@Id
	@Column(name = "cardno")
	@NotNull(message = "Cardno can't be null")
//	@CreditCardNumber(message = "Cardno is invalid")
	@Length(min=16, max=16,message = "Cardno must be 16 characters")
	private String cardno;
	
	@Column(name = "cardholdername")
	@Size(min = 3, max = 50,message = "Cardholdername must be between 3 and 50 characters")
	@NotBlank(message = "Cardholdername can't be blank")
	private String cardholdername;
	
	@Column(name = "cardbalance")
	@PositiveOrZero(message = "Cardbalance should be zero or positive value")
	@Digits(integer=8, fraction=2,message = "Cardbalance should have appropriate integer and fractional digits")
	private double cardbalance;
	
	@Column(name = "cardissueddate",columnDefinition = "DATE")
	@PastOrPresent(message = "Cardissueddate cannot be a future date") 
	private LocalDate cardissueddate;
	
	@Column(name = "cardexpirydate",columnDefinition = "DATE")
	@Future(message = "Cardexpirydate should be a future date")  
	private LocalDate cardexpirydate;
	
	
	@Column(name = "cardstatus")
	@Pattern(regexp = "ISSUED|ACTIVE|CLOSED",message = "Cardstatus should be ISSUED/ACTIVE/CLOSED")
	private String cardstatus;
	
	@Column(name = "bankid")
	@Range(min=10000, max=99999,message = "Bankid should be valid")
	public long bankid;
	
	
	public Card() {
		
	}

	
	public Card(String cardno, String cardholdername, double cardbalance, LocalDate cardissueddate, LocalDate cardexpirydate,
			String cardstatus, long bankid) {
		super();
		this.cardno = cardno;
		this.cardholdername = cardholdername;
		this.cardbalance = cardbalance;
		this.cardissueddate = cardissueddate;
		this.cardexpirydate = cardexpirydate;
		this.cardstatus = cardstatus;
		this.bankid = bankid;
	}


	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public String getCardholdername() {
		return cardholdername;
	}


	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}


	public double getCardbalance() {
		return cardbalance;
	}


	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}


	public LocalDate getCardissueddate() {
		return cardissueddate;
	}


	public void setCardissueddate(LocalDate cardissueddate) {
		this.cardissueddate = cardissueddate;
	}


	public LocalDate getCardexpirydate() {
		return cardexpirydate;
	}


	public void setCardexpirydate(LocalDate cardexpirydate) {
		this.cardexpirydate = cardexpirydate;
	}


	public String getCardstatus() {
		return cardstatus;
	}


	public void setCardstatus(String cardstatus) {
		this.cardstatus = cardstatus;
	}


	public long getBankid() {
		return bankid;
	}


	public void setBankid(long bankid) {
		this.bankid = bankid;
	}

	
	
	

}
