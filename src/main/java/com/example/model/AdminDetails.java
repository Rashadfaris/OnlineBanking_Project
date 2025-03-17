package com.example.model;

public class AdminDetails {
	private String adminid;
	private String adminname;
	private String adminusername;
	private String adminpassword;
	
	
	public AdminDetails(String adminid, String adminname, String adminusername, String adminpassword) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminusername = adminusername;
		this.adminpassword = adminpassword;
	}
	
	public String getAdminid() {
		return adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public String getAdminusername() {
		return adminusername;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	

}
