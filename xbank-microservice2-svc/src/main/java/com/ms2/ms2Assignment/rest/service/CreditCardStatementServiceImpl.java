package com.ms2.ms2Assignment.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ms2.ms2Assignment.rest.model.CardStatement;
import com.ms2.ms2Assignment.rest.model.CreditCardStatement;
import com.ms2.ms2Assignment.rest.model.Transactions;
import com.ms2.ms2Assignment.rest.model.User;

@Service("creditCardStatementService")
public class CreditCardStatementServiceImpl implements CreditCardStatementService {

	private static Map<String, CardStatement> cardStatements;

	static {
		cardStatements= new HashMap<String, CardStatement>();
		populateDummyStatement();
	}

	private static long getRandomNo() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return number;
	}

	private static void populateDummyStatement() {
		User user = new User();
		user.setFirstName("Sam");
		user.setLastName("tuck");
		user.setUserId("1");
		user.setAddress("address 1 test");
		user.setPhoneNo("9872778897");
		user.setEmailAddress("Sam.tuck@gmail.com");

		CardStatement accountstatement = new CreditCardStatement();
		accountstatement.setCardNumber("222222");
		accountstatement.setBalance("21237");

		accountstatement.setCurrency("Rupee");

		List<Transactions> transt = new ArrayList<Transactions>();
		transt.add(initTransactions(-627, "2-04-20", "Credit"));
		transt.add(initTransactions(189, "27-04-20", "Debit"));
		transt.add(initTransactions(-278, "29-04-20", "Debit"));
		transt.add(initTransactions(281, "30-04-20", "Debit"));
		
		accountstatement.setTransactions(transt);

		accountstatement.setUser(user);

		cardStatements.put(accountstatement.getCardNumber(), accountstatement);

		User user1 = new User();
		user1.setFirstName("Tom");
		user1.setLastName("tuck");
		user1.setUserId("2");
		user1.setAddress("address 2 test");
		user1.setPhoneNo("9872234897");
		user1.setEmailAddress("Tom.tuck@gmail.com");
		List<Transactions> trans = new ArrayList<Transactions>();
		trans.add(initTransactions(-90, "2-04-20", "Credit"));
		trans.add(initTransactions(1, "7-04-20", "Debit"));
		trans.add(initTransactions(-1000, "9-04-20", "Debit"));
		trans.add(initTransactions(78, "27-04-20", "Debit"));

		CardStatement accountstatement1 = new CreditCardStatement();
		accountstatement1.setCardNumber("213333");
		accountstatement1.setBalance("34567");

		accountstatement1.setCurrency("Rupee");
		accountstatement1.setTransactions(trans);
		accountstatement1.setUser(user1);
		cardStatements.put(accountstatement1.getCardNumber(), accountstatement1);

		User user2 = new User();
		user2.setFirstName("Jerome");
		user2.setLastName("Tuck");
		user2.setUserId("3");
		user2.setAddress("address3 test");
		user2.setPhoneNo("981727278");
		user2.setEmailAddress("Jerome.tuck@gmail.com");
		CardStatement accountstatement2 = new CreditCardStatement();
		accountstatement2.setCardNumber("214444");
		accountstatement2.setBalance("26738");

		accountstatement2.setCurrency("Rupee");
		accountstatement2.setUser(user2);
		List<Transactions> trans1 = new ArrayList<Transactions>();
		trans1.add(initTransactions(-67, "2-04-20", "Credit"));
		trans1.add(initTransactions(910, "17-04-20", "Debit"));
		trans1.add(initTransactions(-9189, "19-04-20", "Debit"));
		trans1.add(initTransactions(9010, "27-04-20", "Debit"));
		accountstatement2.setTransactions(trans1);
		cardStatements.put(accountstatement2.getCardNumber(), accountstatement2);

		CardStatement accountstatement3 = new CreditCardStatement();
		accountstatement3.setCardNumber("215555");
		accountstatement3.setBalance("223112");

		accountstatement3.setCurrency("Rupee");
		User user3 = new User();
		user3.setFirstName("Silvia");
		user3.setLastName("tuck");
		user3.setUserId("4");
		user3.setAddress("address 4test");
		user3.setPhoneNo("9809090911");
		user3.setEmailAddress("Silvia.tuck@gmail.com");
		accountstatement3.setUser(user3);
		List<Transactions> transt3 = new ArrayList<Transactions>();
		transt3.add(initTransactions(-627, "2-04-20", "Credit"));
		transt3.add(initTransactions(189, "27-04-20", "Debit"));
		transt3.add(initTransactions(-278, "29-04-20", "Debit"));
		transt3.add(initTransactions(281, "30-04-20", "Debit"));
		accountstatement3.setTransactions(transt3);
		cardStatements.put(accountstatement3.getCardNumber(), accountstatement3);

	}

	private static Transactions initTransactions(int increment, String date, String txType) {
		return new Transactions(date, txType, (4563 + increment));

	}

	@Override
	public boolean isCardExist(String id) {
		CardStatement accountState = cardStatements.get(id);
		if (accountState != null) {
			return true;
		}
		return false;
	}

	@Override
	public CardStatement findById(String id) {
		return cardStatements.get(id);
	}

}
