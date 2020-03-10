package com.oracle.cmp.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"*.jsp","/controller/*"})
public class CmpFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();
		if(!"/login.jsp".equals(path) && !"/controller/login".equals(path)) {
			HttpSession session = request.getSession();
			if(session.getAttribute("user")==null) {
				PrintWriter pw = response.getWriter();
				pw.print("<script>");
				pw.print("parent.parent.parent.location.href='"+request.getContextPath()+"/login.jsp'");
				pw.print("</script>");
				return;
			}
		}
			chain.doFilter(request, response); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
