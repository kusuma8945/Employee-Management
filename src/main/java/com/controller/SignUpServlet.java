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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       String username = req.getParameter("username");
	       String email = req.getParameter("email");
	       String password = req.getParameter("password");
	       Admin admin=new Admin(username,email,password);
	       
	       AdminDAO adminDAO=new AdminDAO();
	       adminDAO.saveAdmin(admin);
	       
	       RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
	       requestDispatcher.forward(req, resp);
	}
	
	
	

	
	
	

}
