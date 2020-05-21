package com.ms1.ms1Assignment.model;

import org.springframework.http.HttpMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestDetails {
	
	private String url;
	private HttpMethod requestType;

}
