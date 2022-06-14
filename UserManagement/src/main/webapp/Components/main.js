

$(document).ready(function()
{ 
 $("#alertSuccess").hide(); 
 $("#alertError").hide(); 
 }); 

// SAVE ============================================

$(document).on("click", "#btnSave", function(event)
{ 


// Clear status msges---------------------
$("#alertSuccess").text(""); 
$("#alertSuccess").hide(); 
$("#alertError").text(""); 
$("#alertError").hide();


// Form validation-------------------
var status = validateItemForm(); 
// If not valid
if (status != true) 
{ 
 $("#alertError").text(status); 
 $("#alertError").show(); 
return; 
}

$("#alertSuccess").text("Saved successfully.");
$("#alertSuccess").show(); 
 
$("#formUser")[0].reset();

});

function validateItemForm()
{
		// NAME
if ($("#txtName").val().trim() == "") 
 { 
 return "Insert student name."; 
 } 
 }
 