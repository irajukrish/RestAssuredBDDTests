package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EDLoginTest {
	
	@Test
	public void EDLogin() {
		
		HashMap map=new HashMap();
		map.put("email", "jai");
		map.put("password", "pass");
		
		Response response=given()
			.baseUri("http://uatreplica.enterodirect.com/auth/local")
			.body(map)
			.contentType("application/json")
		.when()
			.post()
		.then()
			.statusCode(200)
			.assertThat().body("status", equalTo("success"))
			.assertThat().body("message", equalTo("Record found"))
			.log().all()
			.extract().response();
		
		String JSONString=response.asString();
		System.out.println(JSONString);
		
		String Token=response.body().jsonPath().get("token").toString();
		System.out.println(Token);
		
	}

}
