package com.oracle.cmp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.cmp.entity.User;
import com.oracle.cmp.service.LoginService;
import com.oracle.cmp.service.UserService;

@WebServlet("/controller/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		UserService userService = new UserService();
		if("login".equals(flag)) {
			String loginName = request.getParameter("loginName");
			String loginPwd = request.getParameter("loginPwd");
			LoginService loginService = new LoginService();
			User user = loginService.login(loginName, loginPwd);
			PrintWriter pw = response.getWriter();
			if(user==null) {
				//登录失败
				pw.print("0");
			}else if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				ServletContext application = this.getServletContext();
				if(application.getAttribute(loginName)!=null) {
					HttpSession otherSession = (HttpSession)application.getAttribute(loginName);
					if(otherSession!=null && otherSession.getAttribute("user")!=null) {
						if(otherSession.getId()!=session.getId()) {						
							otherSession.invalidate();
						}
					}
				}
				application.setAttribute(loginName, session);
				pw.print("1");
			}
		}
	}
}
