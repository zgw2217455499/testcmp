package com.oracle.cmp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.cmp.common.Common;
import com.oracle.cmp.entity.Emp;
import com.oracle.cmp.entity.User;
import com.oracle.cmp.service.EmpService;
import com.oracle.cmp.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/Controller/User")
public class UserController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		UserService userService = new UserService();
		if("query".equals(flag)){
			String loginName = request.getParameter("loginName");
			String name = request.getParameter("name");
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("loginName", loginName);
			map.put("name", name);			
			List<User> userList = userService.query(map);
			PageInfo<User> pageInfo = new PageInfo<User>(userList);
			request.setAttribute("loginName", loginName);
			request.setAttribute("name", name);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/system/user/userlist.jsp").forward(request, response);
		}else if("add".equals(flag)){
			EmpService empService = new EmpService();
			List<Emp> empList = empService.queryNoRegist();
			request.setAttribute("empList", empList);
			request.getRequestDispatcher("/page/system/user/useradd.jsp").forward(request, response);
		}else if("save".equals(flag)){
			String eid = request.getParameter("eid");
			String loginName = request.getParameter("loginName");
			String loginPwd = request.getParameter("loginPwd");
			User user = new User();
			Emp e = new Emp();
			e.setId(Integer.parseInt(eid));
			user.setE(e);
			user.setLoginName(loginName);
			user.setLoginPwd(loginPwd);
			userService.save(user);
			request.getRequestDispatcher("/Controller/User?flag=query").forward(request, response);
		}else if("delete".equals(flag)){
			String userId = request.getParameter("userId");
			userService.delete(Integer.parseInt(userId));
			request.getRequestDispatcher("/Controller/User?flag=query").forward(request, response);
		}else if("edit".equals(flag)){
			String userId = request.getParameter("userId");
			User user = userService.queryOne(Integer.parseInt(userId));
			request.setAttribute("user", user);
			request.getRequestDispatcher("/page/system/user/useredit.jsp").forward(request, response);
		}else if("update".equals(flag)){
			String userId = request.getParameter("userId");
			String loginPwd = request.getParameter("loginPwd");
			String eid = request.getParameter("eid");
			Emp e = new Emp();
			e.setId(Integer.parseInt(eid));
			User user = new User();
			user.setE(e);
			user.setUserId(Integer.parseInt(userId));
			user.setLoginPwd(loginPwd);
			userService.update(user);
			request.getRequestDispatcher("/Controller/User?flag=query").forward(request, response);
		}
	}

}
