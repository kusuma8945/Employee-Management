package comdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Utils.DBConnection;
import com.constant.Constants;
import com.model.Admin;

public class AdminDAO {
	
	
	public void saveAdmin(Admin admin) {
		
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.INSERT_ADMIN);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getEmail());
			statement.setString(3, admin.getPassword());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean validlogin(Admin admin) {
		Connection connection=null;
		try {
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.SELECT_Login);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getPassword());
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
