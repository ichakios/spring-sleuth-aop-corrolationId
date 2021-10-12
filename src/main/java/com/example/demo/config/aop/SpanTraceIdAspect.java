package com.example.demo.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpanTraceIdAspect {

	Logger log = LoggerFactory.getLogger(SpanTraceIdAspect.class);
	
	
	@Before("execution(* com.example.demo.service.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		String functionName = joinPoint.getSignature().getName();
			
		MDC.put("spanId", functionName);
	}
}
