package com.ms1.ms1Assignment.wsclient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ms1.ms1Assignment.model.RequestDetails;

@Component
public class RestClient<T, V> {

	@Autowired
    RestTemplateBuilder restTemplateBuilder;

	public V execute(RequestDetails requestDetails, T data,
			Class<V> genericClass) {
		
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<T> entity = new HttpEntity<T>(data, headers);
		ResponseEntity<V> response = restTemplateBuilder.build().exchange(requestDetails.getUrl(), requestDetails.getRequestType(),
				entity, genericClass);
		return response.getBody();
	}

}