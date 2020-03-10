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
import com.oracle.cmp.entity.Code;
import com.oracle.cmp.entity.PartsRepBill;
import com.oracle.cmp.service.CodeService;
import com.oracle.cmp.service.PartsRepBillService;

@WebServlet("/controller/partsrepbill")
public class PartsRepBillController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		PartsRepBillService partsRepBillservice = new PartsRepBillService();
		if("query".equals(flag)) {
			CodeService service = new CodeService();
			Map map = new HashMap();
			List<Code> codeList = service.select(map);
			request.setAttribute("codeList", codeList);
			String partsName = request.getParameter("partsName");
			String billFlag = request.getParameter("billFlag");
			String billType = request.getParameter("billType");
			String billTime = request.getParameter("billTime");
			 map = new HashMap();
			map.put("partsName", partsName);
			map.put("billFlag", billFlag);
			map.put("billType", billType);
			map.put("billTime", billTime);
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			List<PartsRepBill> partsRepBillList = partsRepBillservice.select(map);
			PageInfo<PartsRepBill> pageInfo = new PageInfo<PartsRepBill>(partsRepBillList);	
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/partssys/partsrepbill/partsrepbilllist.jsp").forward(request, response);			
		}
	}
}
