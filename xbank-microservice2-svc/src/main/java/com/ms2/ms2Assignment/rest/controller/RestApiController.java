package com.ms2.ms2Assignment.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms2.ms2Assignment.rest.model.CardStatement;
import com.ms2.ms2Assignment.rest.model.User;
import com.ms2.ms2Assignment.rest.service.CreditCardStatementService;
import com.ms2.ms2Assignment.rest.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	CreditCardStatementService creditCardStatementService; 

	@RequestMapping(value = "/creditcard/{id}/statement", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") String id) {
		logger.info("Fetching credit card statement with id {}", id);
		CardStatement cardStatement = creditCardStatementService.findById(id);
		if (cardStatement == null) {
			logger.error("Credit card with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Credit card with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CardStatement>(cardStatement, HttpStatus.OK);
	}

}