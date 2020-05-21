package com.ms1.ms1Assignment.model;

import com.ms1.ms1Assignment.soap.models.AccountStatement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatement {
	private String userId;
	private CardStatement cardStatement;
	private AccountStatement accountStatement;
	private String status;
}
