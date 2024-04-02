package StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;
import payloads.payload;
public class UNAuthorisedSD {
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>>data;
	List<Response> responses = new ArrayList<>();
	
	


@Given("Admin creates POST Request for the LMS with request body without Authpm")
public void admin_creates_post_request_for_the_lms_with_request_body_without_authpm() {
    int i=0;
		String requestBody = payload.ProgramData(data,i);


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
	   .spec(RS.createReq(URLs.createProgram))
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
 		   .body(requestBody)
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
 		   .spec(RS.createReq(URLs.GetProgramByProgramId))
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
 		   .spec(RS.createReq(URLs.createProgram))
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
}