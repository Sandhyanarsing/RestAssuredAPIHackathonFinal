package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TestRequest.assertions;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import payloads.payload;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class userLoginSD {
	
	String requestBody;
	public static  String token;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
	assertions asserts = new assertions();


	
	@Given("admin sets Authoization to No  Auth.")
	public void admin_sets_authoization_to_no_auth() {
	    given().auth().none();
	}
	@Given("Admin creates request with valid credentials UL")
	public void admin_creates_request_with_valid_credentials_UL() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet1");
	      
	}

	@When("Admin calls Post Https method  with valid endpoint UL")
	public void admin_calls_post_https_method_with_valid_endpoint_UL() throws IOException {
		 File logFile = new File("logs.txt");
		 
		 FileOutputStream fos = new FileOutputStream(logFile);
	        PrintStream ps = new PrintStream(fos);
	        System.setOut(ps);
	        
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
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
				fos.close();
//				asserts.assertUserLoginModule();
				response.then().header("Content-Type", equalTo("application/json"))
				.body("userId", instanceOf(String.class)).assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("LoginSchemaValidation.json"));
	}
	
	@When("Admin calls Post Https method  with valid endpoint noschemavalidation")
	public void admin_calls_post_https_method_with_valid_endpoint_noschemavalidation() throws IOException {
		 File logFile = new File("logs.txt");
		 
		 FileOutputStream fos = new FileOutputStream(logFile);
	        PrintStream ps = new PrintStream(fos);
	        System.setOut(ps);
	        
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
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
				fos.close();

	}
	
	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
		// System.out.println(requestBody);
		response.then().statusCode(200);
		token = response.jsonPath().getString("token");
		String gettoken = Authorization.scenarioContext.setContext("Token", token);
	}
	
	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws IOException {
		 File logFile = new File("logs.txt");
		 
		 FileOutputStream fos = new FileOutputStream(logFile);
	        PrintStream ps = new PrintStream(fos);
	        System.setOut(ps);
	        
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
				for(int i=0; i<data.size();i++) {
			 requestBody = payload.UserLogin(data,i);
			response = RestAssured
		    		   .given()
		    		   //.filter(new AllureRestAssured())
		    		   .spec(RS.createReq(URLs.userLoginInvalid))
		    		   .body(requestBody)
		    		   .when().post();
			LoggerLoad.info("User Logged In");
		}
				fos.close();
	}
	

	@Then("Admin receives {int} response")
	public void Admin_receives_created(Integer intl) {
		 System.out.println(intl);
		response.then().statusCode(intl);
		token = response.jsonPath().getString("token");
		String gettoken = Authorization.scenarioContext.setContext("Token", token);

	}
	
	
	
	@Given("Admin creates request with invalid credentials")
	public void admin_creates_request_with_invalid_credentials() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet4");
	      
	}
	
	
 
}
