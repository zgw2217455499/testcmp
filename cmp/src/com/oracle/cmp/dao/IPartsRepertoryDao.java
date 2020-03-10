package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.PartsRepertory;

public interface IPartsRepertoryDao {
	public List<PartsRepertory> select(Map map);
	public void update(PartsRepertory partsRepertory);
	public void insert(PartsRepertory partsRepertory);
}
