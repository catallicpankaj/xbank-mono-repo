package com.xbank.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class XbankConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XbankConfigServerApplication.class, args);
	}

}
