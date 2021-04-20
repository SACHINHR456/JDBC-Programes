package com.tyss.jdbc.pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.crypto.NullCipher;

public class DynamicRetriveWith2console {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
	String ref;
	try {
		FileInputStream fr= new FileInputStream("D:\\h.properties");
	       Properties prop= new Properties();
	       prop.load(fr);
		Class.forName("com.mysql.cj.jdbc.Driver");
	
//		Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);

			// 2 get connection via driver
//			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems", "root", "root");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems",prop);

//		3.Issue sql query via connection
			String query = "select * from Employee where id=?";

			pstmt = conn.prepareStatement(query);
//		reading the parameter input through command line arguments
			String eid = args[0];
			int employeeId = Integer.parseInt(eid);
//		binding the parameter for employeeId
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();

//		4.process the results returned by sql query
			if (rs.next()) {
				int empid = rs.getInt("id");
				String empname = rs.getString("name");
				int empsal = rs.getInt("sal");
				String department = rs.getString("dept");
				int phoneno = rs.getInt("ph_no");

				// print all the values
				System.out.println("employee id=" + empid);
				System.out.println("empname=" + empname);
				System.out.println("empsal=" + empsal);
				System.out.println("empdept=" + department);
				System.out.println("empPhone=" + phoneno);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			if (rs != null) {
//				try {
//					rs.clearWarnings();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		
	}
}





