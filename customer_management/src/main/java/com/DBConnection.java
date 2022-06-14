/**
 * 
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author USER
 *
 */
public class DBConnection {
	private static Connection con = null;
	//private static ResultSet rs = null;
	//private static PreparedStatement pst = null;
	//private static Statement stmt = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/gadgetbadget";
	private static final String user = "root";
	private static final String passwrd = "";	 
	
	static {		
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( url, user, passwrd);
			System.out.print("Successfully connected"); 
		} catch (ClassNotFoundException e) {
			System.err.println("Exception :" +e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception :" +e.getMessage());
		}		
	}
	
	public DBConnection() {}
	
	public static Connection getConnection(){
		return con;
	}
	
	
	
	/*public Connection connect()
	{ 
	 
		
		Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget","root", ""); 
	 //For testing
	 System.out.print("Successfully connected"); 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	}*/


}
