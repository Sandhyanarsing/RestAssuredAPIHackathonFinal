package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;

import EndPoints.URLs;
import TestRequest.assertions;
import TestRequest.RequestSpec;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lmsApiConstants.LMSConstants;
import payloads.payload;

public class ProgramSD {
	
	String token ;
	Authorization auth = new Authorization();
	
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>>data;
	List<Response> responses = new ArrayList<>();
String retrievedtoken;	
String programId;
List<String> programIDs = new ArrayList<>();
String retrievedtoken;
String programName;
	
	
	@Given("Admin sets Authorization")
	public void admin_sets_authorization() {
		auth.setAuthorisation();
	}


	@Given("Admin creates POST Request for the LMS with request bodypm")
	public void admin_creates_post_request_for_the_lms_with_request_bodypm() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet2");
		System.out.println(data);
		
		
		
				 
	}


	@When("Admin sends HTTPS Request and  request Body with endpointpm")
	public void admin_sends_https_request_and_request_body_with_endpointpm() throws InvalidFormatException, IOException {
		
		for(int i=0; i<data.size();i++) {


			String requestBody = payload.ProgramData(data,i);

			 requestBody = "{\n" +
                   "  \"programDescription\": \"" + data.get(i).get("programDescription") + "\",\n" +
                   "  \"programName\": \"" + data.get(i).get("programName") + "\",\n" +
                   "  \"programStatus\": \"" + data.get(i).get("programStatus") + "\"\n" +
                   "}";
			
		

		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   .body(requestBody)
	    		   .when().post();
		if(response.statusCode()==201) {
        	
        	{
        		responses.add(response);
        		programId = response.jsonPath().getString("programId");
        		programName = response.jsonPath().getString("programName");
        	  	 Authorization.scenarioContext.setContext(LMSConstants.PROGRAMID_KEY, programId);
        	   	Authorization.scenarioContext.setContext(LMSConstants.PROGRAMNAME_KEY, programName);  	  
            	
        	}
        }else if(response.statusCode()==400) {
        	String Massage = response.getStatusLine();
        	LoggerLoad.info(Massage);

    	
}
      
 }
	}

	@Then("Admin receives appropriate Status code with response bodypm")
	public void admin_receives_appropriate_status_code_with_response_bodypm()  {
		for (Response response : responses) {
            response.then().log().all();
            
          }
		
            
	}

	@Given("Admin creates Request for the LMS with request bodypm")
	public void admin_creates_request_for_the_lms_with_request_bodypm() {
		
	}
	@When("Admin sends HTTPS Request and  request Body with invalidpm")
	public void admin_sends_https_request_and_request_body_with_invalidpm() throws InvalidFormatException, IOException {
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   
	    		   .spec(RS.createReq(URLs.GetProgramByProgramId))
	    		  .body(requestBody)
	    		  .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   .when().get();
		
	}

	@Then("Admin receives appropriate Status code with response body invalidpm")
	public void admin_receives_appropriate_status_code_with_response_body_invalidpm() {
		response.then().statusCode(405);
		response.then().log().all();
		

	}
	@Given("Admin creates POST Request for the LMS with request body and invalid endpointpm")
	public void admin_creates_post_request_for_the_lms_with_request_body_and_invalid_endpointpm() {

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

		
	}
	@When("Admin sends HTTPS Request and  request Body with invalid endpointpm")
	public void admin_sends_https_request_and_request_body_with_invalid_endpointpm() {
	
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   .body(requestBody)
	    		   .when().post();
		System.out.println(requestBody);
		
	}
	@Then("Admin receives appropriate Status code with response body invalidendpointpm")
	public void admin_receives_appropriate_status_code_with_response_body_invalidendpointpm() {
		response.then().statusCode(404);
		response.then().log().all();
		}
	


	@When("Admin sends HTTPS Request with endpointpm")
	public void admin_sends_https_request_with_endpointpm() {
//		programId =auth.setPMProgramID();
//		 //programName = auth.setPMProgramName();
		response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.GetProgramByProgramId))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   .when().get();
		
		response.then().log().all();
	}

	@Then("Admin receives Status with response bodypm")
	public void admin_receives_status_with_response_bodypm() {
	    response.then().statusCode(200);
	    System.out.println(response.getBody().asString());
	    
	}
	
	
	@Given("Admin creates GET Request for the LMS APIpm")
	public void admin_creates_get_request_for_the_lms_apipm() {
		//System.out.println(programID);
	}
