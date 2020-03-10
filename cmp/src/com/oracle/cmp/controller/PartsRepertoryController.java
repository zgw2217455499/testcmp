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
import com.oracle.cmp.entity.Code;
import com.oracle.cmp.entity.Order;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.entity.PartsRepBill;
import com.oracle.cmp.entity.PartsRepertory;
import com.oracle.cmp.service.CodeService;
import com.oracle.cmp.service.OrderService;
import com.oracle.cmp.service.PartsRepBillService;
import com.oracle.cmp.service.PartsRepertoryService;
import com.oracle.cmp.service.PartsService;

import net.sf.json.JSONArray;

@WebServlet("/controller/partsrepertory")
public class PartsRepertoryController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		PartsService partsService = new PartsService();
		PartsRepertoryService service = new PartsRepertoryService();
		PartsRepBillService billService = new PartsRepBillService();
		if("query".equals(flag)) {
			String partsId = request.getParameter("partsId");
			String partsName = request.getParameter("partsName");
			String pageNo = request.getParameter("pageNo");
			pageNo = pageNo ==null?"1":pageNo;
			PageHelper.startPage(Integer.parseInt(pageNo), Common.PAGESIZE);
			Map map = new HashMap();		
			map.put("partsId", partsId);
			map.put("partsName", partsName);						
			List<PartsRepertory> partsRepertoryList = service.select(map);
			PageInfo<PartsRepertory> pageInfo = new PageInfo<PartsRepertory>(partsRepertoryList);	
			request.setAttribute("pageInfo", pageInfo);	
			CodeService codeService = new CodeService();
			 map = new HashMap();
			List<Code> typeList = codeService.select(map);
			request.setAttribute("typeList", typeList);
			request.getRequestDispatcher("/page/partssys/partsrep/partsreplist.jsp").forward(request, response);			
		}
		
		if("query2".equals(flag)) {
			String billFlag = request.getParameter("billFlag");
			PrintWriter pw = response.getWriter();
			if("I".equals(billFlag)) {
				CodeService codeService = new CodeService();
				Map map = new HashMap();
				map.put("type", "in");
				List<Code> list = codeService.select(map);
				pw.print((JSONArray.fromObject(list)));
			}
			if("O".equals(billFlag)) {
				CodeService codeService = new CodeService();
				Map map = new HashMap();
				map.put("type", "out");
				List<Code> list = codeService.select(map);
				pw.print((JSONArray.fromObject(list)));
			}	
			
		}
		if("query3".equals(flag)) {
			Date date = new Date();
			Map map = new HashMap();
			List<Parts> partsList = partsService.query(map);
			request.setAttribute("date", date);
			request.setAttribute("partsList", partsList);
			request.getRequestDispatcher("/page/partssys/partsrep/partsrep.jsp").forward(request, response);
		}
		
		if("save".equals(flag)) {
			String billFlag = request.getParameter("billFlag");
			String billType = request.getParameter("billType");
			String partsId = request.getParameter("partsId");
			String billCount = request.getParameter("billCount");
			PartsRepBill bill = new PartsRepBill();
			bill.setBillCount(Common.getInt(billCount));
			Code code = new Code();
			code.setType(billType);
			code.setCode(billFlag);
			bill.setBillFlag(code);
			bill.setBillType(code);
			Parts parts = new Parts();
			parts.setPartsId(Common.getInt(partsId));
			bill.setPartsId(parts);  
			bill.setBillTime(new Date());
			//  得到一个bill对象
			//调用hasCount 和repertory 方法
			PrintWriter pw = response.getWriter();
			boolean b = service.hasCount(Common.getInt(partsId), Common.getInt(billCount));
			if(!b && "O".equals(billFlag)) {
				pw.print("0");
				return;
			}else {
				pw.print("1");
				service.repertory(bill);
			}
		}
		
			
		
	}
}	
