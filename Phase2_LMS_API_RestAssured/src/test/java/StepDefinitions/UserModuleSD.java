package StepDefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.URLs;
import TestRequest.RequestSpec;
import TestRequest.assertions;
import TokenRetreiver.Authorization;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import lmsApiConstants.LMSConstants;
import payloads.payload;

public class UserModuleSD {
	
	Authorization auth = new Authorization();
	ExcelReader ER = new ExcelReader();
	String requestBody;
	Response response;
	RequestSpec RS = new RequestSpec();
	List<Map<String, String>>data2;
	List<Response> responses = new ArrayList<>();
	List<String> userIds = new ArrayList<>();
	String userId;
	//String userID;
	//String[] userIdVariables = new String[userIds.size()];
	
	

	
	@Given("Admin creates POST request to create users with all valid and invalid requests forUserModule")
	public void admin_creates_post_request_to_create_users_with_all_valid_and_invalid_requests_forUserModule() throws InvalidFormatException, IOException {
		data2 = ExcelReader.getData(URLs.ExcelPath, "UserModule");
		
	}

	@When("Admin sends HTTPS Request to create users with endpoint UM")
	public void admin_sends_https_request_to_create_users_with_endpoint_UM() throws IOException {
		
 File logFile = new File("logs.txt");
		 
		 FileOutputStream fos = new FileOutputStream(logFile);
	        PrintStream ps = new PrintStream(fos);
	        System.setOut(ps);
	        
		RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
		for(int i=0; i<data2.size();i++) {
			
			String requestBody = payload.UserRequestBody(data2,i);
			
		    response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.createUser))
	    		   .body(requestBody)
	    		   .when().post();
		
		    responses.add(response);
		
		}
		fos.close();
}
	
	@Then("Admin receives appropriate Status code with response body for the users.")
	public void admin_receives_appropriate_status_code_with_response_body_for_the_users() {
		for (Response response : responses) {
            response.then().log().all();
       
            if(response.statusCode()==201)
            {
            	userId = response.jsonPath().getString("userId");
            
                	  Authorization.scenarioContext.setContext(LMSConstants.USERID_KEY, userId);
         
                assertions asserts = new assertions(response);
                asserts.assertUserModule(); 
            	
            }
            else if(response.statusCode()==400) {
            	String message = response.jsonPath().getString("message");
            	LoggerLoad.info( message);
            	}

}     
	}


@Given("Admin creates GET Request forUserModule")
public void admin_creates_get_request_forUserModule() {
    
}

@When("Admin sends HTTPS Request with GET All Roles endpoint forUserModule")
public void admin_sends_https_request_with_get_all_roles_endpoint_forUserModule() {
	response = RestAssured
 		   .given()
 		   .spec(RS.createReq(URLs.getAllRoles))
 		   .when().get();
}

@Then("Admin receives {int} OK forUserModule")
public void admin_receives_ok_forUserModule(Integer int1) {
    response.then().statusCode(200).log().all();
    String statusline = response.statusLine();
    LoggerLoad.info(statusline);
    
}

@When("Admin sends HTTPS Request with invalid endpoint forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_forUserModule() {
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.InvgetAllRoles))
	 		   .when().get();
}

@Then("Admin receives status {int} with Not Found error message forUserModule")
public void admin_receives_status_with_not_found_error_message_forUserModule(Integer int1) {
	response.then().statusCode(404).log().all();
    String statusline = response.statusLine();
    LoggerLoad.info(statusline);
}

@When("Admin sends HTTPS Request with valid endpoint forUserModule")
public void admin_sends_https_request_with_valid_endpoint_forUserModule() {
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.getAllAdmins))
	 		   .pathParam("roleId", "R01")
	 		   .when().get();
}

@Given("Admin creates PUT Request with valid request body forUserModule")
public void admin_creates_put_request_with_valid_request_body_forUserModule() {
	
	//userID = auth.setUserID();
    
}

