package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MapControllerSD {
	String token;
	Authorization auth = new Authorization();
	// ExcelTestData ExcelData = new ExcelTestData();
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
	List<Response> responses = new ArrayList<>();
	String retrievedtoken;

	
	  //Check if admin is able to retreive all Admins with assigned program batches
	 
	@When("Admin sends HTTPS Request With Auth")
	public void Admin_sends_HTTPS_Request_WithAuth() {

		response = RestAssured.given().spec(RS.getReq(URLs.getuserRoleProgramBatchMap)).when().get();
	}
	//Check if admin is able to retreive all Admins with assigned program batches with No Authorization
	@When("Admin sends HTTPS Request No Auth")
	public void Admin_sends_HTTPS_Request_NoAuth() {

		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.getuserRoleProgramBatchMap)).when().get();
	}



	@Then("Verify {int} response displayed")
	public void Verify_responsecode_displayedAsExpected(Integer resCode) {
		// System.out.println(requestBody);
		response.then().statusCode(resCode);
		if (response.statusCode() == resCode) {
			System.out.println("sucess");
		} else {
			System.out.println("failure");
		}
	}
	 //Check if admin is able to retreive assigned program batches for valid AdminId
	@When("Admin sends HTTPS Request with ValidAdminId and Auth")
	public void Admin_sends_HTTPS_Request_with_AdminId_Auth() {

		response = RestAssured.given().spec(RS.getReq(URLs.getuserRoleProgramBatchMap + "/U877")).when().get();
		System.out.println(response);
	}
	//Check if admin is able to retreive assigned program batches for invalid AdminId
	@When("Admin sends HTTPS Request with InvalidAdminId and Auth")
	public void Admin_sends_HTTPS_Request_with_InvalidAdminId_Auth() {

		response = RestAssured.given().spec(RS.getReq(URLs.getuserRoleProgramBatchMap + "/U179")).when().get();
		System.out.println(response);
	}
	//Check if admin is able to retreive assigned program batches for valid AdminId  with No Authorization
	@When("Admin sends HTTPS Request with validAdminId and NoAuth")
	public void Admin_sends_HTTPS_Request_with_validAdminId_NoAuth() {

		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.getuserRoleProgramBatchMap + "/U425")).when().get();
		System.out.println(response);
	}

	//Check if admin is able to delete the program batch for a Admin
	@When("Admin creates DELETE Request to delete Admin assigned to programbatch by AdminId")
	public void Admin_sends_HTTPS_DeleteMapControllerRequest_WithAuth() {
		response = RestAssured.given().spec(RS.getReq(URLs.deleteuserRoleProgramBatchMap+ "/U425")).when().delete();
	} 
	
	//Check if admin is able to delete the program batch for a invalid Admin
	@When("Admin creates DELETE Request to delete Admin assigned to programbatch by invalid AdminId")
	public void Admin_sends_HTTPS_DeleteMapControllerRequest_WithInvalidId() {
		response = RestAssured.given().spec(RS.getReq(URLs.deleteuserRoleProgramBatchMap+ "/0001")).when().delete();
	}
	//Check if admin is able to delete the program batch for valid Admin and No Authorization
	@When("Admin creates DELETE Request to delete Admin assigned to programbatch by valid AdminId NoAuth")
	public void Admin_sends_HTTPS_DeleteMapControllerRequest_validId_NoAuth() {
		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.deleteuserRoleProgramBatchMap+ "/U425")).when().delete();
	} 
}