@When("Admin sends HTTPS Request with invalid endpointpm")
public void admin_sends_https_request_with_invalid_endpointpm() {
	//programID =auth.setPMProgramID();
	 response = RestAssured
   		   .given()
   		   .spec(RS.createReq(URLs.InvalidEndPoint))
   		   .when().get();
	
	response.then().log().all(); 
}

@Then("Admin receives Status with response body with invalid endpointpm")
public void admin_receives_status_with_response_body_with_invalid_endpointpm() {
	response.then().statusCode(404);
    System.out.println(response.getBody().asString());
}
@When("Admin sends HTTPS Request with invalid programidpm")
public void admin_sends_https_request_with_invalid_programidpm() {
	//programID =auth.setPMProgramID();
	 //programName = auth.setPMProgramName();
	response = RestAssured
  		   .given()
  		   .spec(RS.createReq(URLs.Invalidprogramid))
  		   .when().get();
	
	response.then().log().all(); 
}

@Then("Admin receives Status with response body with invalid programidpm")
public void admin_receives_status_with_response_body_with_invalid_programidpm() {
	response.then().statusCode(404);
    System.out.println(response.getBody().asString());
}

	@Given("Admin creates GET Request for the LMS API with valid endpointpm")
	public void admin_creates_get_request_for_the_lms_api_with_valid_endpointpm() {
	   
	}

	@When("Admin sends HTTPS Request with valid enpointpm")
	public void admin_sends_https_request_with_valid_enpointpm() {
		
		response = RestAssured
	    		   .given()
	    		   
	    		   .spec(RS.createReq(URLs.GetAllPrograms))
	    		   //.pathParam("programId",ProgramID)
	    		   //.body(requestBody)-
	    		   .when().get();
		System.out.println(response);
		
	}
	
	
