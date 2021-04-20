package com.tyss.jdbc.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticUpdate {
public static void main(String[] args) {
	Connection con=null;
	Statement stmt=null;

			try {
				// Load The Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
//				Driver driver = new com.mysql.jdbc.Driver();
//				DriverManager.registerDriver(driver);
				
				//2 get connection via driver
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
				
//				3.issue sql query via connectoin
     			String query="update Employee set name='vignesh' where id=1";
				
				stmt=con.createStatement();
				
//				4.process the result
				int count=stmt.executeUpdate(query);
				System.out.println("number of rows affected:"+count);
				
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
//				5.close all jdbc objects
				if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				if(stmt!=null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}

			 

}
}
