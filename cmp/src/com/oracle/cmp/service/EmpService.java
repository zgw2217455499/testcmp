package com.oracle.cmp.service;

import java.util.List;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IEmpDao;
import com.oracle.cmp.entity.Emp;

public class EmpService {
	public List<Emp> queryNoRegist(){
		return Dao.getSqlSession().getMapper(IEmpDao.class).selectNoRegist();
	}
}
