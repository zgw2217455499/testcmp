package com.oracle.cmp;

import com.oracle.cmp.service.OrderService;

public class Test {
	public static void main(String[] args) {
		OrderService service = new OrderService();
		service.query(null);
	}
}
