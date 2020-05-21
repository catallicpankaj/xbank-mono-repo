package com.ms1.ms1Assignment.wsclient.rest;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestClientImpl {

	private static final Logger log = LoggerFactory.getLogger(RestClientImpl.class);
	RestTemplate restTemplate = new RestTemplate();

	@Async("asyncExecutor")
	public <T> CompletableFuture<ResponseEntity<T>> get(String url, Object requestObj, Class<T> responseClass)
			throws ResourceAccessException, Exception {
		log.debug("Inside get method");

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Accept", "application/json");
			log.debug("url in get method :{}", url);
			ResponseEntity<T> response = restTemplate.exchange(new URI(url), HttpMethod.GET,
					new HttpEntity<Object>(headers), responseClass);
			if (response != null) {
				if (HttpStatus.OK.equals(response.getStatusCode())
						|| HttpStatus.CREATED.equals(response.getStatusCode())
						|| HttpStatus.NO_CONTENT.equals(response.getStatusCode())) {
				} else {
					// logger
				}
			}
			return CompletableFuture.completedFuture(response);
		} catch (ResourceAccessException e) {
			throw new ResourceAccessException(url);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception();
		}

	}

	@Async("asyncExecutor")
	public <T> CompletableFuture<ResponseEntity<T>> post(String url, Object requestObj, Class<T> responseClass)
			throws ResourceAccessException, Exception {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// URL decoding is pending

			ResponseEntity<T> response = restTemplate.exchange(new URI(url), HttpMethod.POST,
					new HttpEntity<Object>(requestObj, headers), responseClass);
			if (response != null) {
				if (HttpStatus.OK.equals(response.getStatusCode())
						|| HttpStatus.NO_CONTENT.equals(response.getStatusCode())) {
				} else {
				}
			}
			return CompletableFuture.completedFuture(response);
		} catch (ResourceAccessException e) {
			// error handling
			throw new Exception();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Async("asyncExecutor")
	public <T> CompletableFuture<ResponseEntity<T>> put(String url, Object requestObj, Class<T> responseClass)
			throws ResourceAccessException, Exception {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// URL decoding is pending

			ResponseEntity<T> response = restTemplate.exchange(new URI(url), HttpMethod.PUT,
					new HttpEntity<Object>(requestObj, headers), responseClass);
			if (response != null) {
				if (HttpStatus.OK.equals(response.getStatusCode())
						|| HttpStatus.NO_CONTENT.equals(response.getStatusCode())) {
				} else {
				}
			}
			return CompletableFuture.completedFuture(response);
		} catch (ResourceAccessException e) {
			// error handling
			throw new Exception();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Async("asyncExecutor")
	public <T> CompletableFuture<ResponseEntity<T>> delete(String url, Object requestObj, Class<T> responseClass)
			throws ResourceAccessException, Exception {
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// URL decoding is pending
			ResponseEntity<T> response = restTemplate.exchange(new URI(url), HttpMethod.DELETE,
					new HttpEntity<Object>(headers), responseClass);
			if (response != null) {
				if (HttpStatus.OK.equals(response.getStatusCode())) {
					// logger
				} else {
					// logger
				}
			}
			return CompletableFuture.completedFuture(response);
		} catch (ResourceAccessException e) {
			throw new Exception();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Async("asyncExecutor")
	public <T> CompletableFuture<ResponseEntity<T>> patch(String url, Object requestObj, Class<T> responseClass)
			throws ResourceAccessException, Exception {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			// URL decoding is pending

			ResponseEntity<T> response = restTemplate.exchange(new URI(url), HttpMethod.PATCH,
					new HttpEntity<Object>(requestObj, headers), responseClass);
			if (response != null) {
				if (HttpStatus.OK.equals(response.getStatusCode())
						|| HttpStatus.NO_CONTENT.equals(response.getStatusCode())) {
				} else {
				}
			}
			return CompletableFuture.completedFuture(response);
		} catch (ResourceAccessException e) {
			// error handling
			throw new Exception();
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
