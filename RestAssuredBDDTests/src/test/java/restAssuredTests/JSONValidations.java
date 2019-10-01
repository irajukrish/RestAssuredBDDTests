package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JSONValidations {
	
	@Test
	public void JSONValidationforSingleContentTest() {
		
		given()
			.pathParam("postId","1")
		.when().get("https://jsonplaceholder.typicode.com/comments?{postId}")
		.then()
			.statusCode(200)
			.body("[3].email", equalTo("Lew@alysha.tv"));
		
	}
	
	
	@Test
	public void JSONValidationforMultipleContentTest() {
		
		given()
			.pathParam("postId","1")
		.when().get("https://jsonplaceholder.typicode.com/comments?{postId}")
		.then()
			.statusCode(200)
			.body("email", hasItems("Lew@alysha.tv","Nikita@garfield.biz"));
		
	}

}
