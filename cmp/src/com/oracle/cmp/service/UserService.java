package com.oracle.cmp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IUserDao;
import com.oracle.cmp.entity.User;

public class UserService {
	public List<User> query(Map<String,Object> map){
		IUserDao userDao = Dao.getSqlSession().getMapper(IUserDao.class);
		return userDao.select(map);
	}
	public User queryOne(int id){
		return Dao.getSqlSession().getMapper(IUserDao.class).selectById(id);
	}
	public void save(User user){
		SqlSession session = Dao.getSqlSession();
		session.getMapper(IUserDao.class).insert(user);
		session.commit();
	}
	public void update(User user){
		SqlSession session = Dao.getSqlSession();
		session.getMapper(IUserDao.class).update(user);
		session.commit();
	}
	public void delete(int id){
		SqlSession session = Dao.getSqlSession();
		session.getMapper(IUserDao.class).delete(id);
		session.commit();
	}
}
