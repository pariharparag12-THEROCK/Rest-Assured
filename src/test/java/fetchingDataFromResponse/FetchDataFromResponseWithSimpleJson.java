package fetchingDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDataFromResponseWithSimpleJson {

	@Test
	public void createuser() {
		
		RestAssured.baseURI ="https://petstore.swagger.io/v2";
		
		Response resp =	given()
				
						.body("{\r\n"
								+ "  \"id\": 0,\r\n"
								+ "  \"username\": \"cena\",\r\n"
								+ "  \"firstName\": \"raven\",\r\n"
								+ "  \"lastName\": \"john\",\r\n"
								+ "  \"email\": \"john@gmail.com\",\r\n"
								+ "  \"password\": \"password1\",\r\n"
								+ "  \"phone\": \"789098723445\",\r\n"
								+ "  \"userStatus\": 0\r\n"
								+ "}")
						
						
						.header("Content-Type", "application/json")
				
						.when()
						
						.post("user")
						
						.then()
						
						.extract()
						
						.response();
		
		
				String response =	resp.asPrettyString();
				
				System.out.println(response);
				
				
				JsonPath jp = resp.jsonPath();
				
				String	typevalue  = jp.getString("type");
				
				System.out.println(typevalue);
				
				
				
				int	codevalue =	jp.getInt("code");
				
				System.out.println(codevalue);
				
				
				
				
	}
	
}
