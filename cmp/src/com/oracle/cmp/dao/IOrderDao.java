package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.Order;

public interface IOrderDao {
	public List<Order> select();
	public List<Order> selectOrder(Map map);
	public void insert(Order order);
	public void update(Order order);
}
