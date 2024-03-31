package StepDefinitions;

import java.io.IOException;
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
import io.restassured.response.Response;
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
	//String[] userIdVariables = new String[userIds.size()];
	
	

	
	@Given("Admin creates POST request to create users with all valid and invalid requests")
	public void admin_creates_post_request_to_create_users_with_all_valid_and_invalid_requests() throws InvalidFormatException, IOException {
		data2 = ExcelReader.getData(URLs.ExcelPath, "Sheet2");
		
	}

	@When("Admin sends HTTPS Request to create users with endpoint")
	public void admin_sends_https_request_to_create_users_with_endpoint() {
		
	
		for(int i=0; i<data2.size();i++) {
			
			String requestBody = payload.UserRequestBody(data2,i);
			
		    response = RestAssured
	    		   .given()
	    		   .spec(RS.createReq(URLs.createUser))
	    		   .body(requestBody)
	    		   .when().post();
		
		    responses.add(response);
		
		}
}
	
	@Then("Admin receives appropriate Status code with response body for the users.")
	public void admin_receives_appropriate_status_code_with_response_body_for_the_users() {
		for (Response response : responses) {
            response.then().log().all();
       
            if(response.statusCode()==201)
            {
            	userId = response.jsonPath().getString("userId");
                userIds.add(userId);
                for(String userID:userIds ) 
                     {
                	 System.out.println("User ID: " + userID);
                	  }
                assertions asserts = new assertions(response);
                asserts.assertUserModule(); 
            	
            }else if(response.statusCode()==400) {
            	String message = response.jsonPath().getString("message");
            	LoggerLoad.info( message);
	}

}
	}


@Given("Admin creates GET Request")
public void admin_creates_get_request() {
   
}

@When("Admin sends HTTPS Request with GET All Roles endpoint")
public void admin_sends_https_request_with_get_all_roles_endpoint() {
	response = RestAssured
 		   .given()
 		   .spec(RS.createReq(URLs.getAllRoles))
 		   .when().get();
}

@Then("Admin receives {int} OK")
public void admin_receives_ok(Integer int1) {
    response.then().statusCode(200).log().all();
    String statusline = response.statusLine();
    LoggerLoad.info(statusline);
    
}

@When("Admin sends HTTPS Request with invalid endpoint")
public void admin_sends_https_request_with_invalid_endpoint() {
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.InvgetAllRoles))
	 		   .when().get();
}

@Then("Admin receives status {int} with Not Found error message")
public void admin_receives_status_with_not_found_error_message(Integer int1) {
	response.then().statusCode(404).log().all();
    String statusline = response.statusLine();
    LoggerLoad.info(statusline);
}

@When("Admin sends HTTPS Request with valid endpoint")
public void admin_sends_https_request_with_valid_endpoint() {
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.getAllRoles))
	 		   .param("R01")
	 		   .when().get();
}

@Given("Admin creates PUT Request with valid request body")
public void admin_creates_put_request_with_valid_request_body() {
	
	
    
}

@When("Admin sends HTTPS Request with endpoint")
public void admin_sends_https_request_with_endpoint() {
	String requestBody = payload.UpdateUserByRoleID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID","U282")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
    
}

@Then("Admin receives {int} OK  Status with response body.")
public void admin_receives_ok_status_with_response_body(Integer int1) {
	response.then().statusCode(200);
}

@Given("Admin creates PUT Request with invalid request body")
public void admin_creates_put_request_with_invalid_request_body() {
    
}

@When("Admin sends HTTPS Request with endpoint and invalid request body")
public void admin_sends_https_request_with_endpoint_and_invalid_request_body() {
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID","U282")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Bad Request Status with message and boolean success details")
public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
	response.then().statusCode(400);
}

@Given("Admin creates PUT Request with request body")
public void admin_creates_put_request_with_request_body() {
   
}

@When("Admin sends HTTPS Request with endpoint and invalid admin id")
public void admin_sends_https_request_with_endpoint_and_invalid_admin_id() {
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID","ABCD")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with existing ADmin id")
public void admin_sends_https_request_with_endpoint_with_existing_a_dmin_id() {
	String requestBody = payload.UpdateUserByRoleIDwithInvReqBody();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserByRoleID))
	 		   .pathParam("userID","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Not Found Status with message and boolean success details")
public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
	response.then().statusCode(404);
}
@Given("Admin creates GET Request with valid AdminId")
public void admin_creates_get_request_with_valid_admin_id() {
   
}

@Given("Admin creates GET Request with invalid AdminId")
public void admin_creates_get_request_with_invalid_admin_id() {
    
}

