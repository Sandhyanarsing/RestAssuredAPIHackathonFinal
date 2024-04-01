#Feature: Unauthorized 
#
#Background: 
#Given admin sets Authoization token to No Auth.
  #
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
#
 #
 #
 #
 #
 #
 #
 #
 #
#
 #
#
