package com.example.demo.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
public class BaseFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest  = (HttpServletRequest) request;
		String activityId = httpServletRequest.getHeader("activity_id");
		if(!ObjectUtils.isEmpty(activityId)) {
			MDC.put("traceId", activityId);
		}
		else {
			activityId = MDC.get("traceId");
		}
		
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("activity_id", activityId);
        chain.doFilter(request, response);
	}
   
}