@Then("Admin receives appropriate Status code with response body inpm")
public void admin_receives_appropriate_status_code_with_response_body_inpm() {
	response.then().statusCode(404);
    System.out.println(response.getBody().asString());
}
	@Given("Admin creates GET Request for the LMS API with invalid endpointpm")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_endpointpm() {
	   
	}

	@When("Admin sends HTTPS Request with invalid enpointpm")
	public void admin_sends_https_request_with_invalid_enpointpm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   //.pathParam("programId",ProgramID)
	    		   //.body(requestBody)-
	    		   .when().get();
		
	}

	@Then("Admin receives Status with response body with invalid methodpm")
	public void admin_receives_status_with_response_body_with_invalid_methodpm() {
	  response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	   
	}
	@When("Admin sends HTTPS Request with invalid BaseUrlspm")
	public void  admin_sends_https_request_with_invalid_base_urlspm() {
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReqwithInvalidBaseurl(URLs.UpdateProgramByProgramId))
	    		   //.pathParam("programId",programID)
	    		  //.body(requestBody)
	    		   .when().get();

	}

	@Then("Admin receives Status with response body with invalid BaseUrlpm")
	public void admin_receives_status_with_response_body_with_invalid_base_urlpm() {
		response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}
	@Given("Admin creates GET Request for the LMS API with invalid baseurlpm")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_baseurlpm() {
	   
	}

	@When("Admin sends HTTPS Request with invalid baseurlpm")
	public void admin_sends_https_request_with_invalid_baseurlpm() {
		
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReqwithInvalidBaseurl(URLs.UpdateProgramByProgramId))
	    		   .when().put();
	}

	@Then("Admin receives appropriate Status code with response body inburlpm")
	public void admin_receives_appropriate_status_code_with_response_body_inburlpm() {
		response.then().statusCode(404);
	    System.out.println(response.getBody().asString());
	}

	@Given("Admin creates GET Request for the LMS API with invalid methodpm")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_methodpm() {
	    
	}

	@When("Admin sends HTTPS Request with invalid methodpm")
	public void admin_sends_https_request_with_invalid_methodpm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   //.pathParam("programId",ProgramID)
	    		    //.body(requestBody)
	    		   .when().post();
	    
	}
	@Then("Admin receives appropriate Status code with response body IMpm")
	public void admin_receives_appropriate_status_code_with_response_body_impm() {
		response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}
	@When("Admin sends HTTPS Request with invalidmethodpm") 
	public void admin_sends_https_request_with_invalidmethodpm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   //.pathParam("programId",ProgramID)
	    		    .body(requestBody)
	    		   .when().post();
	    
	}
	@When("Admin sends HTTPS Request with valid endpoint userspm")
	public void admin_sends_https_request_with_valid_endpoint_userspm() {
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.GetAllProgramswithUsers))
	    		   //.pathParam("programName",programName)
	    		   //.body(requestBody)-
	    		   .when().get();
	}

	@Then("Admin receives appropriate Status code with response body userspm")
	public void admin_receives_appropriate_status_code_with_response_body_userspm() {
		response.then().statusCode(200);
	    System.out.println(response.getBody().asString());
	}

	@When("Admin sends HTTPS Request with invalid endpoint userspm")
	public void admin_sends_https_request_with_invalid_endpoint_userspm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   //.pathParam("programId",ProgramID)
	    		   //.body(requestBody)-
	    		   .when().get();
	}

	@Then("Admin receives appropriate Status code with response body users invalid endpointpm")
	public void admin_receives_appropriate_status_code_with_response_body_users_invalid_endpointpm() {
		response.then().statusCode(404);
	    System.out.println(response.getBody().asString());
	}

	@When("Admin sends HTTPS Request with invalid method userspm")
	public void admin_sends_https_request_with_invalid_method_userspm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   //.pathParam("programId",ProgramID)
	    		   //.body(requestBody)-
	    		   .when().put();
	}
	@Then("Admin receives appropriate Status code with response body users invalid methodpm")
	public void admin_receives_appropriate_status_code_with_response_body_users_invalid_methodpm() {
		response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}
	
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fieldspm")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fieldspm() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "Sheet2");
	}

	@When("Admin sends HTTPS Request with valid endpoint updatepm")
	public void admin_sends_https_request_with_valid_endpoint_updatepm() throws InvalidFormatException, IOException {
		for(int i=0; i<data.size();i++) {
			String requestBody = payload.UpdateProgramData(data,i);
		System.out.print(requestBody);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.UpdateProgramByProgramName))
	    		   .pathParam("programName",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY, programName))
	    		   .body(requestBody)
	    		   .when().put();
		if(response.statusCode()==200) {
			{
        	//assertions asserts = new assertions(response);
        	//asserts.assertProgramModule();
        	
        	}
        }else if(response.statusCode()==400) {
        	String Massage = response.getStatusLine();
        	LoggerLoad.info(Massage);
        	
}

	  
    }
		
		
	
		
		}
	

	@Then("Admin receives Status with updated value in response bodypm")
	public void admin_receives_status_with_updated_value_in_response_bodypm() {
		for (Response response : responses) {
            response.then().log().all();
            
        }
       }
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with invalid methodpm")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_invalid_methodpm() {}
	    
	


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
    @When("Admin sends HTTPS Request with invalid method using programnamepm")
	public void admin_sends_https_request_with_invalid_method_using_programnamepm() {
    	
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		    .spec(RS.createReq(URLs.GetAllProgramswithUsers))
	    		   .body(requestBody)
	    		   .when().get();
	}
    @Then("Admin receives Status with message and boolean success details invalid endpoint update programnamepm")
   	public void admin_receives_status_with_message_and_boolean_success_details_invalid_endpoint_update_programnamepm() {
    	response.then().statusCode(404);
	    System.out.println(response.getBody().asString());
    }


    @Then("Admin receives Status with message and boolean success details invalidmethod using programnamepm")
	public void admin_receives_status_with_message_and_boolean_success_details_invalidmethod_using_programnamepm() {
    	response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
    }
    @Given("Admin creates PUT Request for the LMS API endpoint with invalid endpointpm")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_invalid_endpointpm() {
	    
	
	}
	@When("Admin sends HTTPS Request with invalid endpoint updatepm")
	public void admin_sends_https_request_with_invalid_endpoint_updatepm() {
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   .body(requestBody)
	    		   .when().put();
		System.out.println(requestBody);
	   
	}

	@Then("Admin receives Status with message and boolean success detailspm")
	public void admin_receives_status_with_message_and_boolean_success_detailspm() {
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createProgram))
	    		   //.pathParam("programId",ProgramID)
	    		   //.body(requestBody)-
	    		   .when().post();
		response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with invalid baseurlpm")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_invalid_baseurlpm() {
	   
	}

	@When("Admin sends HTTPS Request with invalid endpoint update with invalid baseurlusing programnamepm")
	public void admin_sends_https_request_with_invalid_endpoint_update_with_invalid_baseurlusing_programnamepm() {
		//programName = auth.setPMProgramName();
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReqwithInvalidBaseurl(URLs.UpdateProgramByProgramId))
	    		   .pathParam("programName",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY))
	    		   .body(requestBody)
	    		   .when().put();
		
	}

	@Then("Admin receives Status with message and boolean success details with invalid baseurlusing programnamepm")
	public void admin_receives_status_with_message_and_boolean_success_details_with_invalid_baseurlusing_programnamepm() {
		//programName = auth.setPMProgramName();
         response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with programidpm")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_programidpm() throws InvalidFormatException, IOException {
		data =ExcelReader.getData(URLs.ExcelPath, "Sheet2");
	   
	}

	@When("Admin sends HTTPS Request with endpoint update programidpm")
	public void admin_sends_https_request_with_endpoint_update_programidpm() throws InvalidFormatException, IOException {
		//programId =auth.setPMProgramID();
	for(int i=0; i<data.size();i++) {
			String requestBody = payload.UpdateProgramData(data,i);
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.UpdateProgramByProgramId))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   .body(requestBody)
	    		   .when().put();
