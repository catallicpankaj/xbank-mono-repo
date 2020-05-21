package com.ms1.ms1Assignment.wsclient.soap;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Component
@Service
@Slf4j
@RefreshScope
public class SoapClientImpl implements SoapClient {
	@Autowired
	private  SOAPConnector soapConnector;
	
	@Value("${ms2Endpoint}")
	private String ms2Endpoint;
	
	String defaultURI = "http://localhost:3011/ws";
	
	
	@Async("asyncExecutor")
	public  <T> CompletableFuture<T> soap(Class<T> responseClass, Object request ) {
		log.debug("Inside Soap :{}", defaultURI);
		@SuppressWarnings("unchecked")
		T response = (T) soapConnector.callWebService(defaultURI,
				request);
		return CompletableFuture.completedFuture(response);
	}

}
