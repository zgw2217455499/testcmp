package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.Parts;

public interface IPartsDao {
	public List<Parts> select(Map map);
	public Parts selectById(int id);
	public Parts selectByName(Map map);
	public void insert(Parts parts);
	public void update(Parts parts);
	public void delete(int id);
}
