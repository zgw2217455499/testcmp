package com.oracle.cmp.test;

import org.junit.Test;

import com.oracle.cmp.entity.Order;
import com.oracle.cmp.entity.OrderDetail;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.service.OrderDetailService;

public class OrderDetailTest {
	
	@Test
	public void test() {
		OrderDetailService orderDetailService = new OrderDetailService();
		/*Map map = new HashMap();
		map.put("orderFlag", "2");
		List<OrderDetail> list = orderDetailService.select(map);
		for (OrderDetail orderDetail : list) {
			System.out.println(orderDetail.getOrderDetailId());
			System.out.println(orderDetail.getOrderPartsCount());
			System.out.println(orderDetail.getOrder().getOrderDate());
			System.out.println(orderDetail.getOrder().getOrderFlag());
			System.out.println(orderDetail.getOrder().getOrderCode());
			System.out.println(orderDetail.getPartsId().getPartsId());
			System.out.println(orderDetail.getPartsId().getPartsName());
			
		}*/
		OrderDetail orderDetail = new OrderDetail();
		Order order = new Order();
		order.setOrderId(2);
		orderDetail.setOrder(order);
		orderDetail.setOrderPartsCount(1);
		Parts parts = new Parts();
		parts.setPartsId(100);
		orderDetail.setPartsId(parts);
		orderDetailService.insert(orderDetail);
	}
}