@When("Admin sends HTTPS Request with endpoint forUserModule")
public void admin_sends_https_request_with_endpoint_forUserModule() {
	String requestBody = payload.UpdateUserByRoleID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
    
}

@Then("Admin receives {int} OK  Status with response body forUserModule")
public void admin_receives_ok_status_with_response_body_forUserModule(Integer int1) {
	response.then().statusCode(200);
}

@Given("Admin creates PUT Request with invalid request body forUserModule")
public void admin_creates_put_request_with_invalid_request_body_forUserModule() {
	//userID = auth.setUserID();
}

@When("Admin sends HTTPS Request with endpoint and invalid request body forUserModule")
public void admin_sends_https_request_with_endpoint_and_invalid_request_body_forUserModule() {
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Bad Request Status with message and boolean success details forUserModule")
public void admin_receives_bad_request_status_with_message_and_boolean_success_details_forUserModule(Integer int1) {
	response.then().statusCode(400);
}

@Given("Admin creates PUT Request with request body forUserModule")
public void admin_creates_put_request_with_request_body_forUserModule() {
   
}

@When("Admin sends HTTPS Request with endpoint and invalid admin id forUserModule")
public void admin_sends_https_request_with_endpoint_and_invalid_admin_id_forUserModule() {
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID","ABCD")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with existing ADmin id forUserModule")
public void admin_sends_https_request_with_endpoint_with_existing_a_dmin_id_forUserModule() {
	// = auth.setUserID();
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Not Found Status with message and boolean success details forUserModule")
public void admin_receives_not_found_status_with_message_and_boolean_success_details_forUserModule(Integer int1) {
	response.then().statusCode(404);
}
@Given("Admin creates GET Request with valid AdminId forUserModule")
public void admin_creates_get_request_with_valid_admin_id_forUserModule() {
	//userID = auth.setUserID();
}

//@Given("Admin creates GET Request with invalid AdminId forUserModule")
//public void admin_creates_get_request_with_invalid_admin_id_forUserModule() {
//    
//}
//  @When("Admin sends HTTPS Request with Invalid admin id forUserModule")
//  public void Admin_sends_HTTPS_Request_with_Invalid_admin_id_forUserModule() {
//	  response = RestAssured
//	 		   .given()
//	 		   .spec(RS.createReq(URLs.getAllAdmins))
//	 		   .pathParam("roleId", "R01")
//	 		   .when().get();
//  }

@When("Admin sends HTTPS Request with endpoint with AdminID forUserModule")
public void admin_sends_https_request_with_endpoint_with_admin_id_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateUserRoleStatusByAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Ok Status with response message forUserModule")
public void admin_receives_ok_status_with_response_message_forUserModule(Integer int1) {
	response.then().statusCode(200);
}

@When("Admin sends HTTPS Request with endpoint with invalid Rolestatus forUserModule")
public void admin_sends_https_request_with_endpoint_with_invalid_rolestatus_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateUserRoleStatusByInvRoleStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with invAdminID forUserModule")
public void admin_sends_https_request_with_endpoint_with_inv_admin_id_forUserModule() {
	String requestBody = payload.UpdateUserRoleStatusByAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID","ABCD")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with nonexisting\\/unassigned RoleID forUserModule")
public void admin_sends_https_request_with_endpoint_with_nonexisting_unassigned_role_id_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateUserRoleStatusByInvRoleID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}
@When("Admin sends HTTPS Request with endpoint and program\\/batch forUserModule")
public void admin_sends_https_request_with_endpoint_and_program_batch_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateUserRoleProgramBatchStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint and program\\/batch with invalid data forUserModule")
public void admin_sends_https_request_with_endpoint_and_program_batch_with_invalid_data_forUserModule() {
	//userID = auth.setUserID();
	
	String requestBody = payload.UpdateUserRoleProgramBatchStatuswithInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin creates PUT Request with valid data in request body with invalid adminID forUserModule")
public void admin_creates_put_request_with_valid_data_in_request_body_with_invalid_admin_id_forUserModule() {
	String requestBody = payload.UpdateUserRoleProgramBatchStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userId","ABC")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}
@When("Admin sends HTTPS Request to update the Admin login status by Admin ID forUserModule")
public void admin_sends_https_request_to_update_the_admin_login_status_by_admin_id_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateAdminLoginStatusyAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request to update the Admin login status by Admin ID and invalid data in request body forUserModule")
public void admin_sends_https_request_to_update_the_admin_login_status_by_admin_id_and_invalid_data_in_request_body_forUserModule() {
	//userID = auth.setUserID();
	
	String requestBody = payload.UpdateAdminLoginStatusyAdminIDAndInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request to update the Admin login status with invalid AdminId forUserModule")
public void admin_sends_https_request_to_update_the_admin_login_status_with_invalid_admin_id_forUserModule() {
	String requestBody = payload.UpdateAdminLoginStatusyAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId","ABC")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with valid data in request body \\(values only in mandatory fields) forUserModule")
public void admin_creates_put_request_with_valid_data_in_request_body_values_only_in_mandatory_fields_forUserModule() {
    
}

@When("Admin sends HTTPS request with endpoiint to update admin info forUserModule")
public void admin_sends_https_request_with_endpoiint_to_update_admin_info_forUserModule() {
	//userID = auth.setUserID();
	
	String requestBody = payload.UpdateAdminInfoOnlyMandateFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with valid data in request body \\(values all fields) forUserModule")
public void admin_creates_put_request_with_valid_data_in_request_body_values_all_fields_forUserModule() {
}

@When("Admin sends HTTPS request with endpoiint to update admin info with all fields forUserModule")
public void admin_sends_https_request_with_endpoiint_to_update_admin_info_with_all_fields_forUserModule() {
	//userID = auth.setUserID();
	String requestBody = payload.UpdateAdminInfoWithAllFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with request body with inv data forUserModule")
public void admin_creates_put_request_with_request_body_with_inv_data_forUserModule() {
	
}

@When("Admin sends HTTPS Request to update the Admin info by Admin ID and invalid data forUserModule")
public void admin_sends_https_request_to_update_the_admin_info_by_admin_id_and_invalid_data_forUserModule() {
	//userID = auth.setUserID();
	
	String requestBody = payload.UpdateAdminInfoWithInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId",Authorization.scenarioContext.getContext(LMSConstants.USERID_KEY))
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with request body inv AdminID forUserModule")
public void admin_creates_put_request_with_request_body_inv_admin_id_forUserModule() {
   
}

@When("Admin sends HTTPS request with endpoiint to update Admin details with invalid AdminId forUserModule")
public void admin_sends_https_request_with_endpoiint_to_update_admin_details_with_invalid_admin_id_forUserModule() {
	String requestBody = payload.UpdateAdminInfoWithAllFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId","Abc")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}



@When("Admin sends HTTPS Request with endpoint to get all admin forUserModule")
public void admin_sends_https_request_with_endpoint_to_get_all_admin_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.AdminwthAllRoles))
			.when().get();
}

//@Then("Admin receives {int} OK Status with response body")
//public void admin_receives_ok_status_with_response_body(Integer int1) {
//	response.then().log().all().statusCode(200);
//
//
//}

@When("Admin sends HTTPS Request with invalid endpoint to get all admin forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_to_get_all_admin_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.InvalidendPoint))
			.param("roleId","R02")
			.when().get();
}

//@Then("Admin receives status {int} with Not Found error message")
//public void admin_receives_status_with_not_found_error_message(Integer int1) {
//	response.then().log().all().statusCode(404);
//}

@When("Admin sends HTTPS Request with the appropriate endpoint and filters forUserModule")
public void admin_sends_https_request_with_the_appropriate_endpoint_and_filters_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.RoleIDV2))
			.when().get();
}

@Then("Admin receives {int} OK Status indicating a successful request with filtered results forUserModule")
public void admin_receives_ok_status_indicating_a_successful_request_with_filtered_results_forUserModule(Integer int1) {
	response.then().log().all().statusCode(200);
}

@When("Admin sends HTTPS Request with the appropriate invalid endpoint and filters forUserModule")
public void admin_sends_https_request_with_the_appropriate_invalid_endpoint_and_filters_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.RoleIDV2Invalid))
			.when().get();

}

