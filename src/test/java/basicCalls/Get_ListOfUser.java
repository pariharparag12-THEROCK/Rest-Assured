package basicCalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//It is recommended by restAssured and by using the static import our code will be less complex(easy), readability more and we don't need to give again and again.....
//.....the class name "RestAssured", we can access only by calling the method name, thats why we do static import


public class Get_ListOfUser {

	
	
	@Test
	public void getListOfUsers() {
		
		
		RestAssured.baseURI = "https://reqres.in";
		
		Response resp =	given().
		
						when().
						
						get("api/users?page=2").
				
						then().
						
						extract().   //It extract the response
						
						response();
						
		
		String response	= resp.asPrettyString();
		
		System.out.println(response);
		
	}
}
