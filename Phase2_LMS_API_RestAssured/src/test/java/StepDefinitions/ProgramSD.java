package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
	String retrievedtoken;
	
	
	@Given("Admin sets Authorization")
	public void admin_sets_authorization() {
		auth.setAuthorisation();
	}

	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet2");
		System.out.println(data);
		
		
		
				 
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		
		for(int i=0; i<data.size();i++) {
			 requestBody = "{\n" +
                   "  \"programDescription\": \"" + data.get(i).get("programDescription") + "\",\n" +
                   "  \"programName\": \"" + data.get(i).get("programName") + "\",\n" +
                   "  \"programStatus\": \"" + data.get(i).get("programStatus") + "\"\n" +
                   "}";
			//System.out.println(requestBody);
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   .body(requestBody)
	    		   .when().post();
		
		responses.add(response);
		
		}
	}

	@Then("Admin receives appropriate Status code with response body.")
	public void admin_receives_appropriate_status_code_with_response_body()  {
		for (Response response : responses) {
            response.then().log().all();
            //response.then().statusCode(201);
            if(response.statusCode()==201) {
            	System.out.println("sucess");
            }else if(response.statusCode()==400) {
            	System.out.println("failure");
            }
        }
	}

}