@Then("Admin receives status {int} with Not Found error message for all Admin with filters forUserModule")
public void admin_receives_status_with_not_found_error_message_for_all_admin_with_filters_forUserModule(Integer int1) {
	response.then().log().all().statusCode(404);
}

@Given("Admin creates GET Request for all active admins forUserModule")
public void admin_creates_get_request_for_all_active_admins_forUserModule() {
}

@When("Admin sends HTTPS Request with endpoint for all active admins forUserModule")
public void admin_sends_https_request_with_endpoint_for_all_active_admins_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetAllActiveUsers))
			.when().get();

}

@Then("Admin receives {int} OK for all active admins forUserModule")
public void admin_receives_ok_for_all_active_admins_forUserModule(Integer int1) {
	response.then().log().all().statusCode(200);
	//token = response.jsonPath().getString("token");

}

@When("Admin sends HTTPS Request with invalid endpoint for all active admins forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_for_all_active_admins_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetAllActiveUsersIVEndpoint))
			.when().get();
}

@Then("Admin receives status {int} with Not Found error message for all active admins forUserModule")
public void admin_receives_status_with_not_found_error_message_for_all_active_admins_forUserModule(Integer int1) {
	response.then().log().all().statusCode(404);
}

@When("Admin sends HTTPS Request with endpoint for all type of users forUserModule")
public void admin_sends_https_request_with_endpoint_for_all_type_of_users_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.AllTypeofUsers))
			.when().get();

}

