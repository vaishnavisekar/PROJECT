package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteDemo {

	
	@Test
	public void deleteResource() {
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users/2";
		RestAssured
		      .when()
		        .delete()
		      .then()
		      .statusCode(204);
		
	}
}
