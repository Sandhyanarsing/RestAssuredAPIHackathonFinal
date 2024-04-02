package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;
import payloads.payload;

public class DeleteOperationSD {

	String token;
	Authorization auth = new Authorization();
	public String programId;
	public String programName;
	public String batchId;
	public String batchName;
	RequestSpec RS = new RequestSpec();
	String userID;
	String requestBody;
	Response response;
	List<Map<String, String>> data;
	List<Response> responses = new ArrayList<>();
	String retrievedtoken;

//		@Given("Admin sets Authorization Token for Delete Batch")
//		public void admin_sets_authorization_token_for_delete_batch() {
//			auth.getAuthorisation();
//		}

	@When("Admin sends HTTPS Request and  request Body with endpoint with invalid programNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_invalid_program_namepm() {

		// programName = auth.setPMProgramName();
		response = RestAssured.given().spec(RS.createReq(URLs.Invalidprogramname)).when().delete();
	}

	@Then("Admin receives appropriate Status code with response body with invalid pname&idpm")
	public void admin_receives_appropriate_status_code_with_response_body_with_invalid_pname_idpm() {
		response.then().statusCode(404);
		System.out.println(response.getBody().asString());
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with invalid programIDpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_invalid_program_idpm() {

		response = RestAssured.given().spec(RS.createReq(URLs.Invalidprogramid))

				.when().delete();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with valid programIDpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_valid_program_id() {
		// programID =auth.setPMProgramID();
		response = RestAssured.given().spec(RS.createReq(URLs.GetProgramByProgramId))
				.pathParam("programId", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY)).when()
				.delete();
	}

	@Then("Admin receives appropriate Status code with response body with valid pname&idpm")
	public void admin_receives_appropriate_status_code_with_response_body_with_valid_pname_idpm() {
		if (response.statusCode() == 200) {
			System.out.println(response.getBody().asString());
			// Authorization.scenarioContext.setContext(LMSConstants.PROGRAMID_KEY,
			// programId);
		}
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with valid programNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_valid_program_namepm() {

		response = RestAssured.given()
				// .header("Authorization", "Bearer "+ auth.setAuthorisation())
				.spec(RS.createReq(URLs.UpdateProgramByProgramName))
				.pathParam("programName", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY))

				.when().delete();
	}

//	@Given("Admin creates delete Request with valid BatchId")
//	public void admin_creates_delete_request_with_valid_batch_id() {
//	   
//	}
//
//	@When("Admin sends deletebatch HTTPS Request with endpoint")
//	public void admin_sends_deletebatch_https_request_with_endpoint() {
//	 
//	}
//
//	@Then("Admin receives {int} Ok status with message {string}")
//	public void admin_receives_ok_status_with_message(Integer int1, String string) {
//	  
//	}
//
//	@Given("Admin creates DELETE batch Request with valid BatchId")
//	public void admin_creates_delete_batch_request_with_valid_batch_id() {
//	    
//	}
//
//	@When("Admin sends delete HTTPS Request  with invalid endpoint")
//	public void admin_sends_delete_https_request_with_invalid_endpoint() {
//	 
//	}
//
//	@When("Admin sends HTTPS Request  with endpoint")
//	public void admin_sends_https_request_with_endpoint() {
//	   	}
//
//	@Then("Admin receives {int} Ok status with message")
//	public void admin_receives_ok_status_with_message(Integer int1) {
//	    
//	}
//
//	@Given("Admin creates DELETE Request with invalid BatchId")
//	public void admin_creates_delete_request_with_invalid_batch_id() {
//	   
//	}
//
//	@Then("Admin receives {int} Not Found Status with message and boolean success details")
//	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
//	 
//	}
//	@Given("Admin creates GET Request with batch Name after deletion of batchID")
//	public void admin_creates_get_request_with_batch_name_after_deletion_of_batch_id() {
//	    
//	}
//
//	@When("Admin sends delete HTTPS Request with endpoint after deletion of batchID")
//	public void admin_sends_delete_https_request_with_endpoint_after_deletion_of_batch_id() {
//	
//	}
//
//	@When("Admin sends HTTPS DELETE Request  with endpoint after deletion of programID")
//	public void admin_sends_https_delete_request_with_endpoint_after_deletion_of_program_id() {
//	
//	}
//
//	@Then("Admin receives {int} unauthorized after deletion of programID")
//	public void admin_receives_unauthorized_after_deletion_of_program_id(Integer int1) {
//	   
//	}
//
//	@Given("Admin creates PUT Request with Valid batch Id after deletion of programID")
//	public void admin_creates_put_request_with_valid_batch_id_after_deletion_of_program_id() {
//	  
//	}
//
//	@When("Admin sends HTTPS Request  with endpoint after deletion of programID")
//	public void admin_sends_https_request_with_endpoint_after_deletion_of_program_id() {
//	  
//	}
//
//	@Then("Admin receives {int} Bad Request Status with message and boolean success details after deletion of programID")
//	public void admin_receives_bad_request_status_with_message_and_boolean_success_details_after_deletion_of_program_id(Integer int1) {
//	 
//	}
//
//	@Given("Admin creates PUT Request with Valid batch Id after deletion of batchID")
//	public void admin_creates_put_request_with_valid_batch_id_after_deletion_of_batch_id() {
//	   
//	}
//
//	@When("Admin sends HTTPS Request  with endpoint after deletion of batchID")
//	public void admin_sends_https_request_with_endpoint_after_deletion_of_batch_id() {
//	
//	}
//
//	@Then("Admin receives {int} Ok status with message after deletion of batchID")
//	public void admin_receives_ok_status_with_message_after_deletion_of_batch_id(Integer int1) {
//	   
//  }	

	@Given("Admin creates DELETE Request to delete Admin details forUserModule")
	public void admin_creates_delete_request_to_delete_admin_details_forUserModule() {
		// userID = auth.setUserID();
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details forUserModule")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details_forUserModule() {
		response = RestAssured.given().spec(RS.createReq(URLs.DeleteUser))
				.pathParam("userID", Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY)).when().delete();
		response.then().log().all();
	}

