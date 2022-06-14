
<%@page import="model.User"%>
<%@page import="model.DBConnection"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
         <%
  
if (request.getParameter("id") != null) 
	{ 

	 session.setAttribute("id", request.getParameter("id"));
	 session.setAttribute("password", request.getParameter("password")); 
 
	 User us = new User(); 
				 String stsMsg = us.userlogin(request.getParameter("id"), 
				 					request.getParameter("password"));
				 
 			session.setAttribute("statusMsg", stsMsg); 
 
	} 
    


%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>
	 <body>
  <div class="row">
 <div class="col-12" id="colStudents">
 
 </div>
 </div>
    <%
        if ("Login Successfull".equals(session.getAttribute("statusMsg"))) {
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
</html>