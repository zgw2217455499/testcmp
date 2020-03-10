package com.oracle.cmp.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.common.Common;
import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IOrderDao;
import com.oracle.cmp.entity.Code;
import com.oracle.cmp.entity.Order;
import com.oracle.cmp.entity.OrderDetail;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.entity.PartsRepBill;
import com.oracle.cmp.entity.PartsRepertory;

public class OrderService {
	public List<Order> query(Map map){
		SqlSession session = Dao.getSqlSession();
		IOrderDao orderDao = session.getMapper(IOrderDao.class);
		List<Order> orderList = orderDao.selectOrder(map);
		session.commit();
		session.close();
		return orderList;
	}
	public void insert(Order order) {
		SqlSession session = Dao.getSqlSession();
		IOrderDao orderDao = session.getMapper(IOrderDao.class);
		orderDao.insert(order);
		session.commit();
		session.close();
	}
	public void update(Order order) {
		SqlSession session = Dao.getSqlSession();
		IOrderDao orderDao = session.getMapper(IOrderDao.class);
		orderDao.update(order);
		session.commit();
		session.close();
	}
	public boolean save(Order order,String [] partsIds,String[] counts) {
		SqlSession sqlSession = Dao.getSqlSession();
		PartsRepertoryService partsRepertoryService = new PartsRepertoryService();
		OrderService orderService = new OrderService();
		for(int i = 0;i<partsIds.length;i++){
			if(!partsRepertoryService.hasCount(Common.getInt(partsIds[i]),Common.getInt(counts[i]))){
				return false;
			}
		}
		for (int i = 0; i < partsIds.length; i++) {
			orderService.insert(order);
			OrderDetail orderDetail = new OrderDetail();
			OrderDetailService orderDetailService = new OrderDetailService(); 
			orderDetail.setOrder(order);
			Parts parts = new Parts();
			parts.setPartsId(Common.getInt(partsIds[i]));
			orderDetail.setPartsId(parts);
			orderDetail.setOrderPartsCount(Common.getInt(counts[i]));
			orderDetailService.insert(orderDetail);
			PartsRepBill partsRepBill = new PartsRepBill();
			Code code = new Code();
			code.setCode("O");
			code.setType("out2");
			partsRepBill.setBillFlag(code);
			partsRepBill.setBillType(code);
			partsRepBill.setBillCount(Common.getInt(counts[i]));
			partsRepBill.setBillTime(new Date());
			parts = new Parts();
			parts.setPartsId(Common.getInt(partsIds[i]));
			partsRepBill.setPartsId(parts);
			partsRepertoryService.repertory(partsRepBill);
		}
		sqlSession.commit();
		sqlSession.close();
		return true;
	}
}
