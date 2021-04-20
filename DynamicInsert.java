package com.tyss.jdbc.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		String query="insert into Employee values(?,?,?,?,?)";
		pstmt=conn.prepareStatement(query);
		//Binding the parameter
		pstmt.setInt(1, 2);
		pstmt.setString(2,"baskar");
		pstmt.setInt(3,13500);
		pstmt.setString (4, "analyst");
		pstmt.setInt(5, 2937846);
		
		int count=pstmt.executeUpdate();
		System.out.println("insert successful");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		

	}

}
