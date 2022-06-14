<%@page import="model.User"%>
<%@page import="model.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!--    <%
  
if (request.getParameter("id") != null) 
	{ 

	 session.setAttribute("id", request.getParameter("i"));
	 session.setAttribute("password", request.getParameter("password")); 
 
	 User us = new User(); 
				 String stsMsg = us.userlogin(request.getParameter("id"), 
				 					request.getParameter("password"));
				 
 			session.setAttribute("statusMsg", stsMsg); 
 
	} 
    


%>
  -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

</head>
<body>

<div class="container"> 
 <div class="row">
 <div class="col-8"> 	
	
<h1 class="m-3">Flora Flower Supplier Login</h1>
<form method="post" action="Index.jsp" id="formStudent">
	
					 <!-- ID -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">ID: </span>
			</div> 
			<input name="id" type="text" id="txtName">
			</div><br>
					 <!-- password -->
			<div class="input-group input-group-sm mb-3">
			<div class="input-group-prepend">
			 <span class="input-group-text" id="lblName">Password: </span>
			</div> 
			<input name="password" type="password" id="txtName">
			</div><br>
			

<input name="btnSubmit" type="submit" value="Submit" id="btnSave" class="btn btn-primary">
</form>
 </div>
 </div>
</div>
</body>
</html> 