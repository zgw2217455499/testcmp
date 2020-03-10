package com.oracle.cmp.entity;

import java.util.Date;

public class PartsRepBill {
	private int billId;
	private Code billFlag;
	private Code billType;
	private Parts partsId;
	private int billCount;
	private Date billTime;
	private Emp billUser;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public Code getBillFlag() {
		return billFlag;
	}
	public void setBillFlag(Code billFlag) {
		this.billFlag = billFlag;
	}
	public Code getBillType() {
		return billType;
	}
	public void setBillType(Code billType) {
		this.billType = billType;
	}
	public Parts getPartsId() {
		return partsId;
	}
	public void setPartsId(Parts partsId) {
		this.partsId = partsId;
	}
	public int getBillCount() {
		return billCount;
	}
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}
	public Date getBillTime() {
		return billTime;
	}
	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}
	public Emp getBillUser() {
		return billUser;
	}
	public void setBillUser(Emp billUser) {
		this.billUser = billUser;
	}
	
}
