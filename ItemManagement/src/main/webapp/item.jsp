<%@page import="model.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%  //insert
     if (request.getParameter("itemCode") != null)
{
	 Item itemObj = new Item();
	 String stsMsg = itemObj.insertItem(request.getParameter("itemCode"),
			 request.getParameter("itemCategory"),
			 request.getParameter("itemName"),
			 request.getParameter("itemBrand"),
			 request.getParameter("itemDesc"),
	 		 request.getParameter("itemPrice"));
	 
	 System.out.println(stsMsg);
	 session.setAttribute("statusMsg", stsMsg);
} 


//delete
	if (request.getParameter("itemID") != null) {

	Item itemObj = new Item(); 
	String stsMsg = itemObj.deleteItem(request.getParameter("itemID")); 

	System.out.println(stsMsg);
	session.setAttribute("statusMsg", stsMsg); 
}
    
    
%>  
    
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="Views/bootstrap.min.css">


<meta charset="ISO-8859-1">
<title>Item Management</title>
</head>
<body>

<div class="jumbotron jumbotron-fluid">

<center><h1 style="font-size:380%;"><b>ITEM Management</b></h1></center>
<br>
<br>
<div class="container">
 <div class="row">
 	<div class="col">
 	
 	
<form method="post" action="item.jsp">
 	 Item Code: <input name="itemCode" type="text" class="form-control">
 	 Item Category: <input name="itemCategory" type="text" class="form-control">
	 Item Name: <input name="itemName" type="text" class="form-control"> 
	 Item Brand: <input name="itemBrand" type="text" class="form-control">
	 Item Description: <input name="itemDesc" type="text" class="form-control">
	 Item Price:<input name="itemPrice" type="text" class="form-control"><br><br>
<center><input name="btnSubmit" type="submit" value="Save Item" class="btn btn-primary"> </center>

<br>

</form>

<div class="alert alert-success">
 <% out.print(session.getAttribute("statusMsg"));%>
</div>



<%
 out.print(session.getAttribute("statusMsg")); 
%>
<br>

<%
 Item itemObj = new Item(); 
 out.print(itemObj.readItems()); 
%>

</div>
 </div>
</div>
        
</body>
</html>   
