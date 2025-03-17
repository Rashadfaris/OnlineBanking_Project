package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.AdminDetails;

public class AdminListManager {
	private static List<AdminDetails> adminList = new ArrayList<>();
	
	public static void addAdmin(AdminDetails admin) {
		adminList.add(admin);
	}
	public static List<AdminDetails> getAdminList(){
		return adminList;
	}

}
