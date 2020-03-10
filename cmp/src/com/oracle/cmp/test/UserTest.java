package com.oracle.cmp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.oracle.cmp.entity.Emp;
import com.oracle.cmp.entity.User;
import com.oracle.cmp.service.UserService;


public class UserTest {
	
	@Test
	public void queryTest() {
		UserService userService = new UserService();
		Map map = new HashMap();
		map.put("loginName", "zhang");
		map.put("loginPwd", "123");
		List<User> list = userService.query(map);
		for (User user : list) {
			System.out.println(user.getLoginName());
			System.out.println(user.getLoginPwd());
			System.out.println(user.getUserId());
			System.out.println(user.getLoginTime());
			System.out.println(user.getE().getName());
			System.out.println(user.getE().getId());
		}
	/*	User user = userService.queryOne(3);
		System.out.println(user.getLoginName());
		System.out.println(user.getLoginPwd());
		System.out.println(user.getUserId());
		System.out.println(user.getE().getName());*/
	/*	User user = new User();
		user.setLoginName("tang");
		user.setLoginPwd("han");
		user.setUserId(4);
		Emp e = new Emp();
		e.setId(1);
		user.setE(e);
//		userService.save(user);
		userService.update(user);*/

		System.out.println("123456789");
		
		
		
		
		
		
		
	}
	
	

}
