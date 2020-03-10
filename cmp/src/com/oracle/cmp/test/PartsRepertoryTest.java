package com.oracle.cmp.test;

import org.junit.Test;

import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.entity.PartsRepertory;
import com.oracle.cmp.service.PartsRepertoryService;

public class PartsRepertoryTest {
	@Test
	public void test() {
		PartsRepertoryService service = new PartsRepertoryService();
		/*Map map = new HashMap();
		map.put("partsId", 103);
		List<PartsRepertory> list = service.select(map);
		for (PartsRepertory partsRepertory : list) {
			System.out.println(partsRepertory.getPartsRepCount());
			System.out.println(partsRepertory.getPartsRepId());
			System.out.println(partsRepertory.getPartsId().getPartsId());
			System.out.println(partsRepertory.getPartsId().getPartsName());
		}*/
		Parts parts = new Parts();
		parts.setPartsId(103);
		PartsRepertory partsRepertory = new PartsRepertory();
		partsRepertory.setPartsId(parts);
		partsRepertory.setPartsRepCount(500);
		service.insert(partsRepertory);
	}
}
