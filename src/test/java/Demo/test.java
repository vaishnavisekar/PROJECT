package Demo;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class test {
	
	
		HashMap<String,String> map = new HashMap<>();
		
		@BeforeTest
		public void createpayload() {
			map.put("mmm", "djlkj");
			RestAssured.baseURI ="https://gorest.co.in/";
			RestAssured.basePath = "/public/v2/users";
			
			}
		
		@Test
		public void createResource() {
			RestAssured
			 .given()
			    .contentType("application/json")
			    .body(map)
			    .header("Authorization","Bearer 2aa1ca4658c95fdb3d05152dc096a78788ac856d930385d02279e0601f4b6aab ")
			 .when()
			   .post()
			 .then()
			   .statusCode(201)
			   .log().all();
			
			
		}
		
}
