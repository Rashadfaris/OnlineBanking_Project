package com.example.model;

public class UserDetails {
	private String acoount;
	private String name;
	private String email;
	private String username;
	private String password;
	private String confirmPassword;
	private String mobile;
	
	public UserDetails(String acoount, String name, String email, String username, String password,
			String confirmPassword, String mobile) {
		super();
		this.acoount = acoount;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobile = mobile;
	}
	public String getAcoount() {
		return acoount;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getMobile() {
		return mobile;
	}

 

}

