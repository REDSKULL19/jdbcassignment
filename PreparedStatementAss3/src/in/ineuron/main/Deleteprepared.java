package in.ineuron.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.jdbc.Util.JdbcConncetion;

public class Deleteprepared {

	public static void main(String[] args) throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the student id which you want to delete ");
	int sid = sc.nextInt();
	
	
	
	String DeleteQuery = "delete from student where sid = ?";
	try {
		// step 2
		connection=JdbcConncetion.getjdbcconnection();
		if(connection !=null) {
			preparedStatement = connection.prepareStatement(DeleteQuery);
			
			if(preparedStatement !=null) {
				
				preparedStatement.setInt(1, sid);
				
				int noofrows = preparedStatement.executeUpdate();
				System.out.println("number of rows affected is " +  noofrows);
				
			
			}
			
		}
	}catch(SQLException se) {
			
			se.printStackTrace();
				
	}catch(Exception e) {
			
		e.printStackTrace();
		
	}	finally {
			
		JdbcConncetion.closeconnection(null, preparedStatement, connection);
	}

	}

}
