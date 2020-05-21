package com.ms2.ms2Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.usbank.producing_web_service.GetAccountBalanceRequest;
import com.usbank.producing_web_service.GetAccountBalanceResponse;

@Endpoint
public class AccountStatementEndPoint {
	private static final String NAMESPACE_URI = "http://usbank.com/producing-web-service";

	private AccountStatementRepository accountStatementRepository;

	@Autowired
	public AccountStatementEndPoint(AccountStatementRepository accountStatementRepository) {
		this.accountStatementRepository = accountStatementRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountBalanceRequest")

	@ResponsePayload
	public GetAccountBalanceResponse getCountry(@RequestPayload GetAccountBalanceRequest request) {
		GetAccountBalanceResponse response = new GetAccountBalanceResponse();
		response.setBalance(accountStatementRepository.findStatement(request.getAccountNo()));
		return response;
	}

}
