package StepDefinitions;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteOperationSD {
	
	Response response;
	
    RequestSpec RS = new RequestSpec();
	
	@Given("Admin creates DELETE Request to delete Admin details")
	public void admin_creates_delete_request_to_delete_admin_details() {
	   
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.DeleteUser))
		 		   .pathParam("userID","Abc")
		 		   .when().delete();
		response.then().log().all();
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
	    
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details with Inv AdminID")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details_with_inv_admin_id() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.DeleteUser))
		 		   .pathParam("userID","Abc")
		 		   .when().delete();
		response.then().log().all();
	}

}
