package com.oracle.cmp.dao;

import java.util.List;
import java.util.Map;

import com.oracle.cmp.entity.Code;

public interface ICodeDao {
	public List<Code> select(Map map);

}
