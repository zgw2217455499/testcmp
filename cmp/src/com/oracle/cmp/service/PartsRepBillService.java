package com.oracle.cmp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.ICodeDao;
import com.oracle.cmp.dao.IPartsRepBillDao;
import com.oracle.cmp.entity.Code;
import com.oracle.cmp.entity.PartsRepBill;

public class PartsRepBillService {
	public List<PartsRepBill> select(Map map){
		SqlSession session = Dao.getSqlSession();
		IPartsRepBillDao dao = session.getMapper(IPartsRepBillDao.class);
		List<PartsRepBill> list = dao.select(map);
		session.commit();
		session.close();
		return list;
		
	}
	public PartsRepBill selectByBillType(Map map){
		SqlSession session = Dao.getSqlSession();
		IPartsRepBillDao dao = session.getMapper(IPartsRepBillDao.class);
		PartsRepBill parts = dao.selectByBillType(map);
		session.commit();
		session.close();
		return parts;
		
	}
	public void insert(PartsRepBill bill) {
		SqlSession session = Dao.getSqlSession();
		IPartsRepBillDao partsRepDao = session.getMapper(IPartsRepBillDao.class);
		partsRepDao.insert(bill);
		session.commit();
		session.close();		
	}
}