@Then("Admin  receices {int} OK for all type of users forUserModule")
public void admin_receices_ok_for_all_type_of_users_forUserModule(Integer int1) {
	response.then().log().all().statusCode(200);

}
@When("Admin sends HTTPS Request with invalid endpoint for all type of users forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_for_all_type_of_users_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.AllTypeofUsersInValid))
			.when().get();
}
@Given("Admin creates GET Request with role id forUserModule")
public void admin_creates_get_request_with_role_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.AllTypeofUsersRollID))
			.param("roleId","R01")
			.when().get();

}
@Then("Admin receices {int} OK for active and inactive admins by role id forUserModule")
public void admin_receices_ok_for_active_and_inactive_admins_by_role_id_forUserModule(Integer int1) {
	response.then().log().all().statusCode(200);

}

@Given("Admin creates GET Request with invalid role id forUserModule")
public void admin_creates_get_request_with_invalid_role_id_forUserModule() {

}

@When("Admin sends HTTPS Request with  active and inactive invalid endpoint forUserModule")
public void admin_sends_https_request_with_active_and_inactive_invalid_endpoint_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetAllActiveUsersIVEndpoint))
			.when().get();

}

@Then("Admin receices {int} OK for active and incative admins by role ID forUserModule")
public void admin_receices_ok_for_active_and_incative_admins_by_role_id_forUserModule(Integer int1) {
	response.then().log().all().statusCode(404);

}
@Given("Admin creates GET Request with valid batch Id forUserModule")
public void admin_creates_get_request_with_valid_batch_id_forUserModule() {


}

@When("Admin sends HTTPS Request with endpoint with valid batchID forUserModule")
public void admin_sends_https_request_with_endpoint_with_valid_batch_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetProgramBatches))
			.pathParam("Id","8432")
			.when().get();

}

