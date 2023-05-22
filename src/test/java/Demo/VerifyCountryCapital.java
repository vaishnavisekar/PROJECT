package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class VerifyCountryCapital {
	@Test
	public void getAllCOuntryNames() {
		RestAssured.
		when()
		   .get("https://restcountries.com/v3.1/capital/tokyo")
		   .then()
              .assertThat()	
              .statusCode(200)
              .log().all()
              .body("[0].name.official",is("Japan"));
	}

}
