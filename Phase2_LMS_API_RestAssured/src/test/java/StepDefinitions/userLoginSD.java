package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.payload;

public class userLoginSD {
	
	 String requestBody;
	public static  String token;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
	
	@Given("admin sets Authoization to No  Auth.")
	public void admin_sets_authoization_to_no_auth() {
	    given().auth().none();
	}
	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet1");
	      
	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {
		
				for(int i=0; i<data.size();i++) {
			
			 requestBody = payload.UserLogin(data,i);
			
			response = RestAssured
		    		   .given()
		    		   //.filter(new AllureRestAssured())
		    		   .spec(RS.createReq(URLs.userLogin))
		    		   .body(requestBody)
		    		   .when().post();
			LoggerLoad.info("User Logged In");
		
		}

	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
				
	   response.then().log().all().statusCode(200);
	    token = response.jsonPath().getString("token");
	    String gettoken = Authorization.scenarioContext.setContext("Token", token);

	}

}
