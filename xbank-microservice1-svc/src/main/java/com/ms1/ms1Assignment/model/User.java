package com.ms1.ms1Assignment.model;

import org.springframework.http.HttpMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	protected String userId;
	protected String firstName;
	protected String lastName;
	protected String phoneNo;
	protected String address;
	protected String gender;
	protected String emailAddress;


}
