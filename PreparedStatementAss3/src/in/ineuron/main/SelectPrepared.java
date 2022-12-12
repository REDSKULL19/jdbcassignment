
package in.ineuron.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.jdbc.Util.JdbcConncetion;

public class SelectPrepared {

	public static void main(String[] args) throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the student id ");
	int sid = sc.nextInt();
	
	String SelectQuery = "select sid,sname,sage,sadd from student where sid= ?";
	try {
		// step 2
		connection=JdbcConncetion.getjdbcconnection();
		if(connection !=null) {
			preparedStatement = connection.prepareStatement(SelectQuery);
			
			if(preparedStatement !=null) {
				
				preparedStatement.setInt(1, sid);				
				resultSet=preparedStatement.executeQuery();
			}
			if(resultSet !=null) {
				
				if(resultSet.next()) {
					System.out.println("sid\tsname\tsage\tsaddress");
					int sid1 = resultSet.getInt("sid");
					String sname1 = resultSet.getString("sname");
					int sage1 = resultSet.getInt("sage");
					String sadd1 =resultSet.getString("sadd");	
					System.out.println(sid1 + "\t"+sname1 + "\t" +sage1+ "\t"+sadd1);		
				}
				else {
					System.out.println("Data is not available for this id plz enter apropriate student id");
				}
			}
			
		}
	}catch(SQLException se) {
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JdbcConncetion.closeconnection(resultSet, preparedStatement, connection);
	}

	}

}
