package com.User.User_Management_System.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import com.User.User_Management_System.Bean.User;

public class Check_UserRole implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
	    HttpSession session = httpReq.getSession(false);
	    User user = (User) session.getAttribute("USER");
	    if(user!=null)
	    {
	    		if(user.getRole().equals("admin"))
				{
			    	chain.doFilter(request, response);
				}
			    else
			    {
			    	((HttpServletResponse) response).sendRedirect("userDashBoard.jsp");
			    }
	    }
	    else
	    {
	    	((HttpServletResponse) response).sendRedirect("index.jsp");
	    }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
