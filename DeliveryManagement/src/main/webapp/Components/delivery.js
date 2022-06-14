$(document).ready(function()
{ 
if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); 
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status =  validateDeliveryForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
 var type = ($("#hidDeliveryIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "DeliveryAPI", 
 type : type, 
 data : $("#formDelivery").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onDeliverySaveComplete(response.responseText, status); 
 } 
 }); 
}); 

function onDeliverySaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divDeliveryGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 
 $("#hidDeliveryIDSave").val(""); 
 $("#formDelivery")[0].reset(); 
}
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidDeliveryIDSave").val($(this).closest("tr").find('#hidDeliveryIDSave').val()); 
 $("#CID").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#Dtype").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#Ddesc").val($(this).closest("tr").find('td:eq(2)').text()); 
 
}); 

$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "DeliveryAPI", 
 type : "DELETE", 
 data : "DID=" + $(this).data("deliveryid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onDeliveryDeleteComplete(response.responseText, status); 
 } 
 }); 
});
function onDeliveryDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#diveliveryGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 }
 }
// CLIENT-MODEL================================================================
function validateDeliveryForm() 
{ 
// CODE
if ($("#CID").val().trim() == "") 
 { 
 return "Insert Item Code."; 
 } 
// NAME
if ($("#Dtype").val().trim() == "") 
 { 
 return "Insert Item Name."; 
 } 
// PRICE-------------------------------
if ($("#Ddesc").val().trim() == "") 
 { 
 return "Insert Item Price."; 
 } 

return true; 
}