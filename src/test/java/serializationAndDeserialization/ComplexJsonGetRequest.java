package serializationAndDeserialization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Data;
import pojo.ResponseComplexJsonBody;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;


public class ComplexJsonGetRequest {

	
		@Test
		public void getListOfUserDetailsWithQueryparam() {
			
	
			
			RestAssured.baseURI = "https://reqres.in/";
			
			 ResponseComplexJsonBody responseObject = given()
					
							.queryParam("page", "2")
							
							.log().all()
			
							.when()
							
							.get("api/users")
							
							.then()
							
							.log().all()
							
							.extract()
							
							.response().as(ResponseComplexJsonBody.class);
			
			
			 	int pagevalue = responseObject.getPage();
			 	
			 	System.out.println(pagevalue);
			
			 	
			 	int totalpagesvalue = responseObject.getTotal_pages();
			 	
			 	System.out.println(totalpagesvalue);
			 	
			 	
			 	List<Data> data = responseObject.getData();
			 	
			 	Data	datalist = 	data.get(1);
			 	
			 	String lastname =	datalist.getLast_name();
			 	
			 	
			 	System.out.println(lastname);
		}
	
}
