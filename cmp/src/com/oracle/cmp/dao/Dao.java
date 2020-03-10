package com.oracle.cmp.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Dao {
	private static Reader reader;
	private static SqlSessionFactory factory;
	static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
	static{
		try {
			reader = Resources.getResourceAsReader("configuration.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	public static SqlSession getSqlSession() {		
		return factory.openSession();
	}
}
