package com.ms1.ms1Assignment.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms1.ms1Assignment.model.CardStatement;
import com.ms1.ms1Assignment.model.UserStatement;
import com.ms1.ms1Assignment.soap.models.GetAccountBalanceRequest;
import com.ms1.ms1Assignment.soap.models.GetAccountBalanceResponse;
import com.ms1.ms1Assignment.wsclient.rest.RestClientImpl;
import com.ms1.ms1Assignment.wsclient.soap.SoapClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
@RefreshScope
public class M2MStatementService {

	@Value("${ms2Endpoint}")
	private String ms2Endpoint;

	@Value("${clientId}")
	private String clientId;

	@Autowired
	private RestClientImpl restClient;
	@Autowired
	private SoapClient soapClient;

	public UserStatement getUserStatement(String userId, String accountNo, String cardNo) throws Throwable {
		String ms2PublicURL = ms2Endpoint + "/api/creditcard/" + cardNo + "/statement";
		log.info("Inside Service- User ID :{}", userId);

		CompletableFuture<ResponseEntity<CardStatement>> cardStatement = restClient.get(ms2PublicURL, null,
				CardStatement.class);
		GetAccountBalanceRequest accountStatementRequest = new GetAccountBalanceRequest();
		accountStatementRequest.setAccountNo(accountNo);
		CompletableFuture<GetAccountBalanceResponse> accountStatement = soapClient.soap(GetAccountBalanceResponse.class,
				accountStatementRequest);
		CompletableFuture.allOf(cardStatement, accountStatement).join();

		UserStatement userStatement = new UserStatement(userId, cardStatement.get().getBody(),
				accountStatement.get().getBalance(), "success");
		return userStatement;
	}

}
