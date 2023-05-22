package Demo;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTDemo {
  
	HashMap<String , String> map = new HashMap<>();
	@BeforeTest
	public void CreatePayLoad() {
		map.put("name","morpheus");
		map.put("job","zion resident");
		RestAssured.baseURI ="https://reqres.in/";
		RestAssured.basePath = "api/users/767";
		
	}
	@Test
	public void updateResource() {
		RestAssured
		.given()
               .contentType("application/json")
               .body(map)
         .when()
             .put()
         .then()
              .statusCode(200)
              .log().all();
	}
	
}
