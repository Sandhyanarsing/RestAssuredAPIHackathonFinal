package StepDefinitions;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;

	import EndPoints.URLs;
	import TestRequest.RequestSpec;
	import TokenRetreiver.Authorization;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;

	public class DeleteOperationSD {
		
		String token ;
		Authorization auth = new Authorization();
		
		//ExcelReader ER = new ExcelReader();
		String requestBody;
		Response response;
		RequestSpec RS = new RequestSpec();
		List<Map<String, String>>data;
		List<Response> responses = new ArrayList<>();
		String retrievedtoken;
		String programId ;
		String programName;
	
	
	@When("Admin sends HTTPS Request and  request Body with endpoint with invalid programNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_invalid_program_namepm() {
		
		//programName = auth.setPMProgramName();
		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.Invalidprogramname))
	    		   .when().delete();
	}

	@Then("Admin receives appropriate Status code with response body with invalid pname&idpm")
	public void admin_receives_appropriate_status_code_with_response_body_with_invalid_pname_idpm() {
		response.then().statusCode(404);
	    System.out.println(response.getBody().asString());
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with invalid programIDpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_invalid_program_idpm() {
		
		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.Invalidprogramid))
	    		   
	    		   .when().delete();
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with valid programIDpm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_valid_program_id() {
		//programID =auth.setPMProgramID();
		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.GetProgramByProgramId))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   .when().delete();
	}

	@Then("Admin receives appropriate Status code with response body with valid pname&idpm")
	public void admin_receives_appropriate_status_code_with_response_body_with_valid_pname_idpm() {
		if(response.statusCode()==200){
	    System.out.println(response.getBody().asString());
	    //Authorization.scenarioContext.setContext(LMSConstants.PROGRAMID_KEY, programId);
		}
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with valid programNamepm")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_valid_program_namepm() {
	
	
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.UpdateProgramByProgramName))
	    		   .pathParam("programName",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY))
	    		   
	    		   .when().delete();
	}
	}