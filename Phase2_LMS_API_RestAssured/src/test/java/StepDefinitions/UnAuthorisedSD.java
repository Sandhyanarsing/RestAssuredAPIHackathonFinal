package StepDefinitions;

import static io.restassured.RestAssured.given;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UnAuthorisedSD {
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	
@Given("admin sets Authoization token to No Auth.")
	public void admin_sets_authoization_token_to_no_auth() {
	 given().auth().none();
	}

@Given("User creates POST batch request for the LMS API endpoint without Authorization_noAuth")
	public void user_creates_post_batch_request_for_the_lms_api_endpoint_without_authorization() {
  
}

@When("User sends HTTP post request for batch and request body with endpoint and no authorized token_noAuth")
	public void user_sends_http_post_request_for_batch_and_request_body_with_endpoint_and_no_authorized_token() {
 
}

@Then("Admin receives {int} Status code without batch response body_noAuth.")
	public void admin_receives_status_code_without_batch_response_body(Integer int1) {
  
}
@Given("Admin creates GET Request_noAuth")
public void admin_creates_get_request() {
   
}


@Given("Admin creates GET Request with valid Batch ID_noAuth")
public void admin_creates_get_request_with_valid_batch_id() {

}

@Given("Admin creates GET Request with batch Name_noAuth")
public void admin_creates_get_request_with_batch_name() {
  
}

@Given("Admin creates GET Request with program id_noAuth")
public void admin_creates_get_request_with_program_id() {
   
}
@When("Admin sends HTTPS Request with endpoint_noAuth")
public void admin_sends_https_request_with_endpoint() {
 
}

@Then("Admin receives {int} status with error message Unauthorized_noAuth")
public void admin_receives_status_with_error_message_unauthorized(Integer int1) {
   
}

@Given("Admin creates PUT Request with valid BatchId and Data_noAuth")
public void admin_creates_put_request_with_valid_batch_id_and_data() {
   
}

@When("Admin sends HTTPS PUT Request  with endpoint_noAuth")
public void admin_sends_https_put_request_with_endpoint() {

}

@Then("Admin receives {int} unauthorized_noAuth")
public void admin_receives_unauthorized(Integer int1) {
 
}

@Given("Admin creates DELETE Request with valid BatchId without authorization_noAuth")
public void admin_creates_delete_request_with_valid_batch_id() {

}
@When("Admin sends delete HTTPS Request with endpoint_noAuth")
public void admin_sends_delete_https_request_with_endpoint_no_auth() {
 
}
@Then("Admin receives {int} Unauthorized Status_noAuth")
public void admin_receives_unauthorized_status(Integer int1) {

}




}
