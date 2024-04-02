
@tag
Feature: User Module Controller
  
  
  Background:
  Given Admin sets Authorization

  @01CreateUsers
  Scenario: Check if admin is able to create a new Admin with valid and invalid requests
    Given Admin creates POST request to create users with all valid and invalid requests forUserModule
    When Admin sends HTTPS Request to create users with endpoint UM
    Then Admin receives appropriate Status code with response body for the users.    
    
    
  @02GetAllRoles
  Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request forUserModule 
    When Admin sends HTTPS Request with GET All Roles endpoint forUserModule
   Then Admin receives 200 OK forUserModule
   
   @03GetAllRoleswithInvalidEP
  Scenario: Check if admin is able to retreive all the available roles with invalid End point
    Given Admin creates GET Request forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
    @04GetAllAdmins
  Scenario: Check if admin able to retrieve all Admin with valid endpoint
    Given Admin creates GET Request forUserModule
    When Admin sends HTTPS Request with valid endpoint forUserModule
   Then Admin receives 200 OK forUserModule
   
    @05GetAllAdminswithInvalidEP
  Scenario: Check if admin able to retrieve all Admin with invalid endpoint
    Given Admin creates GET Request forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @06GetByAdminID
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request with valid AdminId forUserModule
    When Admin sends HTTPS Request with valid endpoint forUserModule
   Then Admin receives 200 OK forUserModule                                                               
   
   @07GetByAdminIDInvEP
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID and invalid endpoint
    Given Admin creates GET Request with valid AdminId forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @08GetByAdminIDwithInvAdminId
  Scenario: Check if Admin able to retrieve a Admin with invalid Admin ID
    Given Admin creates GET Request with invalid AdminId forUserModule
    When Admin sends HTTPS Request with Invalid admin id forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   
   @09UpdateAdminByRoleID
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with valid request body forUserModule
    When Admin sends HTTPS Request with endpoint forUserModule
   Then Admin receives 200 OK  Status with response body forUserModule 
   
   @10UpdateAdminByRoleIDwithInvReqBaody
  Scenario: Check if admin is able to update role id of a Admin by Invvalid ReqBody
    Given Admin creates PUT Request with invalid request body forUserModule
    When Admin sends HTTPS Request with endpoint and invalid request body forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule
   
    @11UpdateAdminByRoleIDwithInvAdminID
  Scenario: Check if admin is able to update role id of a Admin by invvalid Admin id
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint and invalid admin id forUserModule
   Then Admin receives 404 Not Found Status with message and boolean success details forUserModule
   
    @12UpdateAdminByRoleIDwithexistingAdminId
  Scenario: Check if admin is able to update a Admin with Admin Role Id with already existing Admin role ID
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint with existing ADmin id forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule 
   
   @13UpdateAdminByRoleIDwithInvEP
  Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives 404 Not Found Status with message and boolean success details forUserModule
   
   @14UpdateAdminRoleStatusyAdminID
  Scenario: Check if admin is able to update role status of a Admin with valid Admin id
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint with AdminID forUserModule
   Then Admin receives 200 Ok Status with response message forUserModule  
   
   @15UpdateAdminRoleStatusByInvRoleStatus
  Scenario: Check if admin is able to update role status of a Admin with inv role status
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint with invalid Rolestatus forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule
   
   @16UpdateAdminRoleStatusyInvAdminID
  Scenario: Check if admin is able to update role status of a Admin with invalid Admin id
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint with invAdminID forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @17UpdateAdminRoleStatusyNonExitingRoleID
  Scenario: Check if admin is able to update role status of a Admin for nonexisting/unassigned RoleID
      Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint with nonexisting/unassigned RoleID forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @18UpdateAdminRoleStatusyAdminIDAndInvEP
  Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule 
     
   @19UpdateAdminProgramBatchByAdminID
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint and program/batch forUserModule
   Then Admin receives 200 Ok Status with response message forUserModule  
   
   @20UpdateAdminProgramBatchByAdminIDAndInvData
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id and inv data
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with endpoint and program/batch with invalid data forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule   
   
   @21UpdateAdminRoleStatusyAdminIDAndInvEP
  Scenario:Check if admin is able to assign Admin to with program/batch by valid Admin Id with invEP
    Given Admin creates PUT Request with request body forUserModule
    When Admin creates PUT Request with valid data in request body with invalid adminID forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule   
   
   @22UpdateAdminLoginStatusyAdminID
  Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request to update the Admin login status by Admin ID forUserModule
   Then Admin receives 200 Ok Status with response message forUserModule     
   
   @23UpdateAdminLoginStatusyAdminIDAndInvData
  Scenario: Check if admin is able to update the Admin login status by Admin ID and invalid data in request body
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request to update the Admin login status by Admin ID and invalid data in request body forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule
   
   @24UpdateAdminLoginStatusyInvAdminID
  Scenario: Check if admin is able to update the Admin login status with invalid AdminId
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request to update the Admin login status with invalid AdminId forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @25UpdateAdminLoginStatusyAdminIDwithinvEP
  Scenario: Check if admin is able to update the Admin login status by Admin ID with INV EP
    Given Admin creates PUT Request with request body forUserModule
    When Admin sends HTTPS Request with invalid endpoint forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule     
   
   @26UpdateAdminInfoWithOnlyMandatory
  Scenario: Check if admin is able to update Admin details with Admin id and mandatory fields
    Given Admin creates PUT Request with valid data in request body (values only in mandatory fields) forUserModule 
    When Admin sends HTTPS request with endpoiint to update admin info forUserModule
   Then Admin receives 200 OK forUserModule
   
   @27UpdateAdminInfoWithAllFields
  Scenario: Check if admin is able to update Admin details with Admin id  and valid data in all fields
    Given Admin creates PUT Request with valid data in request body (values all fields) forUserModule 
    When Admin sends HTTPS request with endpoiint to update admin info with all fields forUserModule
   Then Admin receives 200 OK forUserModule
   
   @28UpdateAdminInfoWithInvData
  Scenario: Check if admin is able to update Admin details with  Admin id and invalid data
    Given Admin creates PUT Request with request body with inv data forUserModule
    When Admin sends HTTPS Request to update the Admin info by Admin ID and invalid data forUserModule
   Then Admin receives 400 Bad Request Status with message and boolean success details forUserModule
   
   @29UpdateAdminInfoWithInvAdminID
  Scenario: Check if admin is able to update Admin details with invalid AdminId
    Given Admin creates PUT Request with request body inv AdminID forUserModule
    When Admin sends HTTPS request with endpoiint to update Admin details with invalid AdminId forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule                                                                
   
   @tag1
  Scenario: Check if admin able to retrieve all Admins with roles
    Given Admin creates GET Request forUserModule 
    When Admin sends HTTPS Request with endpoint to get all admin forUserModule
    Then Admin receives 200 OK forUserModule
    
 @tag2
  Scenario: Check if admin able to retrieve all Admins with roles with invalid endpoint
    Given Admin creates GET Request forUserModule 
    When Admin sends HTTPS Request with invalid endpoint to get all admin forUserModule
    Then Admin receives status 404 with Not Found error message forUserModule
                                                                    
 @tag3
 Scenario: Check if admin is able to retrieve all Admins with filters
   Given Admin creates GET Request forUserModule
   When Admin sends HTTPS Request with the appropriate endpoint and filters forUserModule
   Then Admin receives 200 OK Status indicating a successful request with filtered results forUserModule
   
 @tag4
 Scenario: Check if admin is able to retrieve all Admins with filters with invalid endpoint
   Given Admin creates GET Request forUserModule 
   When Admin sends HTTPS Request with the appropriate invalid endpoint and filters forUserModule
   Then Admin receives status 404 with Not Found error message for all Admin with filters forUserModule  

 @tag5