	@Then("Admin receives {int} Ok status with message forUserModule")
	public void admin_receives_ok_status_with_message_forUserModule(Integer int1) {
		response.then().statusCode(200);
	}

	@When("Admin sends HTTPS request with endpoiint to delete Admin details with Inv AdminID forUserModule")
	public void admin_sends_https_request_with_endpoiint_to_delete_admin_details_with_inv_admin_id_forUserModule() {
		response = RestAssured.given().spec(RS.createReq(URLs.DeleteUser)).pathParam("userID", "Abc").when().delete();
		response.then().log().all();
	}

	@Given("Admin creates delete Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {

	}

	@When("Admin sends deletebatch HTTPS Request with endpoint")
	public void admin_sends_deletebatch_https_request_with_endpoint() {

		response = RestAssured.given().spec(RS.createReq(URLs.deleteBatch))
				.pathParam("id", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when().delete();

	}

	@Then("Admin receives {int} Ok status with message {string}")
	public void admin_receives_ok_status_with_message(Integer int1, String string) {
		response.then().statusCode(200).log().all();
		String statusline = response.statusLine();
		LoggerLoad.info(statusline);

		if (response.statusCode() == 200) {
			System.out.println("sucess");
			// batchId =response.jsonPath().getString("batchId");
			// Authorization.scenarioContext.setContext(LMSConstants.BATCHID_KEY, batchId);
		} else if (response.statusCode() == 400) {
			System.out.println("failure");
		}

	}

	@Given("Admin creates DELETE batch Request with valid BatchId")
	public void admin_creates_delete_batch_request_with_valid_batch_id() {

	}

	@When("Admin sends delete HTTPS Request  with invalid endpoint")
	public void admin_sends_delete_https_request_with_invalid_endpoint() {
		response = RestAssured.given().spec(RS.createReq(URLs.deleteBatchInvalidEP))
				.pathParam("id", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when().delete();

	}

	@Then("Admin receives {int} not found")
	public void admin_receives_not_found(Integer int1) {
		response.then().statusCode(404).log().all();
	}

//	@Then("Admin receives {int} Ok status with message")
//	public void admin_receives_ok_status_with_message(Integer int1) {
//		response.then().statusCode(404).log().all();
//	}

	@Given("Admin creates DELETE Request with invalid BatchId")
	public void admin_creates_delete_request_with_invalid_batch_id() {

	}

	@When("Admin sends HTTPS Request  with endpoint")
	public void admin_sends_https_request_with_endpoint1() {
		response = RestAssured.given().spec(RS.createReq(URLs.deleteBatch)).pathParam("id", LMSConstants.INVALIDBATCHID)
				.when().delete();

	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		response.then().statusCode(404).log().all();

	}

	@Given("Admin creates GET Request with valid Batch ID")
	public void admin_creates_get_request_with_valid_batch_id() {

	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		response = RestAssured.given().spec(RS.createReq(URLs.GetbyBatchID))
				.pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when().get();

	}

	@Given("Admin creates GET Request with batch Name after deletion of batchID")
	public void admin_creates_get_request_with_batch_name_after_deletion_of_batch_id() {

	}

	@When("Admin sends delete HTTPS Request with endpoint after deletion of batchID")
	public void admin_sends_delete_https_request_with_endpoint_after_deletion_of_batch_id() {
		response = RestAssured.given().spec(RS.createReq(URLs.GetbyBatchName))
				.pathParam("batchName", Authorization.scenarioContext.getContext(LMSConstants.BATCHNAME_KEY)).when()
				.get();
	}

	@Then("Admin receives {int} OK Status with  batchStatus field {string} in the response body.")
	public void admin_receives_ok_status_with_batch_status_field_in_the_response_body(Integer int1, String string) {
		response.then().statusCode(200).log().all();
	}

	@When("Admin sends HTTPS DELETE Request  with endpoint after deletion of programID")
	public void admin_sends_https_delete_request_with_endpoint_after_deletion_of_program_id() {
		response = RestAssured.given().spec(RS.createReq(URLs.GetBatchbyProgramID))
				.pathParam("programId", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY)).when()
				.get();
	}

	@Then("Admin receives {int} unauthorized after deletion of programID")
	public void admin_receives_unauthorized_after_deletion_of_program_id(Integer int1) {
		response.then().statusCode(200).log().all();
	}

	@Given("Admin creates PUT Request with Valid batch Id after deletion of programID")
	public void admin_creates_put_request_with_valid_batch_id_after_deletion_of_program_id()
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		data = ExcelReader.getData(URLs.ExcelPath, "BatchRequest");
	}

