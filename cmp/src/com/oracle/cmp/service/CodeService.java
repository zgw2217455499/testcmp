package com.oracle.cmp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oracle.cmp.dao.Dao;
import com.oracle.cmp.dao.ICodeDao;
import com.oracle.cmp.entity.Code;

public class CodeService {
	public List<Code> select(Map map){
		SqlSession session = Dao.getSqlSession();
		ICodeDao dao = session.getMapper(ICodeDao.class);
		List<Code> list = dao.select(map);
		session.commit();
		session.close();
		return list;
		
	}
}
