package basicCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class Get_SingleUser_With_PathParam {

	
	@Test
	public void getListOfUserDetailsWithPathparam() {
		
		RestAssured.baseURI ="https://reqres.in/";
		
		Response resp	=	 given()
		
							.pathParam("keyOfThePathParam", "2")
			
							.when()
							
							.get("api/users/{keyOfThePathParam}")
													
							.then()
							
							.extract()
						
							.response();
		
		
			String response =	resp.asPrettyString();
			
			System.out.println(response);
	}
	
}
