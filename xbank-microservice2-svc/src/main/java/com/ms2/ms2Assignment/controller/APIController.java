package com.ms2.ms2Assignment.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms2.ms2Assignment.model.Message;

/**
 * Handles requests to "/api" endpoints.
 */
@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {

	/*
	 * @GetMapping(value = "/public") public Message publicEndpoint() { return new
	 * Message("All good. MS2 /api/public."); }
	 * 
	 * @GetMapping(value = "/private") public Message privateEndpoint() { return new
	 * Message("All good. MS2 /api/private."); }
	 * 
	 * @GetMapping(value = "/private-scoped") public Message privateScopedEndpoint()
	 * { return new Message("All good. MS2 /api/private-scoped"); }
	 */

}
