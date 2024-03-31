
@tag
Feature: Post Request.
  
  
  Background:
  Given Admin sets Authorization

  @01CreateUsers
  Scenario: Check if admin is able to create a new Admin with valid and invalid requests
    Given Admin creates POST request to create users with all valid and invalid requests 
    When Admin sends HTTPS Request to create users with endpoint
    Then Admin receives appropriate Status code with response body for the users.    
    
    
  @02GetAllRoles
  Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with GET All Roles endpoint
   Then Admin receives 200 OK
   
   @03GetAllRoleswithInvalidEP
  Scenario: Check if admin is able to retreive all the available roles with invalid End point
    Given Admin creates GET Request
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives status 404 with Not Found error message
   
    @04GetAllAdmins
  Scenario: Check if admin able to retrieve all Admin with valid endpoint
    Given Admin creates GET Request
    When Admin sends HTTPS Request with valid endpoint
   Then Admin receives 200 OK      
   
    @05GetAllAdminswithInvalidEP
  Scenario: Check if admin able to retrieve all Admin with invalid endpoint
    Given Admin creates GET Request
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives status 404 with Not Found error message
   
   @06GetByAdminID
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request with valid AdminId
    When Admin sends HTTPS Request with valid endpoint
   Then Admin receives 200 OK                                                                 
   
   @07GetByAdminIDInvEP
  Scenario: Check if admin able to retrieve a Admin with valid Admin ID and invalid endpoint
    Given Admin creates GET Request with valid AdminId
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives status 404 with Not Found error message
   
   @08GetByAdminIDwithInvAdminId
  Scenario: Check if Admin able to retrieve a Admin with invalid Admin ID
    Given Admin creates GET Request with invalid AdminId
    When Admin sends HTTPS Request with valid endpoint
   Then Admin receives status 404 with Not Found error message
   
   
   @09UpdateAdminByRoleID
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with valid request body
    When Admin sends HTTPS Request with endpoint
   Then Admin receives 200 OK  Status with response body. 
   
   @10UpdateAdminByRoleIDwithInvReqBaody
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with invalid request body
    When Admin sends HTTPS Request with endpoint and invalid request body
   Then Admin receives 400 Bad Request Status with message and boolean success details
   
    @11UpdateAdminByRoleIDwithInvAdminID
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint and invalid admin id
   Then Admin receives 404 Not Found Status with message and boolean success details
   
    @12UpdateAdminByRoleIDwithexistingAdminId
  Scenario: Check if admin is able to update a Admin with Admin Role Id with already existing Admin role ID
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint with existing ADmin id
   Then Admin receives 400 Bad Request Status with message and boolean success details 
   
   @13UpdateAdminByRoleIDwithInvEP
  Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives 404 Not Found Status with message and boolean success details
   
   @14UpdateAdminRoleStatusyAdminID
  Scenario: Check if admin is able to update role status of a Admin with valid Admin id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint with AdminID
   Then Admin receives 200 Ok Status with response message  
   
   @15UpdateAdminRoleStatusByInvRoleStatus
  Scenario: Check if admin is able to update role status of a Admin with valid Admin id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint with invalid Rolestatus
   Then Admin receives 400 Bad Request Status with message and boolean success details
   
   @16UpdateAdminRoleStatusyInvAdminID
  Scenario: Check if admin is able to update role status of a Admin with invalid Admin id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint with invAdminID
   Then Admin receives status 404 with Not Found error message
   
   @17UpdateAdminRoleStatusyNonExitingRoleID
  Scenario: Check if admin is able to update role status of a Admin for nonexisting/unassigned RoleID
      Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint with nonexisting/unassigned RoleID
   Then Admin receives status 404 with Not Found error message
   
   @18UpdateAdminRoleStatusyAdminIDAndInvEP
  Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives status 404 with Not Found error message 
     
   @19UpdateAdminProgramBatchByAdminID
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint and program/batch
   Then Admin receives 200 Ok Status with response message  
   
   @20UpdateAdminProgramBatchByAdminIDAndInvData
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with endpoint and program/batch with invalid data
   Then Admin receives 400 Bad Request Status with message and boolean success details   
   
   @21UpdateAdminRoleStatusyAdminIDAndInvEP
  Scenario:Check if admin is able to assign Admin to with program/batch by invalid Admin Id
    Given Admin creates PUT Request with request body
    When Admin creates PUT Request with valid data in request body with invalid adminID
   Then Admin receives status 404 with Not Found error message   
   
   @22UpdateAdminLoginStatusyAdminID
  Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request to update the Admin login status by Admin ID
   Then Admin receives 200 Ok Status with response message     
   
   @23UpdateAdminLoginStatusyAdminIDAndInvData
  Scenario: Check if admin is able to update the Admin login status by Admin ID and invalid data in request body
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request to update the Admin login status by Admin ID and invalid data in request body
   Then Admin receives 400 Bad Request Status with message and boolean success details
   
   @24UpdateAdminLoginStatusyInvAdminID
  Scenario: Check if admin is able to update the Admin login status with invalid AdminId
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request to update the Admin login status with invalid AdminId
   Then Admin receives status 404 with Not Found error message
   
   @25UpdateAdminLoginStatusyAdminID
  Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request with request body
    When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives status 404 with Not Found error message     
   
   @26UpdateAdminInfoWithOnlyMandatory
  Scenario: Check if admin is able to update Admin details with Admin id and mandatory fields
    Given Admin creates PUT Request with valid data in request body (values only in mandatory fields) 
    When Admin sends HTTPS request with endpoiint to update admin info
   Then Admin receives 200 Ok status with message 
   
   @27UpdateAdminInfoWithAllFields
  Scenario: Check if admin is able to update Admin details with Admin id  and valid data in all fields
    Given Admin creates PUT Request with valid data in request body (values all fields) 
    When Admin sends HTTPS request with endpoiint to update admin info with all fields
   Then Admin receives 200 Ok status with message 
   
   @28UpdateAdminInfoWithInvData
  Scenario: Check if admin is able to update Admin details with  Admin id and invalid data
    Given Admin creates PUT Request with request body with inv data
    When Admin sends HTTPS Request to update the Admin info by Admin ID and invalid data
   Then Admin receives 400 Bad Request Status with message and boolean success details
   
   @29UpdateAdminInfoWithInvAdminID
  Scenario: Check if admin is able to update Admin details with invalid AdminId
    Given Admin creates PUT Request with request body inv AdminID
    When Admin sends HTTPS request with endpoiint to update Admin details with invalid AdminId
   Then Admin receives status 404 with Not Found error message                                                                
   
   
                                                       
    