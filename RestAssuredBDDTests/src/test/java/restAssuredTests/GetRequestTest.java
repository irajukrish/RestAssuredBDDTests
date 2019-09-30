package restAssuredTests;

import org.testng.annotations.Test;

import io.restassured.http.Method;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest {
	
	@Test
	public void GRT() {
		
		given()
		.when()
				.get("https://reqres.in/api/users?page=2")
		.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("total", equalTo("12"))
				.header("Content-Type", "application/json");
		
		
	}

}
