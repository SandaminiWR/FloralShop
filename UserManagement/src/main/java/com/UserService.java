package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;


import model.User;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/User")
public class UserService {
	
				 User usObj = new User(); 
				  
				@GET
				@Path("/") 
				@Produces(MediaType.TEXT_HTML) 
				public String readUser() 
				 { 
				 return usObj.readUser(); 
				 }
			
			@POST
			@Path("/") 
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)

	public String insertUSer
				(@FormParam("name") String name, 
				 @FormParam("phone") String phone, 
				 @FormParam("address") String address, 
				 @FormParam("email") String email, 
				 @FormParam("password") String password,
	 			 @FormParam("confirmpassword") String confirmpassword)
				{
			String output = usObj.insertUser(name, phone, address, email, password, confirmpassword);
				return output;
				}
			
			@PUT
			@Path("/") 
			@Consumes(MediaType.APPLICATION_JSON) 
			@Produces(MediaType.TEXT_PLAIN)
	
	public String updateUser(String userData) 
			{ 
				//Convert the input string to a JSON object 
				 JsonObject userObj = new JsonParser().parse(userData).getAsJsonObject(); 
				//Read the values from the JSON object
				 String UserID = userObj.get("id").getAsString(); 
				 String userName = userObj.get("name").getAsString(); 
				 String phone = userObj.get("phone").getAsString(); 
				 String address = userObj.get("address").getAsString(); 
				 String email = userObj.get("email").getAsString(); 
				 String password = userObj.get("password").getAsString();
				 String confirmpassword = userObj.get("confirmpassword").getAsString();
				 String output = usObj.updateUser(UserID, userName, phone, address, email, password, confirmpassword);
				return output; 
			}
		
			@DELETE
			@Path("/") 
			@Consumes(MediaType.APPLICATION_XML) 
			@Produces(MediaType.TEXT_PLAIN) 
			
	public String deleteUser(String userData) 
			{ 
				//Convert the input string to an XML document
				 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
				 
				//Read the value from the element <ID>
				 String UserID = doc.select("id").text(); 
				 String output = usObj.deleteUser(UserID); 
				return output; 
			}
			
			
			    @GET
			    @Path("/readUsers/{username}") 
			    @Consumes(MediaType.APPLICATION_XML)
			    @Produces(MediaType.TEXT_HTML) 
			    
			    //call read all user details  method
	public String readUsers( @PathParam(value = "username")String name)
			    {
			        return usObj.RequestReadUserDetails(name) ;
			    }
			    
			    
			    
			    
			   
			    @POST
			    @Path("/login") 
			    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			    @Produces(MediaType.TEXT_PLAIN) 
			    //login  method
			    
	public String login( @FormParam("id")String id, @FormParam("password")String password)
			    {
			    	System.out.print("run");
			        return usObj.userlogin(id,password) ;
			    }
			    
			    
			   
			    
			    
			    
			    

}


