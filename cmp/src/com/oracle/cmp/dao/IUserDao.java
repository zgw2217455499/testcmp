package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.User;

public interface IUserDao {
	public User selectById(int id);
	public List<User> select(Map<String,Object> map);
	public void insert(User user);
	public void update(User user);
	public void delete(int id);
	public void deleteBatch(int[] ids);
}
