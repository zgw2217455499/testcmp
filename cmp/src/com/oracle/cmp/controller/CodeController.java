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

import com.oracle.cmp.entity.Code;
import com.oracle.cmp.service.CodeService;

@WebServlet("/controller/code")
public class CodeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		CodeService service = new CodeService();
		if("query".equals(flag)) {
			Map map = new HashMap();
			List<Code> codeList = service.select(map);
			request.setAttribute("codeList", codeList);
			request.getRequestDispatcher("/page/partssys/partsrepbill/partsrepbilllist.jsp").forward(request, response);			
		}
	}
}
