package com.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Sample implements Filter{
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("one time code: create object");
	}
	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("Every req....?");
		HttpServletRequest req=(HttpServletRequest) request;
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		fc.doFilter(request,responce);
	}
	public void destroy() {
		
	}
	

}
