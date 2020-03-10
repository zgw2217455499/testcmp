package com.oracle.cmp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IPartsDao;
import com.oracle.cmp.entity.Parts;

public class PartsService {
	public List<Parts> query(Map map){
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);
		List<Parts> list = partsDao.select(map);
		session.close();
		return list;		
	}
	public Parts selectByName(Map map) {
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);		
		Parts parts = partsDao.selectByName(map);
		session.close();
		return parts;
		
	}
	public void insert(Parts parts) {
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);
		partsDao.insert(parts);
		session.commit();
		session.close();
	}
	public void delete(int id) {
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);
		partsDao.delete(id);
		session.commit();
		session.close();
	}
	public Parts selectById(int id) {
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);
		Parts parts = partsDao.selectById(id);
		session.commit();
		session.close();
		return parts;
	}
	public void update(Parts parts) {
		SqlSession session = Dao.getSqlSession();
		IPartsDao partsDao = session.getMapper(IPartsDao.class);
		partsDao.update(parts);
		session.commit();
		session.close();
	}
}
