package com.ms2.ms2Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.usbank.producing_web_service.AccountStatement;
import com.usbank.producing_web_service.Transactions;
import com.usbank.producing_web_service.User;

@Component
public class AccountStatementRepository {

	private static final Map<String, AccountStatement> accountList = new HashMap<>();

	@PostConstruct
	public void initData() {

		User user = new User();
		user.setFirstName("Sam");
		user.setLastName("tuck");
		user.setUserId("1");
		user.setAddress("address 1 test");
		user.setPhoneNo("9872778897");
		user.setEmailAddress("Sam.tuck@gmail.com");

		AccountStatement accountstatement = new AccountStatement();
		accountstatement.setAccountNo("12222");
		accountstatement.setBalance("234562");

		accountstatement.setCurrency("Rupee");

		List<Transactions> transt = new ArrayList<Transactions>();
		transt.add(initTransactions(-627, "2-04-20", "Credit"));
		transt.add(initTransactions(189, "27-04-20", "Debit"));
		transt.add(initTransactions(-278, "29-04-20", "Credit"));
		transt.add(initTransactions(281, "30-04-20", "Debit"));
		accountstatement.getTransactions().addAll(transt);

		accountstatement.setUser(user);

		accountList.put(accountstatement.getAccountNo(), accountstatement);

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
		trans.add(initTransactions(-1000, "9-04-20", "Credit"));
		trans.add(initTransactions(78, "27-04-20", "Debit"));

		AccountStatement accountstatement1 = new AccountStatement();
		accountstatement1.setAccountNo("13333");
		accountstatement1.setBalance("34567");

		accountstatement1.setCurrency("Rupee");
		accountstatement1.getTransactions().addAll(trans);
		accountstatement1.setUser(user1);
		accountList.put(accountstatement1.getAccountNo(), accountstatement1);

		User user2 = new User();
		user2.setFirstName("Jerome");
		user2.setLastName("Tuck");
		user2.setUserId("3");
		user2.setAddress("address3 test");
		user2.setPhoneNo("981727278");
		user2.setEmailAddress("Jerome.tuck@gmail.com");
		AccountStatement accountstatement2 = new AccountStatement();
		accountstatement2.setAccountNo("14444");
		accountstatement2.setBalance("382922");

		accountstatement2.setCurrency("Rupee");
		accountstatement2.setUser(user2);
		List<Transactions> trans1 = new ArrayList<Transactions>();
		trans1.add(initTransactions(-67, "2-04-20", "Credit"));
		trans1.add(initTransactions(910, "17-04-20", "Debit"));
		trans1.add(initTransactions(-9189, "19-04-20", "Credit"));
		trans1.add(initTransactions(9010, "27-04-20", "Debit"));
		accountstatement2.getTransactions().addAll(trans1);
		accountList.put(accountstatement2.getAccountNo(), accountstatement2);

		AccountStatement accountstatement3 = new AccountStatement();
		accountstatement3.setAccountNo("15555");
		accountstatement3.setBalance("829223");

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
		transt3.add(initTransactions(-278, "29-04-20", "Credit"));
		transt3.add(initTransactions(281, "30-04-20", "Debit"));
		accountstatement3.getTransactions().addAll(transt3);
		accountList.put(accountstatement3.getAccountNo(), accountstatement3);

	}

	private Transactions initTransactions(int increment, String date, String txType) {
		Transactions tx = new Transactions();
		tx.setAmount(15262 + increment);
		tx.setDate(date);
		tx.setTransactionType(txType);
		return tx;

	}

	public AccountStatement findStatement(String accountNo) {
		AccountStatement accountState = accountList.get(accountNo);
		if (accountState != null) {
			return accountState;
		}
		return new AccountStatement();
	}

}
