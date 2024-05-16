package practiceDeserializationPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

public class DeserializationAPI {
		
	
	@Test
	public void complexBody() {
		
		
		RestAssured.baseURI = "https://reqres.in/";
		
								
			Response resp =		given()
												
								.queryParam("page", "2")
												
								.log().all()
												
								.when()
												
								.get("api/users")
												
								.then()
												
								.log().all()
												
								.extract()
												
								.response();
												
												
				ResponseBODY responsebody = resp.as(ResponseBODY.class);
				
				int pagevalue	 =	responsebody.getPage();
				System.out.println("Page Value is : "+ pagevalue);
				
				
				int perpagevalue	 =	responsebody.getPer_page();
				System.out.println("Per_Page Value is : "+ perpagevalue);
				
				
				int totalvalue	 =	responsebody.getTotal();
				System.out.println("Total Value is : "+ totalvalue);
				
				
				
				int totalPagesvalue	 =	responsebody.getTotal_pages();
				System.out.println("Total_Pages Value is : "+ totalPagesvalue);
				
				
				
				List<DATA> data = responsebody.getData();
				
				DATA dataIndex = data.get(2);
				
				String lastnamevalue = dataIndex.getLast_name();
				System.out.println("LastNameValue is : "+ lastnamevalue);
				
				Assert.assertEquals(lastnamevalue, "Funke");
				
				
				
				 String emailvalue = responsebody.getData().get(3).getEmail();
				System.out.println("EmailValue is : "+ emailvalue);
				
				Assert.assertEquals(emailvalue, "byron.fields@reqres.in");
		
	}
}
