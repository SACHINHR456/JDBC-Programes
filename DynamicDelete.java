package com.tyss.jdbc.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDelete {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		String query="delete from Employee where id=?";
		pstmt=conn.prepareStatement(query);
		//Binding the parameter
		pstmt.setInt(1,2);
		
		
		int count=pstmt.executeUpdate();
		System.out.println("delete successful");
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
