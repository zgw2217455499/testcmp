package com.oracle.cmp.dao;

import com.oracle.cmp.entity.User;

public interface ILoginDao {
	public User login(String loginName,String loginPwd);
	public void logout();
}
