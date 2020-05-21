package com.ms1.ms1Assignment.service;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
@RefreshScope
public class UserService {

	public String getAccountNo(String userId) {
		if(!userId.isEmpty())
		switch (userId) {
		case "1":
			return "12222";
		case "2":
			return "13333";
		case "3":
			return "14444";
		case "4":
			return "15555";
		default:
			return "";
		}
		return "";
	}

	public String getCardNo(String userId) {
		if(!userId.isEmpty()) {
			switch (userId) {
			case "1":
				return "222222";
			case "2":
				return "213333";
			case "3":
				return "214444";
			case "4":
				return "215555";
			default:
				return "";
			}
		}
		return "";

	}

}