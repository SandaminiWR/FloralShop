package com;
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

import com.google.gson.JsonObject;

import model.Delivery;
@Path("/Delivery")
public class DeliveryService {
	
	Delivery deliveryObj = new Delivery(); 

	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readDelivery() 
	 { 
	 return deliveryObj.readDelivery(); 
	 }
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertDelivery(@FormParam("CID") String CID, 
			@FormParam("Dtype") String Dtype, 
			@FormParam("Ddesc") String Ddesc) 
	{ 
		String output = deliveryObj.insertDelivery(CID, Dtype, Ddesc); 
		return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateDelivery(String deliveryData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject deliveryObject = new JsonParser().parse(deliveryData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String DID = deliveryObject.get("DID").getAsString(); 
	 String CID = deliveryObject.get("CID").getAsString(); 
	 String Dtype = deliveryObject.get("Dtype").getAsString(); 
	 String Ddesc = deliveryObject.get("Ddesc").getAsString(); 
	 String output = deliveryObj.updateDelivery(DID, CID, Dtype, Ddesc); 
	return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteDeliveery(String deliveryData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(deliveryData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <DID>
	 String DID = doc.select("DID").text(); 
	 String output = deliveryObj.deleteDelivery(DID); 
	return output; 
	}

}

