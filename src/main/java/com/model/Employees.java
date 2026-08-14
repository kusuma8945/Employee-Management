package com.model;

public class Employees {
	
	private int employee_id;
	
	private String employee_name;
	
	private String email;
	private String phone_number;
	private double salary;
	private boolean isActive;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Employees(int employee_id, String employee_name, String email, String phone_number, double salary,
			boolean isActive) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
		this.isActive = isActive;
	}
	public Employees() {
		super();
	}
	public Employees(String employee_name, String email, String phone_number, double salary) {
		super();
		this.employee_name = employee_name;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
	}
	public Employees(String employee_name, String email, String phone_number, double salary, boolean isActive) {
		super();
		this.employee_name = employee_name;
		this.email = email;
		this.phone_number = phone_number;
		this.salary = salary;
		this.isActive = isActive;
	}
	public Employees(int employee_id) {
		super();
		this.employee_id = employee_id;
	}
	
	

}
