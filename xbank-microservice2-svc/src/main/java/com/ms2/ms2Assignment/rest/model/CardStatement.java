package com.ms2.ms2Assignment.rest.model;

import java.util.List;

public class CardStatement {

	private User user;
	private String cardNumber;
	private String balance;
	private String currency;
	private double spendingLimit;
	private List<Transactions> transactions;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getSpendingLimit() {
		return spendingLimit;
	}

	public void setSpendingLimit(double spendingLimit) {
		this.spendingLimit = spendingLimit;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

}
