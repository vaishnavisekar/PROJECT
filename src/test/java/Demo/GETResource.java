package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETResource {
	
	public class GETDEMO {
		@Test
		
	 public void getResourceInfo() {
			RestAssured
			.given()
			   .contentType("application/json")
			    .header("Authorization","Bearer 2aa1ca4658c95fdb3d05152dc096a78788ac856d930385d02279e0601f4b6aab")
			    
			
			  . when()
			      .get("https://gorest.co.in/public/v2/users")
			   .then()
			     .assertThat()
			     .statusCode(200)
			      .log().all();
			
		}
	}


}
