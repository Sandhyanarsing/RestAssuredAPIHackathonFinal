package StepDefinitions;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.payload;

public class UnAuthorisedSD {
	
	Response response;
	String requestBody;
	RequestSpec RS = new RequestSpec();
	
	
	@When("Admin sends HTTPS Request to create users with endpoint with no auth forUserModule")
	public void admin_sends_https_request_to_create_users_with_endpoint_with_no_auth_forUserModule() {
		 //requestBody = payload.UserRequestBody(data2,i);
		
	    response = RestAssured
    		   .given()
    		   .spec(RS.NoAuthMethod(URLs.createUser))
    		   .body(payload.DummyRequestBody())
    		   .when().post();
	    
	}

	@When("Admin sends HTTPS Request with GET All Roles endpoint with no auth forUserModule")
	public void admin_sends_https_request_with_get_all_roles_endpoint_with_no_auth_forUserModule() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.NoAuthMethod(URLs.getAllRoles))
		 		   .when().get();
	}
	
	@Then("Admin receives status {int} with Unauthorized message forUserModule")
	public void admin_receives_status_with_unauthorized_message_forUserModule(Integer int1) {
	    response.then().statusCode(401);
	}

}
