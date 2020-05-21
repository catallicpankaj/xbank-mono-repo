package com.ms1.ms1Assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
	protected String date;
	protected String transactionType;
	protected int amount;

}
