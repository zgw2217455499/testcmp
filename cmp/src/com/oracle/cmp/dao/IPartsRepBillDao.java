package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.PartsRepBill;

public interface IPartsRepBillDao {
	public List<PartsRepBill> select(Map map);
	public PartsRepBill selectByBillType(Map map);
	public void insert(PartsRepBill bill);
}
