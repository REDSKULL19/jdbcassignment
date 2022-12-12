package in.ineuron.jdbc.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class JdbcConncetion {
	
	private JdbcConncetion() {
		
	}
	public static Connection getjdbcconnection() throws SQLException {
		
		// Step 2
		Connection connection = null;	
		String url="jdbc:mysql://localhost:3306/personal";
		String user="root";
		String password="Root@123";
		connection = DriverManager.getConnection(url, user, password);
			
			if(connection !=null ) 
				return connection;
				
		return connection;
	}
	
	public static void closeconnection(ResultSet resultset, Statement statement ,Connection connection ) throws SQLException{
		// Closing the used resources
		
			if(resultset !=null) {
				resultset.close();
			}
			if(statement !=null) {	
				statement.close();
			}
			if(connection !=null) {			
				connection.close();			
		}
}
	
}