package specBuilder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;




public class CreateUser {

	RequestSpecification requestspecification;

	ResponseSpecification responsepecification;
	
	
	
	
	//@BeforeClass is used for executing this method before run any of the method in the class
	// if we directly run the class without giving @BeforeClass anotation.... 
	//then the value store in requestspecification & responsepecification will be null and it throws exception
	
	@BeforeClass
	public void  initrequestAndResponseSpecBuilder() {
		
		// Defining request properties
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
		
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		
		requestSpecBuilder.log(LogDetail.ALL); //print everything
	
		requestspecification = requestSpecBuilder.build();
		
		// Defining response properties
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.expectStatusCode(200);
		
		responseSpecBuilder.expectContentType(ContentType.JSON); // ContentType.JSON means expecpted to be application/json
		
		requestSpecBuilder.log(LogDetail.ALL); //print everything
		
		responsepecification = responseSpecBuilder.build();
		
	}
	
	
	
	@Test
	public void createuser() {
		
	//	RestAssured.baseURI ="https://petstore.swagger.io/v2";
		
						 given()
				
						.spec(requestspecification)
				
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
						
						
			//			.header("Content-Type", "application/json")
				
						.when()
						
						.post("user")
						
						.then()
						
						.spec(responsepecification);
				
	}
	
	
}
