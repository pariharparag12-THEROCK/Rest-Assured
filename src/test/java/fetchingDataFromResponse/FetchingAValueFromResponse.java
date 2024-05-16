package fetchingDataFromResponse;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class FetchingAValueFromResponse {


	@Test
	public void FetchingValueFromRespnse () {
		
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
		
		
		int statuscode = 	resp.statusCode();	
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		long timerequired =	resp.getTime();		
		System.out.println(timerequired);
		
		
		Headers	headervalue	= resp.headers();
		System.out.println(headervalue);
		
		
		List<Header> listOfHeaders	= 	headervalue.asList();
		System.out.println(listOfHeaders);
		
		String	valueOfHeader =	resp.getHeader("Content-Type");
		System.out.println(valueOfHeader);
		
		if (valueOfHeader.equals("application/json")) {
			
			Assert.assertTrue(true);
		}
		
		
		else {
			Assert.assertTrue(false);
		}
		
	}
	
}
