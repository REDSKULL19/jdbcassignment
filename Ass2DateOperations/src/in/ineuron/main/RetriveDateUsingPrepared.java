
package in.ineuron.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import in.ineuron.jdbc.Util.JdbcConncetion;

public class RetriveDateUsingPrepared {

	public static void main(String[] args) throws SQLException, ParseException  {
		
		// useful Resources
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name:: ");
		String name=sc.next();
		
		String sqlselectQuery="select name,addr,gender,DOB,DOJ,DOM from userdata where name = ?";
		
		try {
			// step2
			connection=JdbcConncetion.getjdbcconnection();
			
			if(connection !=null) {
				
			preparedStatement=connection.prepareStatement(sqlselectQuery);
				
				if(preparedStatement !=null) {
					
					preparedStatement.setString(1, name);			
					resultSet=preparedStatement.executeQuery();			
				}
				if(resultSet !=null) {
					if(resultSet.next()) {
						String sname=resultSet.getString(1);
						
						String add=resultSet.getString(2);
						
						String gender=resultSet.getString(3);
						
						java.sql.Date dob = resultSet.getDate(4);
						// formating the output as the user choice (based on locale)
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String dobdate = sdf.format(dob);
					
						
						java.sql.Date doj = resultSet.getDate(5);
						SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
						String dojdate =sdf1.format(doj);
						
						
						java.sql.Date dom = resultSet.getDate(6);
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
						String domdate =sdf2.format(dom);
						
					System.out.println("NAME IS :: "+ sname);
					System.out.println("add IS :: "+ add);
					System.out.println("gender IS :: "+ gender);
					System.out.println("DOB IS :: "+ dobdate);
					System.out.println("DOj IS :: "+ dojdate);
					System.out.println("DOM IS :: "+ domdate);
					}
					else {
						System.out.println("Record is not available for given name "+name);
					}
		
				}
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConncetion.closeconnection(resultSet, preparedStatement, connection);
		
		if(sc !=null) {
			sc.close();
		}
	}
	

		
	}
}
	








