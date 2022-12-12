package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Ass1 {

	public static void main(String[] args) throws SQLException {
		// Useful resources		
		Connection connection = null; 
		Statement statement = null;
		ResultSet resultSet = null;
		
		// Step2
		String url = "jdbc:mysql://localhost:3306/personal";
		String user = "root";
		String password = "Root@123";
		Scanner sc = new Scanner(System.in);
		try {
			 connection=DriverManager.getConnection(url, user, password);
			 
			if(connection !=null) {
				 // Step 3
			 statement = connection.createStatement();
			 
			 if(statement !=null) {
				 
				 System.out.println("Welcome to Our Website Plz Perform the operations that present at MENU Bar");
				 System.out.println("1. Create (Insert)\t2. Read(Select) \t3. Update \t4. Delete");
				 
				 int data = sc.nextInt();
				 
				switch(data) {
				case 1:
					// Inserting the data
					
					System.out.println("Enter the Student id");
					int sid = sc.nextInt();
					
					System.out.println("Enter the Student name");
					String sname = sc.next();
					
					System.out.println("Enter the Student age");
					int sage = sc.nextInt();
					
					System.out.println("Enter the Student address");
					String sadd = sc.next();
					
					String insertQuery = String.format("insert into student(`sid`,`sname`,`sage`,`sadd`) values(%d ,'%s',%d,'%s')", sid,sname,sage,sadd);
					int noofrows = statement.executeUpdate(insertQuery);
					System.out.println("Number of rows affected is "+noofrows );
					break;
				// **************************************************	
				case 2 :
					// Selecting the all data
					String Selectsql = "select sid ,sname,sage,sadd from student";
					resultSet = statement.executeQuery(Selectsql);
					if(resultSet != null) {
						// step 5
						System.out.println("SID\tSNAME\tSAGE\tSADD");
						System.out.println("****************************************");
					while(resultSet.next()) {
						int sid1 = resultSet.getInt("sid");
						String sname1 = resultSet.getString("sname");
						int sage1 = resultSet.getInt("sage");
						String sadd1 =resultSet.getString("sadd");	
						System.out.println(sid1 + "\t" +sname1 + "\t" +sage1+ "\t"+sadd1);		
						}
					}
					break;
				//*************************************************************
				case 3:
					// Updating the data
					System.out.println("Enter the name which you have to update");
					String sname2 = sc.next();
					 
					System.out.println("Enter the id where you have to make changes");
					int sid2 = sc.nextInt();
					String UpdateQuery = String.format("update student set sname='%s' where sid=%d", sname2,sid2) ;
					int noofrows2 = statement.executeUpdate(UpdateQuery);
					System.out.println("Number of rows Updated is "+noofrows2 );
					break;
				//*************************************************************
				case 4:
					// Deleting the data
					System.out.println("Enter the id which you have to delete");
					int id = sc.nextInt();
					String DeleteQuery = String.format("delete from student where sid=%d", id);
					int noofrows1 = statement.executeUpdate(DeleteQuery);
					System.out.println("Number of rows deleted is "+ noofrows1 );
					break;

				default : System.out.println("You enter Wrong Number Plz select coorect operation");
						
				}
			 }
		}
	} catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// Step 6
			if(resultSet !=null) {	
				resultSet.close();
			}
			if(statement !=null) {	
				statement.close();
			}
			if(connection !=null) {			
				connection.close();
			}
			if(sc !=null) {
				sc.close();
			}
		}
			
	}
}
