package com.ms1.ms1Assignment.service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ms1.ms1Assignment.model.RequestDetails;
import com.ms1.ms1Assignment.wsclient.rest.RestClient;

import lombok.extern.slf4j.Slf4j;


@Component
@Service
@Slf4j
@RefreshScope
public class M2MService {

    @Value("${ms2Endpoint}")
    private String ms2Endpoint;

    @Value("${clientId}")
    private String clientId;
    
    @Autowired
    private RestClient<String, String> restClient;

    public String httpCall(HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String ms2PublicURL = ms2Endpoint+"/api/creditcard/222222/statement";
       return restTemplate.getForObject(ms2PublicURL, String.class);
    }
    
	public String httpCallNew(HttpServletRequest request) {
		return restClient.execute(new RequestDetails(ms2Endpoint + "/api/public", HttpMethod.GET), " ", String.class);
	}

    public String httpsCallWithToken(HttpServletRequest request) throws UnirestException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String ms2PrivateURL = ms2Endpoint+"/api/private";
        JSONObject tokenForMS2 = getTokenForMS2();
       /* HttpEntity<String> httpEntity = new HttpEntity("headers",setHeaders(tokenForMS2.get("access_token").toString()));*/

        HttpResponse<String> ms2Response = Unirest.get(ms2PrivateURL)
                .header("Authorization", "Bearer " + tokenForMS2.get("access_token").toString())
                .header("content-type", "application/json")
                .asString();
//        ResponseEntity<String> response = restTemplate.exchange(ms2PrivateURL, HttpMethod.GET, httpEntity,String.class);
        log.info(ms2Response.getBody());
        return ms2Response.getBody();
    }

    JSONObject getTokenForMS2() throws UnirestException, JSONException {
        HttpResponse<String> response = Unirest.post("https://dev-as7wcbil.auth0.com/oauth/token")
                .header("content-type", "application/json")
                .body("{\"client_id\":\"JdkgklkyfSXshZdMoFB2eMKo0u6L6Lx7\",\"client_secret\":\"QPFLdlqATabR292JjsfpiHb_Z_A59jckgE8DdUmokJYMp7RByiv2Y78EVPOQcN_g\",\"audience\":\"https://xbankMS2\",\"grant_type\":\"client_credentials\"}")
                .asString();
        return new JSONObject(response.getBody());
    }



    private HttpHeaders setHeaders(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set("Authorization","Bearer " + accessToken);
        return httpHeaders;
    }

}
