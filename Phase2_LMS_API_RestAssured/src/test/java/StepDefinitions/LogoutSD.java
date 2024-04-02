package StepDefinitions;

import java.util.List;
import java.util.Map;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogoutSD {
	String token;
	Authorization auth = new Authorization();
	// ExcelTestData ExcelData = new ExcelTestData();
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
//	List<Response> responses = new ArrayList<>();
	String retrievedtoken;
	
	

	
	@When("Admin calls Get Https method with valid endpoint")
	public void Admin_sends_HTTPS_LogOutRequest_WithAuth() {
		System.out.println(token);
		response = RestAssured.given().spec(RS.getReq(URLs.userlogout)).when().get();
	}
	
	@When("Admin calls Get Https method withinvalid endpoint")
	public void Admin_sends_HTTPS_LogOutRequest_WithInvalidEndPoint() {

		response = RestAssured.given().spec(RS.getReq(URLs.userlogoutInvalid)).when().get();
	}
	
	@When("Admin calls Get Https method with valid endpoint No Auth")
	public void Admin_sends_HTTPS_LogOutRequest_WithNoAuth() {

		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.userlogout)).when().get();
	}
	
	
	@Then("Verify {int} response displayed Logout")
	public void Verify_responsecode_displayedAsExpected(Integer resCode) {
		// System.out.println(requestBody);
		response.then().statusCode(resCode);
		if (response.statusCode() == resCode) {
			System.out.println("sucess");
		} else {
			System.out.println("failure");
		}
	}






}
