package com.oracle.cmp.test;

import java.util.Date;

import org.junit.Test;

import com.oracle.cmp.entity.Order;
import com.oracle.cmp.service.OrderService;

public class OrderTest {
	
	@Test
	public void test() {
		OrderService service = new OrderService();
		/*Map map = new HashMap();
		map.put("orderFlag", "2");
		List<Order> list = service.query(map);
		for (Order order : list) {
			System.out.println(order.getOrderCode());
			System.out.println(order.getOrderFlag());
			System.out.println(order.getOrderId());
			System.out.println(order.getOrderDate());
		}*/
		Order order = new Order();
		order.setOrderCode("DD2011103003");
		order.setOrderDate(new Date());
		order.setOrderFlag("2");
		order.setOrderId(24);
		service.update(order);
	}
}	
