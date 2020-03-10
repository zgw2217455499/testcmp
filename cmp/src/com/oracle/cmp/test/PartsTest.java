package com.oracle.cmp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.oracle.cmp.common.Common;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.service.PartsService;

public class PartsTest {
	@Test
	public void test() {
		PartsService partsService = new PartsService();
		Map map = new HashMap();
		List<Parts> list = partsService.query(map);
		for (Parts parts : list) {
			System.out.println(parts.getPartsId());
			System.out.println(parts.getPartsName());
		}
	/*	List<Parts> list = partsService.query();
		for (Parts parts : list) {
			System.out.println(parts.getPartsName());
			System.out.println(parts.getPartsId());
			System.out.println(parts.getPartsLoc());
		}*/
		/*Map map = new HashMap();
		map.put("partsName", "节气门");
		Parts parts = partsService.selectByName(map);
		System.out.println(parts.getPartsId());
		System.out.println(parts.getPartsName());*/
		/*Parts parts = new Parts();
		parts.setPartsId(109);
		parts.setPartsLoc("44");
		parts.setPartsModel("22");
		parts.setPartsName("涨紧轮");
		parts.setPartsProDate(Common.getDate("2020-01-02"));
		parts.setPartsRemark("33")*/;
//		partsService.insert(parts);
//		partsService.update(parts);
//		partsService.delete(108);
	}
}
