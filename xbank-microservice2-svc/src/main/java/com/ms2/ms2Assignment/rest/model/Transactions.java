package com.ms2.ms2Assignment.rest.model;

public class Transactions {

	public Transactions(String date, String transactionType, int amount) {
		super();
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	protected String date;
	protected String transactionType;
	protected int amount;

	/**
	 * Gets the value of the date property.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the value of the date property.
	 */
	public void setDate(String value) {
		this.date = value;
	}

	/**
	 * Gets the value of the transactionType property.
	 * 
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * Sets the value of the transactionType property.
	 */
	public void setTransactionType(String value) {
		this.transactionType = value;
	}

	/**
	 * Gets the value of the amount property.
	 * 
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 */
	public void setAmount(int value) {
		this.amount = value;
	}

}
