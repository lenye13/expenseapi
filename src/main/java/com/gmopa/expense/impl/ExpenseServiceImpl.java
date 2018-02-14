package com.gmopa.expense.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.gmopa.expense.service.ExpenseService;
import com.gmopa.expense.service.model.Expense;
import com.gmopa.expense.service.model.ExpenseList;

public class ExpenseServiceImpl implements ExpenseService {

	int currentID = 4;
	ExpenseList expenses = new ExpenseList();
	List<Expense> expenseList = new ArrayList<Expense>();

	public void init() {

		Expense exp1 = new Expense(1, "Electric", "Electric bill", 125.55,
				null, "Housing");
		Expense exp2 = new Expense(2, "Water", "Water bill", 60.00, null,
				"Housing");
		Expense exp3 = new Expense(3, "Heating", "Heat and hot water bill",
				175.55, null, "Housing");
		Expense exp4 = new Expense(4, "Internet", "Internet and other bill",
				61.25, null, "Housing");

		expenseList.add(exp1);
		expenseList.add(exp2);
		expenseList.add(exp3);
		expenseList.add(exp4);

		expenses.setExpenseList(expenseList);
	}

	public ExpenseServiceImpl() {
		init();
	}

	@Override
	public ExpenseList getAllExpenses() {
		// TODO Auto-generated method stub
		return expenses;
	}

	@Override
	public Expense getExpenseById(String id) {
		List<Expense> expenseList = new ArrayList<Expense>();
		expenseList = expenses.getExpenseList();

		for (Expense expense : expenseList) {
			if (expense.getID() == Integer.parseInt(id)) {
				return expense;
			}
		}
		return null;
	}

	@Override
	public Response addExpense(Expense expense) {
		expenseList.add(expense);
		expenses.setExpenseList(expenseList);

		return Response.ok(expense).build();
	}

	@Override
	public Response updateExpense(Expense expense) {

		if (expense != null) {
			for (Expense exp : expenseList) {
				if (exp.getID() == expense.getID()) {
					expenseList.set((exp.getID()-1), expense);
					return Response.ok().build();
				}
			}
		}
		return Response.notModified().build();
	}
	
	@Override
	public Response deleteExpenseById(String id) {
		List<Expense> expenseList = new ArrayList<Expense>();
		expenseList = expenses.getExpenseList();

		for (Expense expense : expenseList) {
			if (expense.getID() == Integer.parseInt(id)) {
				expenseList.remove(expense.getID()-1);
				return Response.ok().build();
			}
		}
		return Response.notModified().build();
	}

}
