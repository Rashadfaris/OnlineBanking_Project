package com.example.model;

public class Expense {
	private int id;
	private String eaccount;
	private String type;
	private String itemname;
	private double amount;
	public Expense(int id, String eaccount, String type, String itemname, double amount) {
		super();
		this.id = id;
		this.eaccount = eaccount;
		this.type = type;
		this.itemname = itemname;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public String getEaccount() {
		return eaccount;
	}
	public String getType() {
		return type;
	}
	public String getItemname() {
		return itemname;
	}
	public double getAmount() {
		return amount;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEaccount(String eaccount) {
		this.eaccount = eaccount;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}