Scenario: Check if admin able to retrieve all active Admins
   Given Admin creates GET Request for all active admins forUserModule
   When Admin sends HTTPS Request with endpoint for all active admins forUserModule
   Then Admin receives 200 OK for all active admins forUserModule
   
@tag6
 Scenario: Check if admin able to retrieve all active Admins with invalid endpoint
   Given Admin creates GET Request forUserModule 
   When Admin sends HTTPS Request with invalid endpoint for all active admins forUserModule
   Then Admin receives status 404 with Not Found error message for all active admins forUserModule
   
@tag7
Scenario: Check if admin is able to get count of active and inactive Admins
   Given Admin creates GET Request forUserModule
   When Admin sends HTTPS Request with endpoint for all type of users forUserModule
   Then Admin  receices 200 OK for all type of users forUserModule
   
@tag8
Scenario: Check if admin is able to get count of active and inactive Admins with invalid endpoint
   Given Admin creates GET Request forUserModule
   When Admin sends HTTPS Request with invalid endpoint for all type of users forUserModule
   Then Admin receives status 404 with Not Found error message for all active admins forUserModule
   
   
 @tag9
Scenario: Check if admin is able to get count of active and inactive Admins by role id
   Given Admin creates GET Request with role id forUserModule
   When Admin sends HTTPS Request with endpoint forUserModule
   Then Admin receives 200 OK forUserModule
   
