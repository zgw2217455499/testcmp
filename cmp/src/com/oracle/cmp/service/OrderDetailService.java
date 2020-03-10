package com.oracle.cmp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IOrderDetailDao;
import com.oracle.cmp.entity.OrderDetail;

public class OrderDetailService {
	public List<OrderDetail> select(Map map){
		SqlSession session = Dao.getSqlSession();
		IOrderDetailDao dao = session.getMapper(IOrderDetailDao.class);
		List<OrderDetail> orderDetailList = dao.select(map);
		session.commit();
		session.close();
		return orderDetailList;
	}
	public void insert(OrderDetail orderDetail) {
		SqlSession session = Dao.getSqlSession();
		IOrderDetailDao orderDetailDao = session.getMapper(IOrderDetailDao.class);
		orderDetailDao.insert(orderDetail);
		session.commit();
		session.close();
	}
}
