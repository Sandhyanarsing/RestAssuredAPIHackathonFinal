package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProgramSD {
	String token ;
	Authorization auth = new Authorization();
	//ExcelTestData ExcelData = new ExcelTestData();
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>>data;
	List<Response> responses = new ArrayList<>();
	List<String> programIDs = new ArrayList<>();
	String retrievedtoken;
	int pID;
	String pNM;
	String parsedPID;
	String programID ;
	String programName;
	
	
	@Given("Admin sets Authorization")
	public void admin_sets_authorization() {
		auth.setAuthorisation();
	}

	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet3");
		}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		
		for(int i=0; i<data.size();i++) {
			 requestBody = "{\n" +
                   "  \"programDescription\": \"" + data.get(i).get("programDescription") + "\",\n" +
                   "  \"programName\": \"" + data.get(i).get("programName") + "\",\n" +
                   "  \"programStatus\": \"" + data.get(i).get("programStatus") + "\"\n" +
                   "}";
			
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   .body(requestBody)
	    		   .when().post();
		
		if(response.statusCode()==201) {
        	System.out.println("sucess");
        	responses.add(response);
        	//JSONObject jsonObject = new JSONObject(response);
        	pID = response.jsonPath().getInt("programId");
        	pNM = response.jsonPath().getString("programName");
        	
        }else if(response.statusCode()==400) {
        	System.out.println("failure");
        }
		 }
	System.out.println(pID);
	System.out.println(pNM);
	 parsedPID = String.valueOf(pID);
	 programID = Authorization.scenarioContext.setContext("programID", parsedPID);
	 programName = Authorization.scenarioContext.setContext("programName", pNM);
		
		}
	

	@Then("Admin receives appropriate Status code with response body.")
	public void admin_receives_appropriate_status_code_with_response_body()  {
		
		 for (Response response : responses) {
				response.then().log().all();
				}
            
	}
	
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {
		 programID =auth.setPMProgramID();
		 programName = auth.setPMProgramName();
		System.out.println(programID);
		System.out.println(programName);
	}

	@When("Admin sends HTTPS Request with endpoint in PM")
	public void admin_sends_https_request_with_endpoint_in_PM() {
//		String programId = data.get("programId")!=null && data.get("programId").equlas("") ? Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY);
		System.out.println(programID);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.GetProgramByProgramId))
	    		   .pathParam("programId",programID)
	    		   //.body(requestBody)-
	    		   .when().get();
		
		response.then().log().all();
	}

	@Then("Admin receives Status with response body.")
	public void admin_receives_status_with_response_body() {
	    response.then().statusCode(200);
	    System.out.println(response.getBody().asString());

}
}
