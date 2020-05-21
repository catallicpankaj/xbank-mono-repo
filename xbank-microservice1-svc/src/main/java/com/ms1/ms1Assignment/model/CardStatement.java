package com.ms1.ms1Assignment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CardStatement implements Serializable {

	private User user;
	private String cardNumber;
	private String balance;
	private String currency;
	private List<Transactions> transactions;
}
