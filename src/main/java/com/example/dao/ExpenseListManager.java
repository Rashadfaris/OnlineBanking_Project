package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Expense;

public class ExpenseListManager {
	private static List<Expense> expenseList = new ArrayList<>();

	public static void addUser(Expense expense) {
		expenseList.add(expense);
	}

	public static List<Expense> getExpenseList() {
	    return expenseList;
	}

}





