package TestRequest;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import Utilities.LoggerLoad;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class assertions {

	Response response;
	
	
	public assertions(Response response) {
        this.response = response;
    }
	
	public void assertUserLoginModule() {
		// response.then().log().all();
		response.then().header("Content-Type", equalTo("application/json"))
				.body("userId", instanceOf(String.class)).assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("LoginSchemaValidation.json"));

	}

	public void assertUserModule() {
		//response.then().log().all();
		response.then()
		.body("userFirstName", containsString("RestFulRulers"))
        .header("Content-Type", equalTo("application/json"))
        .body("userFirstName", instanceOf(String.class))
        .body("userId", instanceOf(String.class))
        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("UserModuleSchema.json"));
      LoggerLoad.info("the validation is success");
	}
	public void assertBatchModule() {
		//response.then().log().all();
		response.then()
		.body("batchName", containsString("TechGeeks"))
        .header("Content-Type", equalTo("application/json"))
        .body("batchName", instanceOf(String.class))
       // .body("batchId", instanceOf(Integer.class))
        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("BatchModuleSchema.json"));
      LoggerLoad.info("the validation is success");
	}

}

