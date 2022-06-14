/**
 * 
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author USER
 *
 */
public class Customer {

	 
	public Connection connect()
	{ 
		Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/item_management", "root", ""); 
	 
	 //For testing
	 System.out.print("Successfully Connected"); 
	 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	
	}
	
	//insertCustomer	
		public String insertCustomer( String name, String phone, String address,String mail,String password,String confirmpassword ) 
		{
			
			Connection con = DBConnection.getConnection();
			
			String output = "";
			
			if (con == null) 
			{ 
				return "Error while connecting to the database"; 
			}
			
			// create a prepared statement
			String query = " insert into Customer ('id', 'name',`phone`,`address`,`mail`,`password`)"
			 + " values (?, ?, ?, ?, ?, ?,?)"; 
			
			try {
				
				if( password.equals(confirmpassword)) {
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					// binding values
					preparedStmt.setInt(1, 0); 
					preparedStmt.setString(2, name); 
					preparedStmt.setString(3, phone); 
					preparedStmt.setString(4, address); 
					preparedStmt.setString(5, mail);
					preparedStmt.setString(5, password);
					preparedStmt.setString(6, confirmpassword);
					
					//execute the statement
					 preparedStmt.execute();
					 
					 con.close(); 
					 output = "Customer Inserted successfully"; 
					
				}else {
					
					output="password not matched\n";
				}
				 
				 
				 
				 }catch (Exception e) { 
					 output = "Error while Inserting"; 
					 System.err.println(e.getMessage()); 
			      } 
			
			return output; 
			
		}

		public String readCustomer()
		{ 
			
			String output = ""; 
			try
			{ 
				Connection con = DBConnection.getConnection();
				
				
				if (con == null) 
				{ 
					return "Error while connecting to the database for reading."; 
				} 
				
				// Prepare the html table to be displayed
				output = "<table border='1'>" 
				+ "<tr><th>Name</th><th>Phone</th><th>Mail</th>"
				+ "<th>Password</th><th>Update</th><th>Remove</th></tr>";
				
				 String query = "select * from customer"; 
				 Statement stmt = con.createStatement(); 
				 ResultSet rs = stmt.executeQuery(query); 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
				 String id = Integer.toString(rs.getInt("id")); 
				 String name = rs.getString("name"); 
				 String phone = rs.getString("phone"); 
				 String address = rs.getString("address");
				 String mail = rs.getString("mail"); 
				 // Add into the html table
				 output += "<tr><td>" + name + "</td>"; 
				 output += "<td>" + phone + "</td>"; 
				 output += "<td>" + address + "</td>"; 
				 output += "<td>" + mail + "</td>";
				 // buttons
				 output += "<td><input name=‘btnUpdate’ " 
				 + " type=‘button’ value=‘Update’></td>"
				 + "<td><form method=‘post’ action=‘items.jsp’>"
				 + "<input name=‘btnRemove’ " 
				 + " type=‘submit’ value=‘Remove’>"
				 + "<input name=‘itemID’ type=‘hidden’ " 
				 + " value=‘" + id + "‘>" + "</form></td></tr>"; 
				 
				// Buttons
					output += "<td>" + "<form method='post' action='customer.jsp'>"
							+ "<input name='btnUpdate' type='submit' value='Update' class='btn btn-info' >" 
							+ "<input name='update_id' type='hidden' value='" + id + "'>" + "</form>" + "<td>"
							+ "<form method='post' action='item.jsp'>"
							+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							+ "<input name='id' type='hidden' value='" + id + "'>" + "</form></td></tr>";
				
				 } 
				 con.close(); 
				 // Complete the html table
				 output += "</table>"; 
				 
			} 
			catch (Exception e) 
			{ 
				output = "Error while reading the items."; 
				 System.err.println(e.getMessage()); 
			}
		 
		 
				return output;
		}
	
		//update Customer
		public String updateCustomer(String ID, String name, String phone, String address, String mail, String password, String confirmpassword)
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 
		 // create a prepared statement
		 String query = "UPDATE customer SET name=?,phone=?,address=?,mail=?,password=? WHERE id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 // binding values
		 
		 preparedStmt.setString(1, name); 
		 preparedStmt.setString(2, phone); 
		 preparedStmt.setString(3, address); 
		 preparedStmt.setString(4, mail); 
		 preparedStmt.setString(5, password);  
		 preparedStmt.setString(6, confirmpassword);
		 preparedStmt.setInt(7, Integer.parseInt(ID));
		 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated Successfully"; 
		 } 
		 catch (Exception e) {
		 		 
		 output = "Error while updating the item."; 
		 System.err.println(e.getMessage()); 
		 
		 } 
		 
		 return output; 
	 } 
		
//deleteCustomer
		public String deleteCustomer(String customerData) {
			// TODO Auto-generated method stub
			 String output = ""; 
				try
				 { 
				 Connection con = connect(); 
				 if (con == null) 
				 { 
				 return "Error while connecting to the database for deleting."; 
				 } 
				 
				 // create a prepared statement
				 String query = "delete from Customer where id=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(customerData)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Deleted Successfully"; 	 
				 } 
				
				catch (Exception e) {
				 	
				 output = "Error while deleting the Customer."; 
				 System.err.println(e.getMessage()); 
				 
				 } 
				
				return output;
		}
				
}
