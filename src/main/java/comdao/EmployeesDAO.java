package comdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Utils.DBConnection;
import com.constant.Constants;
import com.model.Employees;

public class EmployeesDAO {
	
	public List<Employees> getAllEmployees(){
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Employees> empList=new ArrayList<Employees>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.SELECT_Employees);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String employee_name = rs.getString(2);
				String email= rs.getString(3);
				String phone_number = rs.getString(4);
				double salary = rs.getDouble(5);
				boolean isActive = rs.getBoolean(6);
				Employees emp=new Employees(employee_id,employee_name,email,phone_number,salary,isActive);
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	
	public void saveEmployees(Employees employee) {
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.INSERT_EMPLOYEES);
			statement.setString(1, employee.getEmployee_name());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getPhone_number());
			statement.setDouble(4, employee.getSalary());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteById(int id) {
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE);
			statement.setBoolean(1, false);
			statement.setInt(2,id);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public Employees UpdateById(int id) {
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employees emp=null;
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.SELECT_BYID);
			statement.setInt(1,id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String employee_name = rs.getString(2);
				String email= rs.getString(3);
				String phone_number = rs.getString(4);
				double salary = rs.getDouble(5);
				boolean isActive = rs.getBoolean(6);
				emp=new Employees(employee_id,employee_name,email,phone_number,salary,isActive);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	public void updateEmployee(Employees emp) {
		
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);
			statement.setString(1,emp.getEmployee_name());
			statement.setString(2,emp.getEmail());
			statement.setString(3,emp.getPhone_number());
			statement.setDouble(4,emp.getSalary());
			statement.setBoolean(5,emp.isActive());
			statement.setInt(6, emp.getEmployee_id());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
