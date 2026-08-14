package com.constant;

public class Constants {
	
	public static final String URL="jdbc:mysql://localhost:3306/employee_Management";
	public static final String DBUSERNAME="root";
	public static final String DBPASSWORD="Kusuma@1698";
	
	public static final String INSERT_ADMIN="insert into admins(username,email,password) values(?,?,?)";
	public static final String SELECT_Login="select * from admins where username=? and password=?";
	public static final String SELECT_Employees="select * from employees";
	public static final String INSERT_EMPLOYEES="insert into employees(employee_name,email,phone_number,salary) values(?,?,?,?)";
	public static final String DELETE_EMPLOYEE="update employees set isActive=? where employee_id=?";
	public static final String SELECT_BYID="select * from employees where employee_id=?";
	public static final String UPDATE_EMPLOYEE="update employees set employee_name=?,email=?,phone_number=?,salary=?,isActive=? where employee_id=?";
}
