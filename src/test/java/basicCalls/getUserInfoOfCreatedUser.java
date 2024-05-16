package basicCalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getUserInfoOfCreatedUser {

	
	
	
	@Test
	public void userInfo() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			Response resp	=    given()
								
								.pathParam("username", "cena")
								
								.when()
								
								.get("user/{username}")
							
								.then()
								
								.extract()
								
								.response();
			
			
		String response = resp.asPrettyString();
		
		System.out.println(response);
	}
}
