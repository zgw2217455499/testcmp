package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.OrderDetail;

public interface IOrderDetailDao {
	public List<OrderDetail> select(Map map);
	public void insert(OrderDetail orderDetail);
}
