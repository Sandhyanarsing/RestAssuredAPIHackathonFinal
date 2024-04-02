package StepDefinitions;

import static io.restassured.RestAssured.given;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;
import payloads.payload;

public class UnAuthorisedSD {

	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();

	@Given("admin sets Authoization token to No Auth.")
	public void admin_sets_authoization_token_to_no_auth() {
		given().auth().none();
	}

	@When("Admin sends HTTPS Request to create users with endpoint with no auth forUserModule")
	public void admin_sends_https_request_to_create_users_with_endpoint_with_no_auth_forUserModule() {
		response = RestAssured.given().spec(RS.NoAuthMethod(URLs.createUser)).body(payload.DummyRequestBody()).when()
				.post();
	}


	@When("Admin sends HTTPS Request with GET All Roles endpoint with no auth forUserModule")
	public void admin_sends_https_request_with_get_all_roles_endpoint_with_no_auth_forUserModule() {
		response = RestAssured.given().spec(RS.NoAuthMethod(URLs.getAllRoles)).when().get();
	}

	@Then("Admin receives status {int} with Unauthorized message forUserModule")
	public void admin_receives_status_with_unauthorized_message_forUserModule(Integer int1) {
		response.then().statusCode(401);
	}

	@Given("User creates POST batch request for the LMS API endpoint without Authorization")
	public void user_creates_post_batch_request_for_the_lms_api_endpoint_without_authorization() {
	}

	@When("User sends HTTP post request for batch and request body with endpoint and no authorized token")
	public void user_sends_http_post_request_for_batch_and_request_body_with_endpoint_and_no_authorized_token() {
		String requestBody = payload.BatchReqBody_Standard();
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.createBatch)).body(requestBody).when().post();

	}

	@Then("Admin receives {int} Status code without batch response body.")
	public void admin_receives_status_code_without_batch_response_body(Integer int1) {
		response.then().statusCode(401);
	}

	@Given("Admin creates GET Request_noAuth")
	public void admin_creates_get_request_no_auth() {
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.GetallBatch))
				// .pathParam("batchId",
				// Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
				.when().get();

	}

	@Given("Admin creates GET Request with batch Name_noAuth")
	public void admin_creates_get_request_with_batch_name() {
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.GetbyBatchName))
				.pathParam("batchName", Authorization.scenarioContext.getContext(LMSConstants.BATCHNAME_KEY)).when()
				.get();

	}

	@Given("Admin creates GET Request with program id_noAuth")
	public void admin_creates_get_request_with_program_id() {
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.GetBatchbyProgramID))
				.pathParam("programId", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY)).when()
				.get();

	}

	@Given("Admin creates GET Request with valid Batch ID_noAuth")
	public void admin_creates_get_request_with_valid_batch_id_no_auth() {
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.GetbyBatchID))
				.pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when().get();

	}

	@When("Admin sends HTTPS Request with endpoint_noAuth_batch")
	public void admin_sends_https_request_with_endpoint_no_auth_batch() {

	}

	@When("Admin sends HTTPS Request with endpoint_noAuth")
	public void admin_sends_https_request_with_endpoint() {

	}

	@Then("Admin receives {int} status with error message Unauthorized.")
	public void admin_receives_status_with_error_message_unauthorized(Integer int1) {
		response.then().statusCode(401);
	}

	@Given("Admin creates PUT Request with valid BatchId and Data_noAuth")
	public void admin_creates_put_request_with_valid_batch_id_and_data() {

	}

	@When("Admin sends HTTPS PUT Request  with endpoint_noAuth")
	public void admin_sends_https_put_request_with_endpoint() {
		String requestBody = payload.BatchReqBody_Standard();

		response = RestAssured.given().spec(RS.createReq_noauth(URLs.updateBatch))
				.pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
				.body(requestBody).when().put();

	}

	@Then("Admin receives {int} unauthorized_noAuth")
	public void admin_receives_unauthorized(Integer int1) {
		response.then().statusCode(401);
	}

	@Given("Admin creates DELETE Request with valid BatchId without authorization_noAuth")
	public void admin_creates_delete_request_with_valid_batch_id() {

	}

	@When("Admin sends delete HTTPS Request with endpoint_noAuth")
	public void admin_sends_delete_https_request_with_endpoint_no_auth() {
		response = RestAssured.given().spec(RS.createReq_noauth(URLs.deleteBatch))
				.pathParam("id", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)).when().delete();

	}

	@Then("Admin receives {int} Unauthorized Status_noAuth")
	public void admin_receives_unauthorized_status(Integer int1) {
		response.then().statusCode(401);
	}

	@Given("Admin creates POST Request for the LMS with request body without Authpm")
	public void admin_creates_post_request_for_the_lms_with_request_body_without_authpm() {
	    
			 requestBody = payload.ProgramData_invalidreqbody();


	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Authpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_authpm() {
	   
		response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.createProgram))
	 		   .body(requestBody)
	 		   .when().post();
	}

	@Then("Admin receives appropriate Status code with response body without Authpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_authpm() {
	    response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by getpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_getpm() {
	    
		response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.GetAllPrograms))
	 		   .when().get();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by getpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_getpm() {
	   response.then().log().all();
	}

		@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by programidpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_programidpm() {
	    response = RestAssured
		   .given()
		   .spec(RS.createReq(URLs.GetProgramByProgramId))
		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	 	   .when().get();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by program idpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_program_idpm() {
	    response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by get all programpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_get_all_programpm() {
	    response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.GetAllProgramswithUsers))
	 		   //.body(requestBody)
	 		   .when().get();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by get all programpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_get_all_programpm() {
	    response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by updateProgramIDpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_update_program_idpm() {
	  response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateProgramByProgramId))
	 		  .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by updateProgramIDpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_update_program_idpm() {
	    response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by update ProgramNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_update_program_namepm() {
	    response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateProgramByProgramName))
	 		   .pathParam("programName",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by update ProgramNamepm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_update_program_namepm() {
	  response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programidpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_delete_programidpm() {
	    response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.DeleteProgramByProgramId))
	 		  .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	 		   .when().delete();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by delete programidpm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_delete_programidpm() {
	    response.then().log().all();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_without_auth_by_delete_program_namepm(){
	    response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.DeleteProgramByProgramName))
	 		  .pathParam("programName",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY))
	 		   .when().delete();
	}

	@Then("Admin receives appropriate Status code with response body without Auth by delete programNamepm")
	public void admin_receives_appropriate_status_code_with_response_body_without_auth_by_delete_program_namepm() {
	    response.then().log().all();
	}
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

	@When("Admin sends HTTPS Request with validAdminId and NoAuth")
	public void Admin_sends_HTTPS_Request_with_validAdminId_NoAuth() {

		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.getuserRoleProgramBatchMap + "/U425")).when().get();
		System.out.println(response);
	}
	@When("Admin creates DELETE Request to delete Admin assigned to programbatch by valid AdminId NoAuth")
	public void Admin_sends_HTTPS_DeleteMapControllerRequest_validId_NoAuth() {
		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.deleteuserRoleProgramBatchMap+ "/U425")).when().delete();
	}
	@When("Admin calls Get Https method with valid endpoint No Auth")
	public void Admin_sends_HTTPS_LogOutRequest_WithNoAuth() {

		response = RestAssured.given().spec(RS.getReq_NoAuth(URLs.userlogout)).when().get();
	}
	
	
	@Then("Verify {int} response displayed Logout")
	public void verify_response_displayed_logout(Integer int1) {
		// System.out.println(requestBody);
		response.then().statusCode(401);
	}
		
}