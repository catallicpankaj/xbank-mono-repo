package com.ms1.ms1Assignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms1.ms1Assignment.model.UserStatement;
import com.ms1.ms1Assignment.service.M2MStatementService;
import com.ms1.ms1Assignment.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "rest-api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class M2MController {

	@Autowired
	M2MStatementService m2mStatementService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/{userId}/statement", method = RequestMethod.GET)
	public UserStatement publicEndpoint(@PathVariable("userId") String userId) {
        log.info("Inside controller- User ID :{}", userId );

		if (!userId.isEmpty()) {
			try {
				String accountNo = userService.getAccountNo(userId);
				String cardNo = userService.getCardNo(userId);
				if (!accountNo.isEmpty() && !cardNo.isEmpty())
					return m2mStatementService.getUserStatement(userId, accountNo, cardNo);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		UserStatement userStatement = new UserStatement();
		userStatement.setStatus("Error:: user not found");
		return userStatement;

	}
}