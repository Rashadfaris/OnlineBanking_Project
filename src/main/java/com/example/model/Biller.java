package com.example.model;

public class Biller {
	private int  bid;
	private  String bname;
	private String breference;
	private  String bmobile;
	private String account;
	
	public Biller(int bid, String bname, String breference, String bmobile, String account) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.breference = breference;
		this.bmobile = bmobile;
		this.account = account;
	}
	public int getBid() {
		return bid;
	}
	public String getBname() {
		return bname;
	}
	public String getBreference() {
		return breference;
	}
	public String getBmobile() {
		return bmobile;
	}
	public String getAccount() {
		return account;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public void setBreference(String breference) {
		this.breference = breference;
	}
	public void setBmobile(String bmobile) {
		this.bmobile = bmobile;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}