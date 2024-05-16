package basicCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class Get_ListOfUser_With_QueryParam {

	
		@Test
		public void getListOfUserDetailsWithQueryparam() {
			
			RestAssured.baseURI = "https://reqres.in/";
			
			Response resp =	given()
					
							.queryParam("page", "2")
			
							.when()
							
							.get("api/users")
							
							.then()
							
							.extract()
							
							.response();
			
			
			String	response  =	resp.asPrettyString();
			
			System.out.println(response);
			
			
		}
	
}
