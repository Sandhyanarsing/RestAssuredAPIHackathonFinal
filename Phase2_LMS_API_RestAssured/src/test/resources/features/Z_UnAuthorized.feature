

Feature: Request with  no auth
  I want to use this template for my feature file

  
  Background: 
 Given admin sets Authoization to No  Auth.

 @tag1
 Scenario: Check if admin able to create a new Admin with request body without authorization
 Given Admin creates POST request to create users with all valid and invalid requests
 When Admin sends HTTPS Request to create users with endpoint with no auth
 Then Admin receives status 401 with Unauthorized message
 
 @tag2
 Scenario: Check if admin is able to retreive all the available roles without Authorization
 Given Admin creates GET Request
 When Admin sends HTTPS Request with GET All Roles endpoint with no auth
 Then Admin receives status 401 with Unauthorized message

  
#@01CreateBatchNoAuth
#Scenario: Check if user able to create a Batch with valid endpoint and request body without Authorization
 #Given User creates POST batch request for the LMS API endpoint without Authorization
 #When  User sends HTTP post request for batch and request body with endpoint and no authorized token
 #Then  Admin receives 401 Status code without batch response body.
 #
#@02GetAllbatchesNoAuth
#Scenario:  Check if admin able to retrieve all batches without Authorization
 #Given Admin creates GET Request_noAuth 
 #When  Admin sends HTTPS Request with endpoint_noAuth 
 #Then  Admin receives 401 status with error message Unauthorized.
 #
#@03GetbatchbyBatchID_NoAuth
#Scenario: Check if admin able to retrieve a batch with batchId without authorization_noAuth
 #Given Admin creates GET Request with valid Batch ID_noAuth
 #When  Admin sends HTTPS Request with endpoint_noAuth
 #Then Admin receives 401 status with error message Unauthorized.
 #
#@04GetbatchbyBatchName_NoAuth
#Scenario: Check if admin able to retrieve a batch with batchName without authorization
 #Given Admin creates GET Request with batch Name_noAuth
 #When  Admin sends HTTPS Request with endpoint_noAuth 
 #Then Admin receives 401 status with error message Unauthorized.
 #
#@05GetbatchbyProgramID_NoAuth
#Scenario: Check if admin able to retrieve a batch with programID without authorization
 #Given Admin creates GET Request with program id_noAuth
 #When  Admin sends HTTPS Request with endpoint_noAuth 
 #Then Admin receives 401 status with error message Unauthorized.
 #
#@06UpdateBatchNoAuth
#Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body without authorization
 #Given Admin creates PUT Request with valid BatchId and Data_noAuth
 #When  Admin sends HTTPS PUT Request  with endpoint_noAuth
 #Then  Admin receives 401 unauthorized_noAuth
 #
#@07DeleteBatchNoAuth
#Scenario: Check if admin able to delete a Batch without authorization
 #Given Admin creates DELETE Request with valid BatchId without authorization_noAuth
 #When  Admin sends delete HTTPS Request with endpoint_noAuth
 #Then  Admin receives 401 Unauthorized Status_noAuth 
 #

