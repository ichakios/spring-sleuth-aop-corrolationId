package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SleuthService;

@RestController
public class SleuthController {

	Logger log = LoggerFactory.getLogger(SleuthController.class);
	
	@Autowired
	SleuthService sleuthService;
    
	
	@GetMapping("/")
    public String helloSleuth() {
    	log.info("Hello Sleuth");
        return "success";
    }
	
    @GetMapping("/same-span")
    public String helloSleuthSameSpan() throws InterruptedException {
    	log.info("Same Span");
        sleuthService.doSomeWorkWithDifferentSpan();
        return "success";
}
}
