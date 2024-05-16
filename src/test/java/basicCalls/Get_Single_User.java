package basicCalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_Single_User {

	
	@Test
	public void getSingleUserDetails() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given()
					
					.when()
					
					.get("/api/users/2")
					
					.then()
					
					.extract()
					
					.response();
					
		
		String response	 = resp.asPrettyString();
		
		
		System.out.println(response);
					
	}
}
