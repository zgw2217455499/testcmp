package com.oracle.cmp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IUserDao;
import com.oracle.cmp.entity.User;

public class LoginService {
	public User login(String loginName,String loginPwd) {
		SqlSession sqlSession = Dao.getSqlSession();
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		Map map = new HashMap();
		map.put("loginName", loginName);
		map.put("loginPwd", loginPwd);
		List<User> list = userDao.select(map);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public void logout() {
		
	}
}