@tag10
Scenario: Check if admin is able to get count of active and inactive Admins by invalid role ID 
   Given Admin creates GET Request with invalid role id forUserModule
   When Admin sends HTTPS Request with  active and inactive invalid endpoint forUserModule 
   Then Admin receices 404 OK for active and incative admins by role ID forUserModule

 @tag11
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
   Given Admin creates GET Request with valid batch Id forUserModule
   When Admin sends HTTPS Request with endpoint with valid batchID forUserModule
   Then Admin receives a response with status code 200 OK forUserModule
   
 @tag12
Scenario: Check if admin is able to get the Admins by program batches for invalid batch ID
   Given Admin creates GET Request  with invalid batchId forUserModule
   When the Admin sends a GET Request with an invalid batchId to the endpoint forUserModule
   Then the Admin should receive a 404 Not Found response forUserModule
   
  @tag13
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint
   Given Admin creates GET Request with valid batch Id with invalid endpoint forUserModule
   When Admin sends HTTPS Request with endpoint with valid batchID with invalid endpoint forUserModule
   Then Admin receives a response with status code 404 Not Found response forUserModule
   
 @tag14
Scenario: Check if admin is able to get the Admins for valid program Id
   Given Admin creates GET Request with valid program Id forUserModule
   When Admin sends HTTPS Request with endpoint for valid program Id forUserModule 
   Then Admin receives a response with status code 200 OK forUserModule
   
   @tag15
 Scenario: Check if admin is able to get the Admins for invalid program Id
   Given Admin creates GET Request with invalid program Id forUserModule
   When Admin sends HTTPS Request with endpoint invalid program Id forUserModule
   Then the Admin should receive a 404 Not Found response forUserModule
   
   @tag16
 Scenario: Check if admin is able to get the Admins for valid program Id with invalid endpoint
   Given Admin creates GET Request with valid program Id forUserModule
   When Admin sends HTTPS Request with invalid endpoint and valid program Id forUserModule 
   Then Admin receives status 404 with Not Found error message forUserModule
   
    @tag17
Scenario: Check if admin is able to retreive Admins by valid role ID
   Given Admin creates GET Request with valid role ID forUserModule 
   When Admin sends HTTPS Request with endpoint with valid role ID forUserModule 
   Then Admin receives a response with status code 200 OK forUserModule
   
   @tag18
 Scenario: Check if admin is able to retreive Admins by invalid role ID
   Given Admin creates GET Request for GET with invalid role ID forUserModule
   When Admin sends HTTPS Request with endpoint and invalid role ID forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
   @tag19
 Scenario: Check if admin is able to retreive Admins by valid role ID with invalid endpoint
   Given Admin creates GET Request with valid role ID and invalid endpoint forUserModule
   When Admin sends HTTPS Request with invalid endpoint and valid roleID forUserModule
   Then Admin receives status 404 with Not Found error message forUserModule
   
                                                       
    