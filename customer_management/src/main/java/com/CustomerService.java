/**
 * 
 */
package com;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.Customer;

@Path("/Customer")

/**
 * @author USER
 *
 */
public class CustomerService {
	//RESTful API Implementation	

		Customer customerObj = new Customer();

		
		//Read Customer () method
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readCustomer() {
			return customerObj.readCustomer();
		}

		
		//Insert Customer() method
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String insertCustomer(@FormParam("name") String name, 
								@FormParam("phone") String phone, 
								@FormParam("address") String address, 
								@FormParam("mail") String mail, 	 
								@FormParam("password") String password,
								@FormParam("confirmpassword") String confirmpassword)
		{ 
		 String output = customerObj.insertCustomer(name, phone, address, mail, password, confirmpassword); 
		 
		return output; 
		}

		
		
		//UpdateCustomer() method
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String updateCustomer(String id) 
		{ 
			
		//Convert the input string to a JSON object 
		 JsonObject customerObj = new JsonParser().parse(id).getAsJsonObject(); 
		 
		//Read the values from the JSON object
		 String Cusid = customerObj.get("id").getAsString(); 
		 String name = customerObj.get("name").getAsString(); 
		 String phone = customerObj.get("name").getAsString(); 
		 String address = customerObj.get("address").getAsString(); 
		 String mail = customerObj.get("mail").getAsString(); 
		 String password = customerObj.get("password").getAsString(); 
		 String confirmpassword = customerObj.get("password").getAsString(); 
		 
		 String output = customerObj.updateCustomer(id, name, phone, address, mail, password, confirmpassword); 
		 
		return output; 
		}
		
		
		
		//Delete Customer() method
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String deleteCustomer(String CustomerData) 
		{ 
			
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(CustomerData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <id>
		 String CustomerData1 = doc.select("id").text(); 
		 String output = customerObj.deleteCustomer(CustomerData1); 
		 
		return output; 
		}

}