@Then("Admin receives a response with status code {int} OK forUserModule")
public void admin_receives_a_response_with_status_code_ok_forUserModule(Integer int1) {

	response.then().log().all().statusCode(200);

}

@Given("Admin creates GET Request  with invalid batchId forUserModule")
public void admin_creates_get_request_with_invalid_batch_id_forUserModule() {
}

@When("the Admin sends a GET Request with an invalid batchId to the endpoint forUserModule")
public void the_admin_sends_a_get_request_with_an_invalid_batch_id_to_the_endpoint_forUserModule() {

	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetProgramBatchesInVBatchID))
			.when().get();
}

@Then("the Admin should receive a {int} Not Found response forUserModule")
public void the_admin_should_receive_a_not_found_response_forUserModule(Integer int1) {
	response.then().log().all().statusCode(404);

}
@Given("Admin creates GET Request with valid batch Id with invalid endpoint forUserModule")
public void admin_creates_get_request_with_valid_batch_id_with_invalid_endpoint_forUserModule() {
}

@When("Admin sends HTTPS Request with endpoint with valid batchID with invalid endpoint forUserModule")
public void admin_sends_https_request_with_endpoint_with_valid_batch_id_with_invalid_endpoint_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.ValidBatchIDandInvalidEndpoint))
			.pathParam("Id","8432")
			.when().get();

}

@Then("Admin receives a response with status code {int} Not Found response forUserModule")
public void admin_receives_a_response_with_status_code_not_found_response_forUserModule(Integer int1) {
	response.then().log().all().statusCode(404);
}
@Given("Admin creates GET Request with valid program Id forUserModule")
public void admin_creates_get_request_with_valid_program_id_forUserModule() {

}

@When("Admin sends HTTPS Request with endpoint for valid program Id forUserModule")
public void admin_sends_https_request_with_endpoint_for_valid_program_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.ValidProgramID))
			.pathParam("programId","16363")
			.when().get();
}   
@Given("Admin creates GET Request with invalid program Id forUserModule")
public void admin_creates_get_request_with_invalid_program_id_forUserModule() {


}

@When("Admin sends HTTPS Request with endpoint invalid program Id forUserModule")
public void admin_sends_https_request_with_endpoint_invalid_program_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.InValidProgramID))
			.pathParam("programId","1636")
			.when().get();
}
@When("Admin sends HTTPS Request with invalid endpoint and valid program Id forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_and_valid_program_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.ValidProgIDWthInvalidEndpoint))
			.pathParam("programId","16363")
			.when().get();

}
@Given("Admin creates GET Request with valid role ID forUserModule")
public void admin_creates_get_request_with_valid_role_id_forUserModule() {

}

@When("Admin sends HTTPS Request with endpoint with valid role ID forUserModule")
public void admin_sends_https_request_with_endpoint_with_valid_role_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetUserByRoleID))
			.pathParam("roleId","R01")
			.when().get();
}
@Given("Admin creates GET Request for GET with invalid role ID forUserModule")
public void admin_creates_get_request_for_get_with_invalid_role_id_forUserModule() {
}

@When("Admin sends HTTPS Request with endpoint and invalid role ID forUserModule")
public void admin_sends_https_request_with_endpoint_and_invalid_role_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.GetUserByInvalidRoleID))
			.pathParam("roleId","R04")
			.when().get();

}

@Given("Admin creates GET Request with valid role ID and invalid endpoint forUserModule")
public void admin_creates_get_request_with_valid_role_id_and_invalid_endpoint_forUserModule () {
}

@When("Admin sends HTTPS Request with invalid endpoint and valid roleID forUserModule")
public void admin_sends_https_request_with_invalid_endpoint_and_valid_role_id_forUserModule() {
	response = RestAssured
			.given()
			.spec(RS.createReq(URLs.InvalidEndpointwthValidRoleID))
			.pathParam("roleId","R01")
			.when().get();
}
}



