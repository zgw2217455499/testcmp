package com.oracle.cmp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import com.oracle.cmp.entity.Order;
import com.oracle.cmp.entity.PartsRepertory;
import com.oracle.cmp.service.OrderService;
import com.oracle.cmp.service.PartsRepertoryService;

@WebServlet("/controller/order")
public class OrderController extends HttpServlet{	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		OrderService orderService = new OrderService();
		if("query".equals(flag)) {
			String orderCode = request.getParameter("orderCode");
			String orderDate = request.getParameter("orderDate");
			String orderFlag = request.getParameter("orderFlag");
			Map map = new HashMap();
			map.put("orderCode", orderCode);
			map.put("orderDate", orderDate);
			map.put("orderFlag", orderFlag);
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			List<Order> orderList = orderService.query(map);
			PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);	
			pageInfo.setList(orderList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/ordersys/order/orderlist.jsp").forward(request, response);
		}
		if("getmater".equals(flag)) {
			PartsRepertoryService partsRepertoryService  = new PartsRepertoryService();
			Map map = new HashMap();
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), 100);
			List<PartsRepertory> partsRepertoryList = partsRepertoryService.select(map);
			PageInfo<PartsRepertory> pageInfo = new PageInfo<PartsRepertory>(partsRepertoryList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/ordersys/order/getmater.jsp").forward(request, response);
		}
		if("save".equals(flag)) {
			String[] partsId = request.getParameterValues("materId");
			String[] counts = request.getParameterValues("count");
			Order order = new Order();
			order.setOrderCode("DD2016042201");
			order.setOrderDate(new Date());
			order.setOrderFlag("3");
			PrintWriter pw = response.getWriter();
			boolean b = orderService.save(order, partsId, counts);
			if(!b) {
				pw.write("0");
			}else {
				pw.write("1");
			}
		}
		
	}
}
