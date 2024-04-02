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

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import payloads.payload;

public class userLoginSD {

	String requestBody;
	public static String token;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
	List<Response> responses = new ArrayList<>();

	@Given("admin sets Authoization to No Auth.")
	public void admin_sets_authoization_to_no_auth() {
		given().auth().none();
	}

	@Given("Admin creates request with valid userlogin credentials UL")
	public void admin_creates_request_with_valid_userlogin_credentials_ul() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "UserLogin");
	}

	@When("Admin calls Post Https method  with valid userlogin endpoint UL")
	public void admin_calls_post_https_method_with_valid_userlogin_endpoint_ul() throws IOException {
		File logFile = new File("logs.txt");
		FileOutputStream fos = new FileOutputStream(logFile);
        PrintStream ps = new PrintStream(fos);
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
		
		int i=0;			
				String requestBody = payload.UserLogin(data, i);
				//System.out.println(requestBody);
			
				response = RestAssured
						   .given()
						   .spec(RS.createReq(URLs.userLogin))
						   .body(requestBody)
						   .when().post();
				
		fos.close();
	}
	@Then("Admin receives \\{int} created with auto generated token UL")
	public void admin_receives_created_with_auto_generated_token_ul() {
		response.then().statusCode(200);
	    token = response.jsonPath().getString("token");
	    String gettoken = Authorization.scenarioContext.setContext("Token", token);
	}
}

	
	