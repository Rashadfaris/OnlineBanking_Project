package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Transfer;

public class TransferListManager {
	   private static List<Transfer> transferList = new ArrayList<>();

	    public static void addUser(Transfer transfer) {
	    	transferList.add(transfer);
	    }

	    public static List<Transfer> getTransferList() {
	        return transferList;
	    }
	}





 
