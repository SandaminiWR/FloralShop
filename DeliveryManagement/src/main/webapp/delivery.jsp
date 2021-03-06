<%@page import="model.Delivery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delivery Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/delivery.js"></script>
</head>
<body> 
	<div class="container"><div class="row"><div class="col-6"> 
	<h1>Delivery Management</h1>
		<form id="formDelivery" name="formDelivery">
		
			  Customer ID: 
			 <input id="CID" name="CID" type="text" 
			 class="form-control form-control-sm">
			 <br> Type: 
			 <input id="Dtype" name="Dtype" type="text" 
			 class="form-control form-control-sm">
			 <br> Description: 
			 <input id="Ddesc" name="Ddesc" type="text" 
			 class="form-control form-control-sm">
			 <br>
			 <input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			 <input type="hidden" id="hidDeliveryIDSave" 
			 name="hidDeliveryIDSave" value="">
		</form>
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		<div id="diveliveryGrid">
	 <%
		 Delivery dilObj = new Delivery(); 
		 out.print(dilObj.readDelivery()); 
	 %>
	</div>
	</div> </div> </div> 
</body>
</html>