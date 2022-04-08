package com.User.User_Management_System.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BackButton_Prevention implements Filter {
	static Logger log = LogManager.getLogger(BackButton_Prevention.class.getName());
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("Enter in BackButton_Prevention filter");
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		 HttpSession session=req.getSession(false);
		 if(session.getAttribute("USER")==null)
		 {
			res.sendRedirect("index.jsp");
		 }
		 else
		 {
			 	res.setHeader("Cache-Control","no-chache,no-store,must-revalidate");
				res.setHeader("Pragma", "no-chache");
				res.setDateHeader("Expires", 0);
				chain.doFilter(request, response);
		 }
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
