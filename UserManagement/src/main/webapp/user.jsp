
<%@page import="model.User"%>
<%@page import="model.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     
 <%
  
if (request.getParameter("name") != null) 
	{ 

	 session.setAttribute("name", request.getParameter("name")); 
	 session.setAttribute("phone", request.getParameter("phone")); 
	 session.setAttribute("address", request.getParameter("address"));
	 session.setAttribute("mail", request.getParameter("mail")); 
	 session.setAttribute("password", request.getParameter("password")); 
	 session.setAttribute("confirmpassword", request.getParameter("confirmpassword"));
 
			 User user = new User(); 
				 String stsMsg = user.insertUser(request.getParameter("name"), 
				 					request.getParameter("phone"), 
					 				request.getParameter("address"), 
				 					request.getParameter("mail"), 
				 					request.getParameter("password"), 
					 				request.getParameter("confirmpassword")); 
 
 			session.setAttribute("statusMsg", stsMsg); 
 
	} 


    
 if (request.getParameter("uid") != null) 
    { 
    
    User usr = new User(); 
    String stsMsg = usr.deleteUser(request.getParameter("uid")); 
    session.setAttribute("statusMsg", stsMsg); 
    } 
  

%>

<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>User Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

</head>
<body>

<div class="container"> 
 <div class="row">
 <div class="col-8"> 	
	
<h1 class="m-3">Flora FlowerSupplier Management</h1>
	<form method="post" action="user.jsp" id="formStudent">
	
					 <!-- ID -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">ID: </span>
			</div> 
			<input name="id" type="hidden" id="txtName">
			</div><br>
					 <!-- name -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Name: </span>
			</div> 
			<input name="name" type="text" id="txtName">
			</div><br>
						 <!-- phone -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Phone: </span>
			</div> 
			<input name="phone" type="tel" id="txtName">
			</div><br>
						 <!-- address -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Address: </span>
			</div> 
			<input name="address" type="text" id="txtName">
			</div><br>
						 <!-- mail -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Mail: </span>
			</div> 
			<input name="mail" type="email" id="txtName">
			</div><br>
						<!-- pass -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Password: </span>
			</div> 
            <input name="password" type="password" id="txtName">	
            </div><br>
						<!-- c pass -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName"> Confirm Password: </span>
			</div> 
			<input name="confirmpassword" type="password" id="txtName">
			</div><br>
			
		
			
		<input name="btnSubmit" type="submit" value="Save" id="btnSave" class="btn btn-primary">
 
	</form>
	
	</div>
 </div>
 
 <br>
 
 <div class="row">
 <div class="col-12" id="colStudents">
 
 </div>
 </div>
</div>
 
	 
	 <body>
 
    <%
        if ("Insert Successfull".equals(session.getAttribute("statusMsg"))) {
    %>
        <div class="alert alert-success" id="alertSuccess">
        <% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        } 
        else {
    %>
        <div id="alertError" class="alert alert-danger">
		<% out.print(session.getAttribute("statusMsg")); %>	</div>
    <%
        }
    %>
 
</body>
	 
	<br>
	<%
		 User userObj = new User(); 
		 out.print(userObj.readUser()); 
	%>

<br>
	<!--  <table border="1">
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
			<td><%out.print(session.getAttribute("id")); %></td>
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
	
-->	

</body>
</html>