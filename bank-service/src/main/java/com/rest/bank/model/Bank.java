package com.rest.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@Column(name = "bankid")
	@Range(min=10000, max=99999)
	private long bankid;
	
	@Column(name = "bankname")
	@Size(min = 3, max = 25,message = "Bankname must be between 3 and 25 characters")
	private String bankname;
	

	@Column(name = "bankaddress")
	@Size(min = 3, max = 50,message = "Bankaddress must be between 3 and 50 characters")
	private String bankaddress;
	

	//@Column(name = "cardcount",columnDefinition = "short default 0")
	@Column(name = "cardcount")
	@PositiveOrZero
	private short cardcount;
	

	public Bank() {
		
	}


	public Bank(long bankid, String bankname, String bankaddress,short cardcount) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.bankaddress = bankaddress;
		this.cardcount = cardcount;
	}


	public long getBankid() {
		return bankid;
	}


	public void setBankid(long bankid) {
		this.bankid = bankid;
	}


	public String getBankname() {
		return bankname;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	public String getBankaddress() {
		return bankaddress;
	}


	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}


	public short getCardcount() {
		return cardcount;
	}


	public void setCardcount(short cardcount) {
		this.cardcount = cardcount;
	}

//	public getcardcount(long bankid) {
//		return cardcount;
//	}
	
	

}
