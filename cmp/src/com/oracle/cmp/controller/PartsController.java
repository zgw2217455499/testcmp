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
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.service.PartsService;

@WebServlet("/controller/parts")
public class PartsController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		PartsService partsService = new PartsService();
		if("query".equals(flag)) {
			String partsName = request.getParameter("partsName");
			Map map = new HashMap();
			map.put("partsName", partsName);
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			List<Parts> partsList = partsService.query(map);
			PageInfo<Parts> pageInfo = new PageInfo<Parts>(partsList);	
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/partssys/parts/partslist.jsp").forward(request, response);			
		}
		if("add".equals(flag)) {
				String partsName = request.getParameter("partsName");
				String partsModel = request.getParameter("partsModel");
				String partsLoc = request.getParameter("partsLoc");
				String partsProDate = request.getParameter("partsProDate");
				String partsRemark = request.getParameter("partsRemark");
				Parts parts = new Parts();
				parts.setPartsLoc(partsLoc);
				parts.setPartsModel(partsModel);
				parts.setPartsName(partsName);
				parts.setPartsProDate(Common.getDate(partsProDate));
				parts.setPartsRemark(partsRemark);
				partsService.insert(parts);
				response.sendRedirect(request.getContextPath()+"/controller/parts?flag=query");
		}
		if("edit".equals(flag)) {
			String partsId = request.getParameter("partsId");
			Parts parts = partsService.selectById(Common.getInt(partsId));
			request.setAttribute("parts", parts);
			request.getRequestDispatcher("/page/partssys/parts/partsedit.jsp").forward(request, response);			
		}
		if("update".equals(flag)) {
			String partsName = request.getParameter("partsName");
			String partsModel = request.getParameter("partsModel");
			String partsLoc = request.getParameter("partsLoc");
			String partsProDate = request.getParameter("partsProDate");
			String partsRemark = request.getParameter("partsRemark");
			String partsId = request.getParameter("partsId");
			Parts parts = new Parts();
			parts.setPartsLoc(partsLoc);
			parts.setPartsModel(partsModel);
			parts.setPartsName(partsName);
			parts.setPartsProDate(Common.getDate(partsProDate));
			parts.setPartsRemark(partsRemark);
			parts.setPartsId(Common.getInt(partsId));
			partsService.update(parts);
			response.sendRedirect(request.getContextPath()+"/controller/parts?flag=query");
		}
		if("delete".equals(flag)) {
			String partsId = request.getParameter("partsId");
			partsService.delete(Common.getInt(partsId));
			response.sendRedirect(request.getContextPath()+"/controller/parts?flag=query");		
		}
		/*if("queryByName".equals(flag)) {
			String partsName = request.getParameter("partsName");
			Map map = new HashMap();
			map.put("partsName", partsName);
			Parts parts = partsService.selectByName(map);
			
		}*/
		
	}
}
