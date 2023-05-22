package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETCurrentWeatherinfo {
 
	
	
	 @Test
	 public void getcurrentweatherunfo() {
		 RestAssured
		   .given()
		       .param("q","new delhi")
               .param("appid","1e684143ab869e3d89351eb23cdc9556")	
           .when()
                .get("https://api.openweathermap.org/data/2.5/weather")
            .then()
                 .statusCode(200)
                 .log().all();
			 
		 
	 }
}
