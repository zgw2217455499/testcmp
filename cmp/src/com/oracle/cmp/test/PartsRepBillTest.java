package com.oracle.cmp.test;

import java.util.Date;

import org.junit.Test;

import com.oracle.cmp.entity.Code;
import com.oracle.cmp.entity.Emp;
import com.oracle.cmp.entity.Parts;
import com.oracle.cmp.entity.PartsRepBill;
import com.oracle.cmp.service.PartsRepBillService;

public class PartsRepBillTest {
	@Test
	public void test() {
		PartsRepBillService service = new PartsRepBillService();
	/*	Map map = new HashMap();
		map.put("billTime", "2018-04-04");
		List<PartsRepBill> list = service.select(map);
		for (PartsRepBill partsRepBill : list) {
			System.out.println(partsRepBill.getBillCount());
			System.out.println(partsRepBill.getBillId());
			System.out.println(partsRepBill.getBillFlag().getName());
			System.out.println(partsRepBill.getBillType().getName());
			System.out.println(partsRepBill.getBillTime());
			System.out.println(partsRepBill.getBillUser().getName());
		}*/
		/*for (PartsRepBill partsRepBill : list) {
			System.out.println(partsRepBill.getBillCount());
			System.out.println(partsRepBill.getBillId());
			System.out.println(partsRepBill.getBillFlag().getCode());
			System.out.println(partsRepBill.getBillFlag().getName());
			System.out.println(partsRepBill.getBillFlag().getType());
			System.out.println(partsRepBill.getBillTime());
			System.out.println(partsRepBill.getBillUser().getName());			
			System.out.println(partsRepBill.getPartsId().getPartsName());					
		}*/
		/*PartsRepBill bill = new PartsRepBill();
		Code code = new Code();
		code.setCode("I");
		code.setType("in1");
		bill.setBillFlag(code);
		bill.setBillType(code);
		Parts parts = new Parts();
		parts.setPartsId(103);
		bill.setPartsId(parts);
		bill.setBillCount(30);
		bill.setBillTime(new Date());
		Emp emp = new Emp();
		emp.setId(1);
		bill.setBillUser(emp);
		
		service.insert(bill);*/
	}
}
