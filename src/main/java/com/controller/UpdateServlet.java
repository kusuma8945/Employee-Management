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


@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("employee_id"));
		EmployeesDAO employeesDTO =new EmployeesDAO ();
		Employees emp = employeesDTO.UpdateById(id);
		
		req.setAttribute("emp", emp);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("employee_id"));
		String employee_name= req.getParameter("employee_name");
		String email = req.getParameter("email");
		String phone_number = req.getParameter("phone_number");
		double salary = Double.parseDouble(req.getParameter("salary"));
		boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
		
		Employees emps=new Employees(id,employee_name,email,phone_number,salary,isActive);
		
		EmployeesDAO employeesDAO=new EmployeesDAO();
		 employeesDAO.updateEmployee(emps);
		 
		 resp.sendRedirect("employees");
	}
	

}
