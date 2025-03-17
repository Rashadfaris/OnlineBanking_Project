package com.example.model;

public class Transfer {
	private int tid;
	private String account;
	private String recAccountNo;
	private String recAccountName;
	private String purpose;
	private double amount;
	
	
	public Transfer(int tid, String account, String recAccountNo, String recAccountName, String purpose,
			double amount) {
		super();
		this.tid = tid;
		this.account = account;
		this.recAccountNo = recAccountNo;
		this.recAccountName = recAccountName;
		this.purpose = purpose;
		this.amount = amount;
		
	}
	public int getTid() {
		return tid;
	}
	public String getAccount() {
		return account;
	}
	public String getRecAccountNo() {
		return recAccountNo;
	}
	public String getRecAccountName() {
		return recAccountName;
	}
	public String getPurpose() {
		return purpose;
	}
	public double getAmount() {
		return amount;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setRecAccountNo(String recAccountNo) {
		this.recAccountNo = recAccountNo;
	}
	public void setRecAccountName(String recAccountName) {
		this.recAccountName = recAccountName;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	
}