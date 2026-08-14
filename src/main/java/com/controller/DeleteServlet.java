package com.controller;

import java.io.IOException;

import com.model.Employees;

import comdao.EmployeesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("employee_id"));
		
		EmployeesDAO employeesDTO=new EmployeesDAO();
		employeesDTO.deleteById(id);
		
		resp.sendRedirect("employees");
	}

}
