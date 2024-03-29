package Demo;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
	@Test(priority = 0)
	public class POSTDemo {
		
		
			
			HashMap<String, String> map = new HashMap<>();
			String id;
			Logger logger;
			UUID uuid = UUID.randomUUID();
			
			
			@BeforeTest
			public void createpPayLoad() {
				logger = Logger.getLogger( "LogDemo");
				PropertyConfigurator.configure("log4j.properties");
				map.put("name", "superman");
				map.put("email", uuid +  "@gmail.com");
				map.put("gender", "male");
				map.put("status", "active");
				
				logger.info("payloaad created");
				RestAssured.baseURI =    "https://gorest.co.in/";
				RestAssured.basePath="public/v2/users";
			}
			
			
		    public void  createResource() {
		    	//extract the response
		    	 Response response = RestAssured
		    	.given()
		    	   
		    	     .contentType("application/json")
		    	     .body(map)
		    	     .header("Authorization","Bearer 2aa1ca4658c95fdb3d05152dc096a78788ac856d930385d02279e0601f4b6aab")
		         .when()

		           .post()
		         .then()
		            .log().all()
		    	    .contentType(ContentType.JSON).extract().response();
		    	 
		    	    JsonPath jsonPath = response.jsonPath();
		            id =jsonPath.getString("id");
		    	   
		    }
		    //Verify resource has been created
		    
		    @Test(priority=2 )
		    public void updateResource() {
		    	map.put("name", "vaishnavi");
				map.put("email", uuid +  "@gmail.com");
				map.put("gender", "male");
				map.put("status", "active");
		    	
				RestAssured.baseURI =    "https://gorest.co.in/";
				RestAssured.basePath="public/v2/users/" + id;
				
				
				RestAssured
			     .given() 
			       .contentType("application/json")
			       .body(map)
			       .header("Authorization","Bearer 2aa1ca4658c95fdb3d05152dc096a78788ac856d930385d02279e0601f4b6aab")
			     .when()
			        .put()
			     .then()
			         .statusCode(200)
			         .log().all();
			        
				
				
				
			}

	}
