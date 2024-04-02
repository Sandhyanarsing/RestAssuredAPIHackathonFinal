package StepDefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.asserts.SoftAssert;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TestRequest.assertions;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;
import payloads.payload;


public class BatchSD {
	//String token ;
	String requestBody;
	Response response;
	
	public String batchId;
	public String batchName;
	
	Authorization auth = new Authorization();
	//ExcelTestData ExcelData = new ExcelTestData();
	ExcelReader ER = new ExcelReader();
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>> data;
	List<Response> responses = new ArrayList<>();
	String retrievedtoken;
	 assertions asserts = new assertions(response);
	public int expected_status;
	
	@Given("Admin sets Authorization Token for Batch")
	public void admin_sets_authorization_token_for_batch() {
		auth.setAuthorisation();
	}

	@Given("User creates POST request for the LMS API endpoint")
	public void user_creates_post_request_for_the_lms_api_endpoint() throws InvalidFormatException, IOException {
		data = ExcelReader.getData(URLs.ExcelPath, "BatchRequest");
		System.out.println(data);
	}

	@When("User sends HTTPS post request for batch and request body with endpoint")
	public void user_sends_https_post_request_for_batch_and_request_body_with_endpoint() throws IOException {
		File logFile = new File("logs.txt");
		FileOutputStream fos = new FileOutputStream(logFile);
        PrintStream ps = new PrintStream(fos);
        //System.setOut(ps);
		
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
		for(int i=0; i<data.size();i++) {
			
			String requestBody = payload.PostBatchRequestBody(data, i);
			expected_status = Integer.parseInt(data.get(i).get("ExpectedStatus"));
			System.out.println(requestBody);
		
		response = RestAssured
	    		   .given()
	    		  // .header("Authorization", "Bearer "+ auth.getAuthorisation())
	    		   .spec(RS.createReq(URLs.createBatch))
	    		   .body(requestBody)
	    		   .when().post();
		//response.then().statusCode(Integer.parseInt(data.get(i).get("ExpectedStatus"))).log().all();
		
		//asserts.assertPostBatch(response.getStatusCode(),Integer.parseInt(data.get(i).get("ExpectedStatus")));
		if(response.statusCode()!= expected_status) {
			String ErrorMessage = response.getStatusLine();
			LoggerLoad.info(ErrorMessage);
			LoggerLoad.info(String.format("Detected Bug for data with  batchName: <%s> from BatchRequest sheet",data.get(i).get("batchName")));
		}
		responses.add(response);
	  
		}
		fos.close();
	}
	@Then("Admin receives appropriate batch POST response Status code with response body.")
	public void admin_receives_appropriate_batch_post_response_status_code_with_response_body() {
		
		for (Response response : responses) {
           // response.then().log().all(); 
			/*if(response.statusCode()!= expected_status) {
				String ErrorMessage = response.getStatusLine();
				LoggerLoad.info(ErrorMessage);
			}*/
			
            if(response.statusCode()==201) {
            	System.out.println("success");
            	  
           	    System.out.println(batchId);
            	response.then().assertThat().statusCode(response.statusCode()).log().all();
            	batchId =response.jsonPath().getString("batchId");
            	batchName= response.jsonPath().getString("batchName");
            	Authorization.scenarioContext.setContext(LMSConstants.BATCHID_KEY, batchId);
                Authorization.scenarioContext.setContext(LMSConstants.BATCHNAME_KEY, batchName);  
                
              assertions asserts = new assertions(response);
               asserts.assertBatchModule(); 
               
              
            }else if(response.statusCode()==400) {
            	System.out.println("failure");
            }
		}
	    
	}
	
	@Given("User creates POST request for the LMS API  invalid endpoint")
	public void user_creates_post_request_for_the_lms_api_invalid_endpoint() throws InvalidFormatException, IOException {
		
		
	}

	@When("User sends HTTPS post request for batch and request body with invalid endpoint")
	public void user_sends_https_post_request_for_batch_and_request_body_with_invalid_endpoint() {
		
		String requestBody = payload.BatchReqBody_Standard();
		
		response = RestAssured
	    		   .given()
	    		   .header("Authorization", "Bearer "+ auth.setAuthorisation())
	    		   .spec(RS.createReq(URLs.createBatchInvalidEP))
	    		   .body(requestBody)
	    		   .when().post();
		
	  
	}
	@Then("Admin receives {int} not found Status code .")
	public void admin_receives_not_found_status_code(Integer int1) {
		 response.then().statusCode(404).log().all();
		  String statusline = response.statusLine();
		    LoggerLoad.info(statusline);    
	}
	
	@Given("Admin creates GET Request for all batches")
	public void admin_creates_get_request_for_all_batches() {
		
	}

	@When("Admin sends HTTPS GetallBatches Request with endpoint")
	public void admin_sends_https_getall_batches_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetallBatch))
		 		   .when().get();
	   
	}
	

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		response.then().statusCode(200).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);
	}

