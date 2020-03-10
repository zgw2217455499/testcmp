package com.oracle.cmp.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.oracle.cmp.entity.OrderDetail;
import com.oracle.cmp.service.OrderDetailService;
import com.oracle.cmp.service.OrderService;

@WebServlet("/controller/orderdetail")
public class OrderDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		OrderDetailService orderDetailService = new OrderDetailService();
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
			List<OrderDetail> orderDetailList = orderDetailService.select(map);
			PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(orderDetailList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/ordersys/order/orderchecklist.jsp").forward(request, response);
		}
		if("pass".equals(flag)) {
			String orderId = request.getParameter("orderId");
			Order order = new Order();
			order.setOrderFlag("0");
			order.setOrderId(Common.getInt(orderId));
			OrderService orderService = new OrderService();
			orderService.update(order);
			Map map = new HashMap();
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			List<OrderDetail> orderDetailList = orderDetailService.select(map);
			PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(orderDetailList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/ordersys/order/orderchecklist.jsp").forward(request, response);
		}
		if("nopass".equals(flag)) {
			String orderId = request.getParameter("orderId");
			Order order = new Order();
			order.setOrderFlag("1");
			order.setOrderId(Common.getInt(orderId));
			OrderService orderService = new OrderService();
			orderService.update(order);
			Map map = new HashMap();
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			List<OrderDetail> orderDetailList = orderDetailService.select(map);
			PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(orderDetailList);
			request.setAttribute("pageInfo", pageInfo);
			request.getRequestDispatcher("/page/ordersys/order/orderchecklist.jsp").forward(request, response);
		}
	}
}
