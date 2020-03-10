package com.oracle.cmp.dao;

import java.util.List;

import com.oracle.cmp.entity.Emp;

public interface IEmpDao {
	public List<Emp> select();
	public List<Emp> selectNoRegist();
}
