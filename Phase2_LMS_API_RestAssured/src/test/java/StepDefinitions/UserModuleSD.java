package StepDefinitions;

import EndPoints.URLs;
import TestRequest.RequestSpec;
//import TokenRetreiver.Authorization;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserModuleSD {

	String requestBody;
	public static  String token;
	Response response;
	RequestSpec RS = new RequestSpec();


	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {

	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.AdminwthAllRoles))
				.when().get();
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		response.then().log().all().statusCode(200);


	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.InvalidendPoint))
				.param("roleId","R02")
				.when().get();
	}

	@Then("Admin receives status {int} with Not Found error message")
	public void admin_receives_status_with_not_found_error_message(Integer int1) {
		response.then().log().all().statusCode(404);
	}

	@When("Admin sends HTTPS Request with the appropriate endpoint and filters")
	public void admin_sends_https_request_with_the_appropriate_endpoint_and_filters() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.RoleIDV2))
				.when().get();
	}

	@Then("Admin receives {int} OK Status indicating a successful request with filtered results")
	public void admin_receives_ok_status_indicating_a_successful_request_with_filtered_results(Integer int1) {
		response.then().log().all().statusCode(200);
	}

	@When("Admin sends HTTPS Request with the appropriate invalid endpoint and filters")
	public void admin_sends_https_request_with_the_appropriate_invalid_endpoint_and_filters() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.RoleIDV2Invalid))
				.when().get();

	}

	@Then("Admin receives status {int} with Not Found error message for all Admin with filters")
	public void admin_receives_status_with_not_found_error_message_for_all_admin_with_filters(Integer int1) {
		response.then().log().all().statusCode(404);
	}

	@Given("Admin creates GET Request for all active admins")
	public void admin_creates_get_request_for_all_active_admins() {
	}

	@When("Admin sends HTTPS Request with endpoint for all active admins")
	public void admin_sends_https_request_with_endpoint_for_all_active_admins() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetAllActiveUsers))
				.when().get();

	}

	@Then("Admin receives {int} OK for all active admins")
	public void admin_receives_ok_for_all_active_admins(Integer int1) {
		response.then().log().all().statusCode(200);
		//token = response.jsonPath().getString("token");

	}

	@When("Admin sends HTTPS Request with invalid endpoint for all active admins")
	public void admin_sends_https_request_with_invalid_endpoint_for_all_active_admins() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetAllActiveUsersIVEndpoint))
				.when().get();
	}

	@Then("Admin receives status {int} with Not Found error message for all active admins")
	public void admin_receives_status_with_not_found_error_message_for_all_active_admins(Integer int1) {
		response.then().log().all().statusCode(404);
	}

	@When("Admin sends HTTPS Request with endpoint for all type of users")
	public void admin_sends_https_request_with_endpoint_for_all_type_of_users() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.AllTypeofUsers))
				.when().get();

	}

	@Then("Admin  receices {int} OK for all type of users")
	public void admin_receices_ok_for_all_type_of_users(Integer int1) {
		response.then().log().all().statusCode(200);

	}
	@When("Admin sends HTTPS Request with invalid endpoint for all type of users")
	public void admin_sends_https_request_with_invalid_endpoint_for_all_type_of_users() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.AllTypeofUsersInValid))
				.when().get();
	}
	@Given("Admin creates GET Request with role id")
	public void admin_creates_get_request_with_role_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.AllTypeofUsersRollID))
				.param("roleId","R01")
				.when().get();

	}

	@Then("Admin receices {int} OK for active and inactive admins by role id")
	public void admin_receices_ok_for_active_and_inactive_admins_by_role_id(Integer int1) {
		response.then().log().all().statusCode(200);

	}

	@Given("Admin creates GET Request with invalid role id")
	public void admin_creates_get_request_with_invalid_role_id() {

	}

	@When("Admin sends HTTPS Request with  active and inactive invalid endpoint")
	public void admin_sends_https_request_with_active_and_inactive_invalid_endpoint() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetAllActiveUsersIVEndpoint))
				.when().get();

	}

	@Then("Admin receices {int} OK for active and incative admins by role ID")
	public void admin_receices_ok_for_active_and_incative_admins_by_role_id(Integer int1) {
		response.then().log().all().statusCode(404);

	}
	@Given("Admin creates GET Request with valid batch Id")
	public void admin_creates_get_request_with_valid_batch_id() {


	}

	@When("Admin sends HTTPS Request with endpoint with valid batchID")
	public void admin_sends_https_request_with_endpoint_with_valid_batch_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetProgramBatches))
				.pathParam("Id","8432")
				.when().get();

	}

	@Then("Admin receives a response with status code {int} OK")
	public void admin_receives_a_response_with_status_code_ok(Integer int1) {

		response.then().log().all().statusCode(200);

	}

	@Given("Admin creates GET Request  with invalid batchId")
	public void admin_creates_get_request_with_invalid_batch_id() {
	}

	@When("the Admin sends a GET Request with an invalid batchId to the endpoint")
	public void the_admin_sends_a_get_request_with_an_invalid_batch_id_to_the_endpoint() {

		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetProgramBatchesInVBatchID))
				.when().get();
	}

	@Then("the Admin should receive a {int} Not Found response")
	public void the_admin_should_receive_a_not_found_response(Integer int1) {
		response.then().log().all().statusCode(404);

	}
	@Given("Admin creates GET Request with valid batch Id with invalid endpoint")
	public void admin_creates_get_request_with_valid_batch_id_with_invalid_endpoint() {
	}

	@When("Admin sends HTTPS Request with endpoint with valid batchID with invalid endpoint")
	public void admin_sends_https_request_with_endpoint_with_valid_batch_id_with_invalid_endpoint() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.ValidBatchIDandInvalidEndpoint))
				.pathParam("Id","8432")
				.when().get();

	}

	@Then("Admin receives a response with status code {int} Not Found response")
	public void admin_receives_a_response_with_status_code_not_found_response(Integer int1) {
		response.then().log().all().statusCode(404);
	}
	@Given("Admin creates GET Request with valid program Id")
	public void admin_creates_get_request_with_valid_program_id() {

	}

	@When("Admin sends HTTPS Request with endpoint for valid program Id")
	public void admin_sends_https_request_with_endpoint_for_valid_program_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.ValidProgramID))
				.pathParam("programId","16363")
				.when().get();
	}   
	@Given("Admin creates GET Request with invalid program Id")
	public void admin_creates_get_request_with_invalid_program_id() {


	}

	@When("Admin sends HTTPS Request with endpoint invalid program Id")
	public void admin_sends_https_request_with_endpoint_invalid_program_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.InValidProgramID))
				.pathParam("programId","1636")
				.when().get();
	}
	@When("Admin sends HTTPS Request with invalid endpoint and valid program Id")
	public void admin_sends_https_request_with_invalid_endpoint_and_valid_program_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.ValidProgIDWthInvalidEndpoint))
				.pathParam("programId","16363")
				.when().get();

	}
	@Given("Admin creates GET Request with valid role ID")
	public void admin_creates_get_request_with_valid_role_id() {

	}

	@When("Admin sends HTTPS Request with endpoint with valid role ID")
	public void admin_sends_https_request_with_endpoint_with_valid_role_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetUserByRoleID))
				.pathParam("roleId","R01")
				.when().get();
	}
	@Given("Admin creates GET Request for GET with invalid role ID")
	public void admin_creates_get_request_for_get_with_invalid_role_id() {
	}

	@When("Admin sends HTTPS Request with endpoint and invalid role ID")
	public void admin_sends_https_request_with_endpoint_and_invalid_role_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.GetUserByInvalidRoleID))
				.pathParam("roleId","R04")
				.when().get();

	}

	@Given("Admin creates GET Request with valid role ID and invalid endpoint")
	public void admin_creates_get_request_with_valid_role_id_and_invalid_endpoint() {
    }

	@When("Admin sends HTTPS Request with invalid endpoint and valid roleID")
	public void admin_sends_https_request_with_invalid_endpoint_and_valid_role_id() {
		response = RestAssured
				.given()
				.spec(RS.createReq(URLs.InvalidEndpointwthValidRoleID))
				.pathParam("roleId","R01")
				.when().get();
    }
}
