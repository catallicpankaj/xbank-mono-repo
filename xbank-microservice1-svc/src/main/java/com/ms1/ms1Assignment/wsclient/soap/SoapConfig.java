package com.ms1.ms1Assignment.wsclient.soap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;



@Configuration
@Component
@Slf4j
@RefreshScope
public class SoapConfig {
	@Value("${ms2Endpoint}")
	private String ms2Endpoint;
	
	String defaultURI = "http://localhost:3011/ws";

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.ms1.ms1Assignment.soap.models");
		return marshaller;
	}

	@Bean
	public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
		SOAPConnector client = new SOAPConnector();
		log.debug("Soap connector :: Default URI:{}", defaultURI);
		client.setDefaultUri(defaultURI);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