if(response.statusCode()==200) {
        	
        	{
        	//assertions asserts = new assertions(response);
        	//asserts.assertProgramModule();
        	
        	}
        }else if(response.statusCode()==400) {
        	String Massage = response.getStatusLine();
        	LoggerLoad.info(Massage);
        	}

	  }
	}
		
		
	@Then("Admin receives Status with message and boolean success details  update programidpm")
	public void admin_receives_status_with_message_and_boolean_success_details_update_programidpm() {
		response.then().statusCode(200);
	    System.out.println(response.getBody().asString());
	
        
	}

	@Given("Admin creates PUT Request for the LMS API with invalid enpoint By programidpm")
	public void admin_creates_put_request_for_the_lms_api_with_invalid_enpoint_by_programidpm() {
	    
	}

	@When("Admin sends HTTPS Request with invalid endpoint update with progamidpm")
	public void admin_sends_https_request_with_invalid_endpoint_update_with_progamidpm() {
		//programID =auth.setPMProgramID();
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   .body(requestBody)
	    		   .when().put();
	
	}

	@Then("Admin receives Status with message and boolean success details with progmidpm")
	public void admin_receives_status_with_message_and_boolean_success_details_with_progmidpm() {
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.InvalidEndPoint))
	    		   .body(requestBody)
	    		   .when().put();
		response.then().statusCode(404);
	    System.out.println(response.getBody().asString());
	}
	@Given("Admin creates PUT Request for the LMS API without request bodypm")
	public void admin_creates_put_request_for_the_lms_api_without_request_bodypm() {
	}   

	@When("Admin sends HTTPS Request with out request bodypm")
	public void admin_sends_https_request_with_out_request_bodypm() {
		//programID =auth.setPMProgramID();
		int i=0;
		String requestBody = payload.ProgramData(data,i);
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.UpdateProgramByProgramId))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   //.body(requestBody)
	    		   .when().put();
		
	}

	@Then("Admin receives Status with message and boolean success details without request bodypm")
	public void admin_receives_status_with_message_and_boolean_success_details_without_request_bodypm() {
		
		
	
		response.then().statusCode(400);
	    System.out.println(response.getBody().asString());
            	}
            
		
	

	@Given("Admin creates PUT Request for the LMS API with invalid methodpm")
	public void admin_creates_put_request_for_the_lms_api_with_invalid_methodpm() {
	    
	}
	@When("Admin sends HTTPS Request with invalid method with program idpm")
	public void admin_sends_https_request_with_invalid_method_with_program_idpm() {
		//programID =auth.setPMProgramID();
		
		response = RestAssured
	    		   .given()
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.GetAllProgramswithUsers))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))	    		 
	    		   //.body(requestBody)
	    		   .when().get();
		System.out.println(requestBody);
	}

	@Then("Admin receives Status with message and boolean success details with invalid methodpm")
	public void admin_receives_status_with_message_and_boolean_success_details_with_invalid_methodpm() {
		response.then().statusCode(405);
	    System.out.println(response.getBody().asString());
	}

	@Given("Admin creates PUT Request for the LMS API with invalid base urlpm")
	public void admin_creates_put_request_for_the_lms_api_with_invalid_base_urlpm() {
	    
	}

	@When("Admin sends HTTPS Request with invalid base urlpm")
	
	public void admin_sends_https_request_with_invalid_base_urlpm() {
		//programID =auth.setPMProgramID();
		
		response = RestAssured
		            .given()   		   
	    		   //.header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReqwithInvalidBaseurl(URLs.UpdateProgramByProgramId))
	    		   .pathParam("programId",Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
	    		   .body(requestBody)
	    		   .when().put();
		
	}

	

	@Then("Admin receives Status with message and boolean success details with invalid base urlpm")
	public void admin_receives_status_with_message_and_boolean_success_details_with_invalid_base_urlpm() {
		response.then().log().all().statusCode(404);

	    
	}

	@Then("Admin receives Status with response body.")
	public void admin_receives_status_with_response_body() {
	    response.then().statusCode(200);
	    System.out.println(response.getBody().asString());

}

}

