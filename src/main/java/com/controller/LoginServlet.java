package com.controller;

import java.io.IOException;

import com.model.Admin;

import comdao.AdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Admin admin=new Admin(username,password);
		AdminDAO adminDAO=new AdminDAO();
		boolean validlogin = adminDAO.validlogin(admin);
		
		if(validlogin) {
			resp.sendRedirect("employees");
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
			requestDispatcher.forward(req, resp);
		}
	}
	
	

}
