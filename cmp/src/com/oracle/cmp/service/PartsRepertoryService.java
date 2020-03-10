package com.oracle.cmp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.IPartsRepBillDao;
import com.oracle.cmp.dao.IPartsRepertoryDao;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.entity.PartsRepBill;
import com.oracle.cmp.entity.PartsRepertory;

public class PartsRepertoryService {

	public List<PartsRepertory> select(Map map){
		SqlSession session = Dao.getSqlSession();
		IPartsRepertoryDao dao = session.getMapper(IPartsRepertoryDao.class);
		List<PartsRepertory> list = dao.select(map);		
		return list;
	}
	public void update(PartsRepertory partsRepertory) {
		SqlSession session = Dao.getSqlSession();
		IPartsRepertoryDao dao = session.getMapper(IPartsRepertoryDao.class);
		dao.update(partsRepertory);
		session.commit();
		session.close();
	}
	public void insert(PartsRepertory partsRepertory) {
		SqlSession session = Dao.getSqlSession();
		IPartsRepertoryDao dao = session.getMapper(IPartsRepertoryDao.class);
		dao.insert(partsRepertory);
		session.commit();
		session.close();
	}
	//AJAX 判断出库数量是否大于库存数量
	public boolean hasCount(int partsId,int partsRepCount) {
		SqlSession session = Dao.getSqlSession();
		IPartsRepertoryDao dao = session.getMapper(IPartsRepertoryDao.class);
		Map map = new HashMap();
		map.put("partsId", partsId);
		List<PartsRepertory> list = dao.select(map);	
		if(partsRepCount <= list.get(0).getPartsRepCount()) { 
			return true;
		}
		return false;
	}
	//对配件出入库做数量的更新操作
	public void repertory(PartsRepBill bill) {
		SqlSession session = Dao.getSqlSession();
		IPartsRepertoryDao dao = session.getMapper(IPartsRepertoryDao.class);
		IPartsRepBillDao partsRepBillDao = session.getMapper(IPartsRepBillDao.class);
		PartsRepertoryService service = new PartsRepertoryService();
		Map map = new HashMap();
		map.put("partsId",bill.getPartsId().getPartsId());
		List<PartsRepertory> list = dao.select(map);
		if(list==null) {
			PartsRepertory partsRepertory = new PartsRepertory();
			Parts parts = new Parts();
			parts.setPartsId(bill.getPartsId().getPartsId());
			partsRepertory.setPartsId(parts);
			partsRepertory.setPartsRepCount(bill.getBillCount());
			dao.insert(partsRepertory);
		}
		if("O".equals(bill.getBillFlag().getCode())) {			
			//得到数据库中PartsRepCount的数据
			 int count = list.get(0).getPartsRepCount()-bill.getBillCount(); 
			 list.get(0).setPartsRepCount(count);
			 service.update(list.get(0));
		}
		if("I".equals(bill.getBillFlag().getCode())) {			
			//得到数据库中PartsRepCount的数据
			int count = list.get(0).getPartsRepCount()+bill.getBillCount(); 
			list.get(0).setPartsRepCount(count);
			service.update(list.get(0));
		}
		partsRepBillDao.insert(bill);
		session.commit();
		session.close();
	}
}
