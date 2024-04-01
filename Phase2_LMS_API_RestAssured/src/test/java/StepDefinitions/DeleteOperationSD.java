package StepDefinitions;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;

public class DeleteOperationSD {
	
	Response response;
	
    RequestSpec RS = new RequestSpec();
    Authorization auth = new Authorization();
    String userID;
	
	@Given("Admin creates DELETE Request to delete Admin details")
	public void admin_creates_delete_request_to_delete_admin_details() {
		userID = auth.setUserID();
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details forUserModule")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details_forUserModule() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.DeleteUser))
		 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
		 		   .when().delete();
		response.then().log().all();
	}

	@Then("Admin receives {int} Ok status with message forUserModule")
	public void admin_receives_ok_status_with_message_forUserModule(Integer int1) {
	    response.then().statusCode(200);
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details with Inv AdminID forUserModule")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details_with_inv_admin_id_forUserModule() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.DeleteUser))
		 		   .pathParam("userID","Abc")
		 		   .when().delete();
		response.then().log().all();
	}

}
