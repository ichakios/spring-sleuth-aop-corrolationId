package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SleuthService {
	

	Logger log = LoggerFactory.getLogger(SleuthService.class);
	
	public void doSomeWorkWithDifferentSpan() throws InterruptedException {
		log.info("I'm in the original span");
    }
}