@When("Admin sends HTTPS Request with endpoint with AdminID")
public void admin_sends_https_request_with_endpoint_with_admin_id() {
	String requestBody = payload.UpdateUserRoleStatusByAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Then("Admin receives {int} Ok Status with response message")
public void admin_receives_ok_status_with_response_message(Integer int1) {
	response.then().statusCode(200);
}

@When("Admin sends HTTPS Request with endpoint with invalid Rolestatus")
public void admin_sends_https_request_with_endpoint_with_invalid_rolestatus() {
	String requestBody = payload.UpdateUserRoleStatusByInvRoleStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with invAdminID")
public void admin_sends_https_request_with_endpoint_with_inv_admin_id() {
	String requestBody = payload.UpdateUserRoleStatusByAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID","ABCD")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint with nonexisting\\/unassigned RoleID")
public void admin_sends_https_request_with_endpoint_with_nonexisting_unassigned_role_id() {
	String requestBody = payload.UpdateUserRoleStatusByInvRoleID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleStatusByAdminID))
	 		   .pathParam("userID","ABCD")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}
@When("Admin sends HTTPS Request with endpoint and program\\/batch")
public void admin_sends_https_request_with_endpoint_and_program_batch() {
	String requestBody = payload.UpdateUserRoleProgramBatchStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userID","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request with endpoint and program\\/batch with invalid data")
public void admin_sends_https_request_with_endpoint_and_program_batch_with_invalid_data() {
	String requestBody = payload.UpdateUserRoleProgramBatchStatuswithInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userID","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin creates PUT Request with valid data in request body with invalid adminID")
public void admin_creates_put_request_with_valid_data_in_request_body_with_invalid_admin_id() {
	String requestBody = payload.UpdateUserRoleProgramBatchStatus();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateUserRoleProgramBatchStatus))
	 		   .pathParam("userID","ABC")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}
@When("Admin sends HTTPS Request to update the Admin login status by Admin ID")
public void admin_sends_https_request_to_update_the_admin_login_status_by_admin_id() {
	String requestBody = payload.UpdateAdminLoginStatusyAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request to update the Admin login status by Admin ID and invalid data in request body")
public void admin_sends_https_request_to_update_the_admin_login_status_by_admin_id_and_invalid_data_in_request_body() {
	String requestBody = payload.UpdateAdminLoginStatusyAdminIDAndInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@When("Admin sends HTTPS Request to update the Admin login status with invalid AdminId")
public void admin_sends_https_request_to_update_the_admin_login_status_with_invalid_admin_id() {
	String requestBody = payload.UpdateAdminLoginStatusyAdminID();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminLoginStatusyAdminID))
	 		   .pathParam("userId","ABC")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with valid data in request body \\(values only in mandatory fields)")
public void admin_creates_put_request_with_valid_data_in_request_body_values_only_in_mandatory_fields() {
    
}

@When("Admin sends HTTPS request with endpoiint to update admin info")
public void admin_sends_https_request_with_endpoiint_to_update_admin_info() {
	String requestBody = payload.UpdateAdminInfoOnlyMandateFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with valid data in request body \\(values all fields)")
public void admin_creates_put_request_with_valid_data_in_request_body_values_all_fields() {
}

@When("Admin sends HTTPS request with endpoiint to update admin info with all fields")
public void admin_sends_https_request_with_endpoiint_to_update_admin_info_with_all_fields() {
	String requestBody = payload.UpdateAdminInfoWithAllFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with request body with inv data")
public void admin_creates_put_request_with_request_body_with_inv_data() {
	
}

@When("Admin sends HTTPS Request to update the Admin info by Admin ID and invalid data")
public void admin_sends_https_request_to_update_the_admin_info_by_admin_id_and_invalid_data() {
	String requestBody = payload.UpdateAdminInfoWithInvData();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId","U202")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

@Given("Admin creates PUT Request with request body inv AdminID")
public void admin_creates_put_request_with_request_body_inv_admin_id() {
   
}

@When("Admin sends HTTPS request with endpoiint to update Admin details with invalid AdminId")
public void admin_sends_https_request_with_endpoiint_to_update_admin_details_with_invalid_admin_id() {
	String requestBody = payload.UpdateAdminInfoWithAllFileds();
	response = RestAssured
	 		   .given()
	 		   .spec(RS.createReq(URLs.UpdateAdminInfo))
	 		   .pathParam("userId","Abc")
	 		   .body(requestBody)
	 		   .when().put();
	response.then().log().all();
}

}