	@When("Admin sends HTTPS Request  with endpoint after deletion of programID")
	public void admin_sends_https_request_with_endpoint_after_deletion_of_program_id() {
		for (int i = 0; i < data.size(); i++) {
			if (i == 1) {
				break;
			}
			String requestBody = payload.PutBatchReqBody_Postbatchdelete(data, i);
			response = RestAssured.given()
					// .header("Authorization", "Bearer "+ auth.getAuthorisation())
					.spec(RS.createReq(URLs.updateBatch)).body(requestBody)
					.pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when()
					.put();
		}
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details after deletion of programID")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details_after_deletion_of_program_id(
			Integer int1) {
		response.then().statusCode(400).log().all();
	}

	@Given("Admin creates PUT Request with Valid batch Id after deletion of batchID")
	public void admin_creates_put_request_with_valid_batch_id_after_deletion_of_batch_id()
			throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		data = ExcelReader.getData(URLs.ExcelPath, "BatchRequest");
	}

	@When("Admin sends HTTPS Request  with endpoint after deletion of batchID")
	public void admin_sends_https_request_with_endpoint_after_deletion_of_batch_id() {
		for (int i = 0; i < data.size(); i++) {
			if (i == 1) {
				break;
			}
			String requestBody = payload.PutBatchReqBody_Postbatchdelete(data, i);

			response = RestAssured.given()
					// .header("Authorization", "Bearer "+ auth.getAuthorisation())
					.spec(RS.createReq(URLs.updateBatch)).body(requestBody)
					.pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when()
					.put();
		}
	}

	@Then("Admin receives {int} Ok status with message after deletion of batchID")
	public void admin_receives_ok_status_with_message_after_deletion_of_batch_id(Integer int1) {
		response.then().statusCode(400).log().all();
	}
}
