package com.oracle.cmp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.oracle.cmp.entity.Code;
import com.oracle.cmp.service.CodeService;

public class CodeTest {
	@Test
	public void test() {
		CodeService service = new CodeService();
		Map map  = new HashMap();
		map.put("type", "in");
		List<Code> list = service.select(map);
		for (Code code : list) {
			System.out.println(code.getCode());
			System.out.println(code.getName());
			System.out.println(code.getType());
		}
	}
}
