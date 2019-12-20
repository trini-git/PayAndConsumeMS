package com.payandconsume.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credit_card")
public class CreditCardModel {
	
	private String id;
	private String creditCardNumber;
	private String accountNumber;
	private Double creditLimit;
	private Double avalibleAmount;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getAvalibleAmount() {
		return avalibleAmount;
	}

	public void setAvalibleAmount(Double avalibleAmount) {
		this.avalibleAmount = avalibleAmount;
	}
	
	
}
