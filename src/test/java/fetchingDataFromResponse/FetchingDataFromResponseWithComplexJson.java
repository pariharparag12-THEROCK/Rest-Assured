package fetchingDataFromResponse;

import static io.restassured.RestAssured.given;



import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchingDataFromResponseWithComplexJson {
	
	
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
		
		
		JsonPath jp = resp.jsonPath();
		
		String	perpagevalue =	jp.getString("per_page");
		
		System.out.println(perpagevalue);
		
		
		
		String urlvalue = jp.getString("support.url");
		
		System.out.println(urlvalue);
		
		
		String firstname = jp.getString("data[2].first_name");
		System.out.println(firstname);
		
		
		int	idvalue	= jp.getInt("data[1].id");
		System.out.println(idvalue);
		
		
		Assert.assertEquals(firstname, "Tobias");
		
		
		//Handling the dynamic array in json
		
		
		int totalnumberOfElementInarray	= jp.getInt("data.size()");
		
		System.out.println(totalnumberOfElementInarray);
		
		
		for (int i=0; i<=totalnumberOfElementInarray-1; i++) {
			
			String	firstnamevalue =	jp.getString("data["+i+"].first_name");	
			
			System.out.println(firstnamevalue);
			
		
		}
		
		
		
		
	}
	
}
