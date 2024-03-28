package StepDefinitions;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class userLoginSD {
	
	 String requestBody;
	public static  String token;
	Response response;
	RequestSpec RS = new RequestSpec();
	
	@Given("admin sets Authoization to No  Auth.")
	public void admin_sets_authoization_to_no_auth() {
	    given().auth().none();
	}
	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
	      requestBody = "{\n" +
	                "  \"password\": \"lmsHackathon@2024\",\n" +
	                "  \"userLoginEmailId\": \"numpyninja@gmail.com\"\n" +
	                "}";
	 //System.out.println(requestBody);
	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {
		
		Assert.assertNotNull("requestBody is null. Make sure it is initialized in the previous step.", requestBody);
	    response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.userLogin))
	    		   .body(requestBody)
	    		   .when().post();
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
		//System.out.println(requestBody);
	    response.then().statusCode(200);
	    token = response.jsonPath().getString("token");
	    String gettoken = Authorization.scenarioContext.setContext("Token", token);

	}

}
