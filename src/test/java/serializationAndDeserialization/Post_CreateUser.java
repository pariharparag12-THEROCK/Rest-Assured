package serializationAndDeserialization;

import org.testng.annotations.Test;


import io.restassured.RestAssured;

import pojo.RequestBody;
import pojo.ResponseBody;

import static io.restassured.RestAssured.*;

public class Post_CreateUser {

//for Serialization and deserialization we need to add 3 dependencies which is responsible for converting java object into byte code & vice versa.
	
	
	
	@Test
	public void createuser() {
		
		
		RequestBody mainobject = new RequestBody();
		
		mainobject.setId(0);
		mainobject.setUsername("pariharparag");
		mainobject.setFirstName("parag");
		mainobject.setLastName("parihar");
		mainobject.setEmail("parihar@parag.com");
		mainobject.setPassword("pass12");
		mainobject.setPhone("678898281");
		mainobject.setUserStatus(0);
		
		
		
		RestAssured.baseURI ="https://petstore.swagger.io/v2";
		
		 ResponseBody responseObject = given()
				
						.body(mainobject)   //serialization
						
						.header("Content-Type", "application/json")
						
						.log().all()
				
						.when()
						
						.post("user")
						
						.then()
						
						.log().all()
						
						.extract()
						
						.response().as(ResponseBody.class); // Deserialization
		
		
		 
		 int codevalue	=  responseObject.getCode();
		 System.out.println(codevalue);
		 
		 
		 String msgvalue = responseObject.getMessage();
		 System.out.println(msgvalue);	
		 
	}
}
