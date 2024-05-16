package fetchingDataFromResponse;





import org.junit.Assert;
import org.testng.annotations.Test;


import io.restassured.path.json.JsonPath;

public class Assignment {

	@Test
	public void AssignmentValidate() {
		
					
			String	json  = "{\r\n"
							+ "\"dashboard\": {\r\n"
							+ "\"purchaseAmount\": 910,\r\n"
							+ "\"website\": \"www.abc.com\"\r\n"
							+ "},\r\n"
							+ "\"courses\": [\r\n"
							+ "{\r\n"
							+ "\"title\": \"Selenium Python\",\r\n"
							+ "\"price\": 50,\r\n"
							+ "\"copies\": 6\r\n"
							+ "},\r\n"
							+ "{\r\n"
							+ "\"title\": \"Cypress\",\r\n"
							+ "\"price\": 40,\r\n"
							+ "\"copies\": 4\r\n"
							+ "},\r\n"
							+ "{\r\n"
							+ "\"title\": \"RPA\",\r\n"
							+ "\"price\": 45,\r\n"
							+ "\"copies\": 10\r\n"
							+ "}\r\n"
							+ "]\r\n"
							+ "}";
				
				
			JsonPath jp = new JsonPath(json);
	
	
			//1. Print number of courses return by API	
			
			int coursessize	= jp.getInt("courses.size()");
			System.out.println("Number of courses : " +  coursessize +"\n");
	
	
			
			//2. Print purchase amount
			
			int purchaseamountvalue =	jp.getInt("dashboard.purchaseAmount");
			System.out.println("Purchase amount value is : "+purchaseamountvalue +"\n");
			
			
			//3. Print title of the first course
			
			String titlevaluefirstcourse =	jp.getString("courses[0].title");
			System.out.println("Title value of the first course is: " + titlevaluefirstcourse +"\n");
			
			//4. Print All course titles and their respective Prices
			
			System.out.println("course titles and their respective Prices are :" );
					
			for(int i=0 ; i<=coursessize-1; i++) {
			
				String	courseTitle =	jp.getString("courses["+i+"].title");
				
				int	pricevalueofRespectiveCourse = jp.getInt("courses["+i+"].price");
						
				System.out.println(courseTitle +"  "+ pricevalueofRespectiveCourse);		
				
			}
			
			System.out.println();
			
			
			//5. Print no of copies sold by RPA Course
			
			
			for (int i=0; i<=coursessize-1; i++) {
				
				String	coursetitle1 =	jp.getString("courses["+i+"].title");
				
				if (coursetitle1.equals("RPA")) {
					
					int copiesvalue  = jp.getInt("courses["+i+"].copies");
					System.out.println("Copies sold by RPA is : " +copiesvalue + "\n");
				}
			}
			
			
		//	6. Verify if Sum of all Course prices matches with Purchase Amount
			
			int sum = 0;
			
			for (int i=0 ; i<=coursessize-1; i++) {
				
				int price	=	jp.getInt("courses["+i+"].price");
				
				int copies  = jp.getInt("courses["+i+"].copies");
				
				sum = sum + price*copies;			
			}
			
			System.out.println(sum);
			
			
			int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
			
			System.out.println(purchaseAmount);
			
			
//			if (sum==purchaseAmount) {
//				
//				Assert.assertTrue(true);
//			}
			
			
			Assert.assertEquals(sum, purchaseAmount);
			
			
			
	
	}
}
