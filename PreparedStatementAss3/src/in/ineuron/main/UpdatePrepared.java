package in.ineuron.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.jdbc.Util.JdbcConncetion;

public class UpdatePrepared {

	public static void main(String[] args) throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the student id where you have to change name ");
	int sid = sc.nextInt();
	
	System.out.print("Enter the student name ");
	String sname = sc.next();
	
	
	String UpdateQuery = "update student set sname = ?  where sid= ?";
	try {
		// step 2
		connection=JdbcConncetion.getjdbcconnection();
		if(connection !=null) {
			preparedStatement = connection.prepareStatement(UpdateQuery);
			
			if(preparedStatement !=null) {
				
				preparedStatement.setString(1, sname);	
				preparedStatement.setInt(2, sid);
				
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