//	@Then("Admin receives {int} GetAllBatches status with error message Not Found .")
//	public void admin_receives_get_all_batches_invalid_endpoint_status_with_error_message_not_found(Integer int1) {
//		
//	}

	
	@Given("Admin creates GET Request SearchString")
	public void admin_creates_get_request_search_string() {
		
	}

	@When("Admin sends HTTPS GetAllBatches_SearchString Request with endpoint")
	public void admin_sends_https_get_all_batches_search_string_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetallBatch))
		 		  // .pathParam("searchString",4)
		 		   .when().get();
	  
	}

	@Then("Admin receives {int} GetAllBatches_SearchString Ok status with response body")
	public void admin_receives_get_all_batches_search_string_ok_status_with_response_body(Integer int1) {
		response.then().statusCode(200).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);
	   
	}

	@Given("Admin creates GetbyvalidBatchID Request with valid Batch ID")
	public void admin_creates_getbyvalid_batch_id_request_with_valid_batch_id() {
		
	  
	}

	@When("Admin sends HTTPS GetbyvalidBatchID Request with endpoint")
	public void admin_sends_https_getbyvalid_batch_id_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchID))
		 		   .pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
		 		   .when().get();
	}

	@Then("Admin receives {int} OK Status with response body GetbyvalidBatchID.")
	public void admin_receives_ok_status_with_response_body_getbyvalid_batch_id(Integer int1) {
		response.then().statusCode(200).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GET Request with invalid Batch ID")
	public void admin_creates_get_request_with_invalid_batch_id() {
	
	}

	@When("Admin sends HTTPS GetbyInvalidBatchID Request with endpoint")
	public void admin_sends_https_getby_invalid_batch_id_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchID))
		 		   .pathParam("batchId",(LMSConstants.INVALIDBATCHID))
		 		   .when().get();
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details GetbyInvalidBatchID.")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details_getby_invalid_batch_id(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);
	}

	@Given("Admin creates GetAllBatches_InvalidEndpoint")
	public void admin_creates_get_all_batches_invalid_endpoint() {
		   
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetallBatchInvalidEP))
		 		   .when().get();

	}

	@Then("Admin receives {int} GetAllBatches_InvalidEndpoint status with error message Not Found .")
	public void admin_receives_get_all_batches_invalid_endpoint_status_with_error_message_not_found(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);
	}




	@Given("Admin creates GetbatchID_InvalidEndpoint Request with valid Batch ID")
	public void admin_creates_getbatch_id_invalid_endpoint_request_with_valid_batch_id() {
		
	}

	@When("Admin sends HTTPS GetbatchID_InvalidEndpoint Request with invalid endpoint")
	public void admin_sends_https_getbatch_id_invalid_endpoint_request_with_invalid_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchIDInvalidEP))
		 		   .pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
		 		   .when().get();
	}

	@Then("Admin receives {int} not found  Status GetbatchID_InvalidEndpoint")
	public void admin_receives_not_found_status_getbatch_id_invalid_endpoint(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GetbyvalidBatchName Request with valid Batch Name")
	public void admin_creates_getbyvalid_batch_name_request_with_valid_batch_name() {


	}

	@When("Admin sends HTTPS GetbyvalidBatchName Request with endpoint")
	public void admin_sends_https_getbyvalid_batch_name_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchName))
		 		   .pathParam("batchName", Authorization.scenarioContext.getContext(LMSConstants.BATCHNAME_KEY))
		 		   .when().get();

	}

	@Then("Admin receives {int} OK Status with response body GetbyvalidBatchName.")
	public void admin_receives_ok_status_with_response_body_getbyvalid_batch_name(Integer int1) {
		response.then().statusCode(200).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);
	}

	@Given("Admin creates GetbyInvalidBatchName Request with invalid Batch Name")
	public void admin_creates_getby_invalid_batch_name_request_with_invalid_batch_name() {


	}

	@When("Admin sends HTTPS GetbyInvalidBatchName Request with endpoint")
	public void admin_sends_https_getby_invalid_batch_name_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchName))
		 		   .pathParam("batchName",LMSConstants.INVALIDBATCHNAME)
		 		   .when().get();

	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details GetbyInvalidBatchName")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details_getby_invalid_batch_name(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GetBatchName_InvalidEndPoint Request with valid Batch Name")
	public void admin_creates_get_batch_name_invalid_end_point_request_with_valid_batch_name() {


	}

	@When("Admin sends HTTPS GetBatchName_InvalidEndPoint Request with invalid endpoint")
	public void admin_sends_https_get_batch_name_invalid_end_point_request_with_invalid_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetbyBatchNameInvalidEP))
		 		  .pathParam("batchName", Authorization.scenarioContext.getContext(LMSConstants.BATCHNAME_KEY))
		 		   .when().get();

	}

	@Then("Admin receives {int} Not found GetBatchName_InvalidEndPoint")
	public void admin_receives_not_found_get_batch_name_invalid_end_point(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GetBatchByProgramID Request with program id")
	public void admin_creates_get_batch_by_program_id_request_with_program_id() {


	}

	@When("Admin sends HTTPS GetBatchByProgramID Request with endpoint")
	public void admin_sends_https_get_batch_by_program_id_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetBatchbyProgramID))
		 		   .pathParam("programId", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
		 		   .when().get();


	}

	@Then("Admin receives {int} OK Status with response body GetBatchByProgramID.")
	public void admin_receives_ok_status_with_response_body_get_batch_by_program_id(Integer int1) {
		response.then().statusCode(200).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GetBatchBy_InvalidProgramID Request with invalid Program Id")
	public void admin_creates_get_batch_by_invalid_program_id_request_with_invalid_program_id() {


	}

	@When("Admin sends HTTPS GetBatchBy_InvalidProgramID Request with endpoint")
	public void admin_sends_https_get_batch_by_invalid_program_id_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetBatchbyProgramID))
		 		   .pathParam("programId",LMSConstants.INVALIDPROGRAMID)
		 		   .when().get();
	   
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details GetBatchBy_InvalidProgramID")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details_get_batch_by_invalid_program_id(Integer int1) {
		response.then().statusCode(404).log().all();
	    String statusline = response.statusLine();
	    LoggerLoad.info(statusline);

	}

	@Given("Admin creates GetBatch_InvalidEndpoint Request with invalid endpoint")
	public void admin_creates_get_batch_invalid_endpoint_request_with_invalid_endpoint() {
	   
	}

	@When("Admin sends HTTPS GetBatch_InvalidEndpoint Request with endpoint")
	public void admin_sends_https_get_batch_invalid_endpoint_request_with_endpoint() {
		response = RestAssured
		 		   .given()
		 		   .spec(RS.createReq(URLs.GetBatchbyProgramIDInvalidEP))
		 		  .pathParam("programId", Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY))
		 		   .when().get();
	   
	}

	@Then("Admin receives {int} GetBatch_InvalidEndpoint Status with  error message Not Found.")
	public void admin_receives_get_batch_invalid_endpoint_status_with_error_message_not_found(Integer int1) {
			response.then().statusCode(404).log().all();
			String statusline = response.statusLine();
			LoggerLoad.info(statusline);
	}

	@Given("Admin creates PUT Request UpdateBatchID with valid BatchId and Data")
	public void admin_creates_put_request_update_batch_id_with_valid_batch_id_and_data() throws InvalidFormatException, IOException {
		
		data = ExcelReader.getData(URLs.ExcelPath, "BatchRequest");
		//System.out.println(data);
	}

	@When("Admin sends HTTPS UpdateBatchID Request  with endpoint")
	public void admin_sends_https_update_batch_id_request_with_endpoint() throws IOException {
		File logFile = new File("logs.txt");
		FileOutputStream fos = new FileOutputStream(logFile);
        PrintStream ps = new PrintStream(fos);
        //System.setOut(ps);
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
		
		
		for(int i=0; i<data.size();i++) {
			
				String requestBody = payload.PutBatchRequestBody(data, i);
			//	System.out.println(requestBody);
			
			response = RestAssured
		    		   .given()
		    		  // .header("Authorization", "Bearer "+ auth.getAuthorisation())
		    		   .spec(RS.createReq(URLs.updateBatch))
		    		   .body(requestBody)
		    		   .pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
		    		   .when().put();
			
			responses.add(response);		
			}		
		fos.close();
	}

	@Then("Admin receives respective batch PUT response Status in response body.")
	public void admin_receives_respective_batch_put_response_status_in_response_body() {
		for (Response response : responses) {
            response.then().log().all();
            response.then().assertThat().statusCode(response.statusCode()).log().all();
            if(response.statusCode()==200) {
            	System.out.println("success");
           	System.out.println(batchId);
           	
            }else if(response.statusCode()==400) {
            	System.out.println("failure");
            }
		}	 
	}

	@Given("Admin creates PUT Request UpdateBatchID_InvalidEndpoint with Valid batch Id")
	public void admin_creates_put_request_update_batch_id_invalid_endpoint_with_valid_batch_id() {
	  
	}

	@When("Admin sends HTTPS UpdateBatchID_InvalidEndpoint Request  with invalid endpoint")
	public void admin_sends_https_update_batch_id_invalid_endpoint_request_with_invalid_endpoint() {
			
		String requestBody = payload.BatchReqBody_Standard();
		
		response = RestAssured
	    		   .given()
	    		  // .header("Authorization", "Bearer "+ auth.getAuthorisation())
	    		   .spec(RS.createReq(URLs.updateBatchInvalidEP))
	    		   .body(requestBody)
	    		   .pathParam("batchId", Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY))
	    		   .when().put();	
	}

	@Then("Admin receives {int} UpdateBatchID_InvalidEndpoint not found.")
	public void admin_receives_update_batch_id_invalid_endpoint_not_found(Integer int1) {
		response.then().statusCode(404).log().all();
		String statusline = response.statusLine();
		LoggerLoad.info(statusline);
	}






}
