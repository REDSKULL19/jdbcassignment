
package in.ineuron.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import in.ineuron.jdbc.Util.JdbcConncetion;

public class insertDateUsingPrepared {

	public static void main(String[] args) throws SQLException, ParseException  {
		
		// useful Resources
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name:: ");
		String name=sc.next();
		
		System.out.print("Enter the Address:: ");
		String add=sc.next();
		
		
		System.out.print("Enter the gender:: ");
		String gender=sc.next();
	// *****************************************************************	
		System.out.print("Enter the DOB::(dd-MM-yyyy) ");
		String sdob=sc.next();
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(sdob);
				
		long l=udate.getTime();
		java.sql.Date sdate=new java.sql.Date(l);
		//************************************************************************
		System.out.print("Enter the DOJ::(MM-dd-yyyy) ");
		String sdoj=sc.next();

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date utilDate=sdf1.parse(sdoj);
			
			Long time=utilDate.getTime();
			java.sql.Date sqldate = new java.sql.Date(time);
			//***************************************************************
		System.out.print("Enter the DOM::(yyyy-MM-dd) ");
		String sdom=sc.next();
		
		java.sql.Date date = java.sql.Date.valueOf(sdom);
	
		
//		
//	System.out.println();
//		System.out.println("String dob   is "+ sdob);
//		System.out.println("Util date is "+ udate);
//		System.out.println("Sql date is "+ sdate);
//		
//System.out.println();
//		System.out.println("String doj   is "+ sdoj);
//		System.out.println("Util date of doj is "+ utilDate);
//		System.out.println("Sql date of doj  is "+ sqldate);
//		
//		System.out.println();
//
//		
//		System.out.println("Sql date of dom is "+ sdom);
		String sqlinsertQuery="insert into userdata(`name`,`add`,`gender`,`DOB`,`DOJ`,`DOM`) values(?,?,?,?,?,?)";
		try {
			// step2
			connection=JdbcConncetion.getjdbcconnection();
			if(connection !=null) {
				preparedStatement=connection.prepareStatement(sqlinsertQuery);
				
				if(preparedStatement !=null) {
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, add);
					preparedStatement.setString(3, gender);
					preparedStatement.setDate(4, sdate);
					preparedStatement.setDate(5, sqldate);
					preparedStatement.setDate(6, date);
					
					int noofrows=preparedStatement.executeUpdate();
					
					System.out.println("Number of rows affected is: "+ noofrows);
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConncetion.closeconnection(null, preparedStatement, connection);
		
		if(sc !=null) {
			sc.close();
		}
	}
	

		
	}
}
	








