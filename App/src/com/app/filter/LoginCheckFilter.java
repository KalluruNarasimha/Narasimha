package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
	private List<String> uriList=null;
	public void init(FilterConfig fc) throws ServletException {
		String uristr=fc.getInitParameter("noCheckuri");
		StringTokenizer st=new StringTokenizer(uristr,",");
		uriList=new ArrayList<String>();
		while(st.hasMoreTokens()){
			String uri=st.nextToken();
			uriList.add(uri);
		}
	}
	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain fc) throws IOException, ServletException {
		try{
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse res=(HttpServletResponse) responce;
			// cleare check-on logout
			res.setHeader("Check-Control","no-cache,no-store,must-revalidate");
			res.setHeader("Pragma","no-cache");
			res.setDateHeader("Expires",0);
			
			String requri=req.getRequestURI();
			boolean flag=uriList.contains(requri);
			if(!flag){
				// if not in link-do session cheking
				// read current session 
				HttpSession hs=req.getSession(false);
				if(hs==null||hs.getAttribute("userName")==null){
					((HttpServletResponse) hs).sendRedirect(req.getContextPath()+"/mvc/login");
				}
			}
		}catch(Exception e){
			
		}
		// continue same if url exist in link 
		fc.doFilter(request,responce);
	}
	public void destroy() {
		
	} 
}
