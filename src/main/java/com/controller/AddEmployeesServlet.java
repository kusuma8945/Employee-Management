package com.controller;

import java.io.IOException;

import com.model.Employees;

import comdao.EmployeesDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployees")
public class AddEmployeesServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String employee_name= req.getParameter("employee_name");
		String email = req.getParameter("email");
		String phone_number = req.getParameter("phone_number");
		double salary = Double.parseDouble(req.getParameter("salary"));
		Employees emp=new Employees(employee_name,email,phone_number,salary);
		EmployeesDAO employeesDAO=new EmployeesDAO();
		employeesDAO.saveEmployees(emp);
		
		resp.sendRedirect("employees");
	}
	
	
	
	

}
