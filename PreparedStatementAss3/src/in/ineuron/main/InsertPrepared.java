package in.ineuron.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import in.ineuron.jdbc.Util.JdbcConncetion;

public class InsertPrepared {

	public static void main(String[] args) throws SQLException  {
		
		// Useful resources
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Student id ");
		int sid = sc.nextInt();
		
		System.out.print("Enter the Student name ");
		String sname = sc.next();
		
		System.out.print("Enter the Student age ");
		int sage = sc.nextInt();
		
		System.out.print("Enter the Student address ");
		String sadd = sc.next();
	
		String InsertQuery = "insert into student(`sid`,`sname`,`sage`,`sadd`)values(?,?,?,?)";
		try {
			connection=JdbcConncetion.getjdbcconnection();
			
			if(connection !=null) {
				//Step3
				 preparedStatement = connection.prepareStatement(InsertQuery);	
				preparedStatement.setInt(1, sid);
				preparedStatement.setString(2, sname);		
				preparedStatement.setInt(3, sage);		
				preparedStatement.setString(4, sadd);
				if(preparedStatement !=null) {
					//step4
					int noofrows = preparedStatement.executeUpdate();
					System.out.println("Number of rows affected is "+ noofrows);
			}
		}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConncetion.closeconnection(null, preparedStatement, connection);
		
			// closing scanner object
			if(sc != null) {
				sc.close();
			}
		}
	}
				
		
}
		
