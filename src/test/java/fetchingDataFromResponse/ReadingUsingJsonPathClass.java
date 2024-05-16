package fetchingDataFromResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ReadingUsingJsonPathClass {

	
	@Test
	public void GetListOfUsers() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
		
			Response	resp	=	given()
								
								.when()
								
								.get("api/users/2")
								
								.then()
								
								.extract()
								
								.response();
		
			
			String response = resp.asPrettyString();
			
			System.out.println(response);
			
			
			JsonPath jp = new JsonPath(response);
			
			String emailvalue =	jp.getString("data.email");
			
			System.out.println(emailvalue);
								
	}

}
