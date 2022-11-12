package com.rest.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/resilience-test")

// default policy retries 3 times	
//	@Retry(name = "default",fallbackMethod= "fallbackmessage")
	
// custom policy retries based on application properties	
//	@Retry(name = "custom-policy",fallbackMethod= "fallbackmessage")
	
//	@CircuitBreaker(name = "default",fallbackMethod= "fallbackmessage")
	
	@RateLimiter(name = "default")
	
	
	public String resilience(){
		
		logger.info("Log:Bankservice: Hits for resilience demo");
		
//		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:9999/unused", String.class);
//		return entity.getBody();
		
		return "Ratelimiter Demo";
		
	}
	
	public String fallbackmessage (Exception e){
		
		return "This is a fallback response";
	}
	
}		