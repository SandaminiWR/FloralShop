<%@page import="com.Customer"%>
<%@page import="com.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%

 
   //insert
 if (request.getParameter("name") != null)
{
 Customer customerObj = new Customer();
 String stsMsg = customerObj.insertCustomer(request.getParameter("name"),
		 request.getParameter("phone"),
		 request.getParameter("adress"),
		 request.getParameter("mail"),
		 request.getParameter("password"),
 		 request.getParameter("confirmpassword"));
 
 System.out.println(stsMsg);
 session.setAttribute("statusMsg", stsMsg);
} 
   
//delete
if (request.getParameter("id") != null) {
Customer customerObj = new Customer(); 
String stsMsg = customerObj.deleteCustomer(request.getParameter("id")); 
System.out.println(stsMsg);
session.setAttribute("statusMsg", stsMsg); 
}

 
 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Managemnet</title>
</head>
<body>
	
<h1>Customer Management</h1>
	<form method="post" action="customer.jsp">
		 ID: <input name="id" type="hidden"><br>
		 Name: <input name="name" type="text"><br>
		 Phone: <input name="phone" type="number"><br>
		 Address : <input name="address" type="text"><br>
		 Mail : <input name="mail" type="email"><br>
		 Password : <input name="password" type="password"><br>
		 Confirm Password : <input name="confirmpassword" type="password"><br>
		 <input name="btnSubmit" type="submit" value="Save">
 
	</form>
	
	<% out.print(session.getAttribute("statusMsg")); %>
	
<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Mail</th>
			<th>Password</th>
			<th>Update</th>
			<th>Remove</th>
	
		</tr>
	
		<tr>
			<td></td>
			<td><%out.print(session.getAttribute("name")); %></td>
			<td><%out.print(session.getAttribute("phone")); %></td>
			<td><%out.print(session.getAttribute("address")); %></td>
			<td><%out.print(session.getAttribute("mail")); %></td>
			<td><%out.print(session.getAttribute("password")); %></td>
			<td><%out.print(session.getAttribute("confirmpassword")); %></td>
		
			<td><input name="btnUpdate" type="button" value="Update"></td>
			<td><input name="btnRemove" type="button" value="Remove"></td>
		</tr>
		
		
	</table>
</body>
</html>