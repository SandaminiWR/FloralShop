package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Delivery {
	//A common method to connect to the DB
	private Connection connect() 
	 { 
			Connection con = null; 
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
	 
				//Provide the correct details 
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PAF", "root", ""); 
			} 
			catch (Exception e) 
			{e.printStackTrace();} 
			return con; 
	 } 
	public String insertDelivery(String CID, String Dtype, String Ddesc) 
	 { 
	       String output = ""; 
	       try
	       { 
	    	   	Connection con = connect(); 
	    	   	if (con == null) 
	    	   	{return "Error while connecting to the database for inserting."; } 
	    	   	// create a prepared statement
	    	   	String query = " insert into delivery (`DID`,`CID`,`Dtype`,`Ddesc`)"+ " values (?, ?, ?, ?)"; 
	    	   
	    	   	PreparedStatement preparedStmt = con.prepareStatement(query); 
	    	   	// binding values
	    	   	preparedStmt.setInt(1, 0); 
	    	   	preparedStmt.setString(2, CID); 
	    	   	preparedStmt.setString(3, Dtype);
	    	   	preparedStmt.setString(4, Ddesc); 
	    	   	// execute the statement
	    	   	preparedStmt.execute(); 
	    	   	con.close(); 
	    	   	
	    	   	String newDelivery = readDelivery();
	    	   	output = "{\"status\":\"success\",\"data\":\""+
	    	   	newDelivery + "\"}"; 
	 } 
	 catch (Exception e) 
	       { 
		 		output = "{\"status\":\"error\",\"data\":\"Error while inserting the delivery. \"}";
		 		System.err.println(e.getMessage()); 
	       } 
	 return output; 
     } 
	public String readDelivery() 
	 { 
			String output = ""; 
			try
	 { 
					Connection con = connect(); 
					if (con == null) 
					{return "Error while connecting to the database for reading."; } 
					
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Delivery CustomerID</th>" +		
							"<th>Delivery Type</th>" +
							"<th>Delivery Description</th>" +
							"<th>Update</th><th>Remove</th></tr>"; 
	 
					String query = "select * from delivery"; 
					Statement stmt = con.createStatement(); 
					ResultSet rs = stmt.executeQuery(query); 
	 
					// iterate through the rows in the result set
					while (rs.next()) 
					{ 
						String DID = Integer.toString(rs.getInt("DID"));
						String CID = rs.getString("CID");
						String Dtype = rs.getString("Dtype"); 				  
						String Ddesc = rs.getString("Ddesc"); 
						// Add into the html table
						
						output += "<tr><td>" + CID + "</td>"; 
						output += "<td>" + Dtype + "</td>";
						output += "<td>" + Ddesc + "</td>"; 
						// buttons
						
						output += "<td><input name='btnUpdate' type='button' value='Update' "
								+ "class='btnUpdate btn btn-secondary' data-deliveryid='"+DID+"'></td>"
								+"<td> <input name='btnRemove' type='button' value='Remove'"
								+ " class='btnRemove btn btn-danger' data-deliveryid='"+DID+"'></td></tr>";
										
										
	 } 
	 
					con.close(); 
					// Complete the html table
					output += "</table>"; 
	 		} 
			catch (Exception e) 
			{ 
				output = "Error while reading the delivery."; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
	 } 
	public String updateDelivery(String DID,String CID, String Dtype ,String Ddesc)
	 { 
			String output = ""; 
			try
			{ 
					Connection con = connect(); 
					if (con == null) 
					{return "Error while connecting to the database for updating."; } 
					
					// create a prepared statement
					String query = "UPDATE delivery SET CID=?,Dtype=?,Ddesc=? WHERE DID=?"; 
					
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					// binding values
					preparedStmt.setString(1, CID);
					preparedStmt.setString(2, Dtype);
					preparedStmt.setString(3, Ddesc); 
					preparedStmt.setInt(4, Integer.parseInt(DID)); 
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
					  
			
			
			 	String newDelivery = readDelivery();
	    	   	output = "{\"status\":\"success\",\"data\":\""+
	    	   			newDelivery + "\"}"; 
	 } 
	 catch (Exception e) 
	       { 
		 		output = "{\"status\":\"error\",\"data\":\"Error while Updating the delivery. \"}";
		 		System.err.println(e.getMessage()); 
	       } 
			
			return output; 
	 } 
	public String deleteDelivery(String DID) 
	 { 
		String output = ""; 
		try
		{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for deleting."; } 
				// create a prepared statement
				String query = "delete from delivery where DID=?"; 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(DID)); 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
				
			 	String newDelivery = readDelivery();
	    	   	output = "{\"status\":\"success\",\"data\":\""+
	    	   	newDelivery + "\"}"; 
	 } 
	 catch (Exception e) 
	       { 
		 		output = "{\"status\":\"error\",\"data\":\"Error while deleting the delivery. \"}";
		 		System.err.println(e.getMessage()); 
	       } 
	 return output; 
	 } 

}
