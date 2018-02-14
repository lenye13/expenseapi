package com.gmopa.expense.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.gmopa.expense.service.model.Expense;
import com.gmopa.expense.service.model.ExpenseList;

@Produces({ "application/json" })
public interface ExpenseService {
	
	@GET
	@Path("/expenses/")
	public abstract ExpenseList getAllExpenses();
	
	@GET
	@Path("/expenses/{id}/")
	public abstract Expense getExpenseById(@PathParam("id") String id);
	
	@POST
	@Path("/expenses/")
	public abstract Response addExpense(Expense expense);
	
	@DELETE
	@Path("/expenses/{id}/")
	public abstract Response deleteExpenseById(@PathParam("id") String id);
	
	@PUT
	@Path("/expenses/")
	public abstract Response updateExpense(Expense expense);
}
