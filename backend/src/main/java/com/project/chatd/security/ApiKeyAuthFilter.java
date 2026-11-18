package com.project.chatd.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyAuthFilter extends OncePerRequestFilter{

	private final String apiKeyHeaderName = "CHATD-KEY";
	private final String expectedApiKey;
	
	public ApiKeyAuthFilter(String expectedApiKey) {
		this.expectedApiKey = expectedApiKey;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestApiKey = request.getHeader(apiKeyHeaderName);
		
		if(requestApiKey != null && requestApiKey.equalsIgnoreCase(expectedApiKey)) 
		{
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("API-CLIENT", null, Collections.emptyList());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}

}
