package com.ms1.ms1Assignment.controller;


import com.mashape.unirest.http.exceptions.UnirestException;
import com.ms1.ms1Assignment.model.Message;
import com.ms1.ms1Assignment.service.M2MService;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {

    @Autowired
    M2MService m2MService;

    @GetMapping(value = "/public")
    public String publicEndpoint(HttpServletRequest request) {
        return m2MService.httpCall(request);

    }
    
    @GetMapping(value = "/publicNew")
    public String publicEndpointNew(HttpServletRequest request) {
        return m2MService.httpCallNew(request);

    }

    @GetMapping(value = "/private")
    public String privateEndpoint(HttpServletRequest request) throws UnirestException, JSONException {
        return m2MService.httpsCallWithToken(request);
    }

    @GetMapping(value = "/private-scoped")
    public Message privateScopedEndpoint() {
        return new Message("All good. MS1 /api/private-scope");
    }
}