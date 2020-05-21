package com.ms2.ms2Assignment.rest.service;


import com.ms2.ms2Assignment.rest.model.CardStatement;

public interface CreditCardStatementService {
	
	CardStatement findById(String id);
	
	boolean isCardExist(String card);
	
}
