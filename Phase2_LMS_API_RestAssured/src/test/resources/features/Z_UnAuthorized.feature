Feature: No Authentication Requests

 Background: 
 Given admin sets Authoization to No Auth.

@01createprogramwithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization 
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Authpm
 Then Admin receives appropriate Status code with response body without Authpm
 
 
 @02getallprogramwithnoAuth 
Scenario: Check if Admin able to retrieve all programs without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by getpm
 Then Admin receives appropriate Status code with response body without Auth by getpm
 
 @03getprogramByProgramIDwithnoAuth 
Scenario: Check if Admin able to get a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by programidpm
 Then Admin receives appropriate Status code with response body without Auth by program idpm
 
 @04getallprogramBYAdminwithnoAuth 
Scenario: Check if Admin able to get a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by get all programpm
 Then Admin receives appropriate Status code with response body without Auth by get all programpm
 
 @05updateprogramBYprogramIDwithnoAuth 
Scenario: Check if Admin able to update a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by updateProgramIDpm
 Then Admin receives appropriate Status code with response body without Auth by updateProgramIDpm
 
 @06updateprogramByprogramNamewithnoAuth 
Scenario: Check if Admin able to update a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by update ProgramNamepm
 Then Admin receives appropriate Status code with response body without Auth by update ProgramNamepm
 
 @07DeleteprogramByProgramIDwithnoAuth 
Scenario: Check if Admin able to delete a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programidpm
 Then Admin receives appropriate Status code with response body without Auth by delete programidpm
 
 @08DeleteprogramBYPorgramNamewithnoAuth 
Scenario: Check if Admin able to delete a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programNamepm
 Then Admin receives appropriate Status code with response body without Auth by delete programNamepm

 @01CreateBatchNoAuth
Scenario: Check if user able to create a Batch with valid endpoint and request body without Authorization
 Given User creates POST batch request for the LMS API endpoint without Authorization
 When  User sends HTTP post request for batch and request body with endpoint and no authorized token
 Then  Admin receives 401 Status code without batch response body.
 
@02GetAllbatchesNoAuth
Scenario:  Check if admin able to retrieve all batches without Authorization
 Given Admin creates GET Request_noAuth 
 When  Admin sends HTTPS Request with endpoint_noAuth 
 Then  Admin receives 401 status with error message Unauthorized.
 
@03GetbatchbyBatchID_NoAuth
Scenario: Check if admin able to retrieve a batch with batchId without authorization_noAuth
 Given Admin creates GET Request with valid Batch ID_noAuth
 When  Admin sends HTTPS Request with endpoint_noAuth_batch
 Then Admin receives 401 status with error message Unauthorized.
 
@04GetbatchbyBatchName_NoAuth
Scenario: Check if admin able to retrieve a batch with batchName without authorization
 Given Admin creates GET Request with batch Name_noAuth
 When  Admin sends HTTPS Request with endpoint_noAuth 
 Then Admin receives 401 status with error message Unauthorized.
 
@05GetbatchbyProgramID_NoAuth
Scenario: Check if admin able to retrieve a batch with programID without authorization
 Given Admin creates GET Request with program id_noAuth
 When  Admin sends HTTPS Request with endpoint_noAuth 
 Then Admin receives 401 status with error message Unauthorized.
 
@06UpdateBatchNoAuth
Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body without authorization
 Given Admin creates PUT Request with valid BatchId and Data_noAuth
 When  Admin sends HTTPS PUT Request  with endpoint_noAuth
 Then  Admin receives 401 unauthorized_noAuth
 
@07DeleteBatchNoAuth
Scenario: Check if admin able to delete a Batch without authorization
 Given Admin creates DELETE Request with valid BatchId without authorization_noAuth
 When  Admin sends delete HTTPS Request with endpoint_noAuth
 Then  Admin receives 401 Unauthorized Status_noAuth 

 
 @tag1
 Scenario: Check if admin able to create a new Admin with request body without authorization
 Given Admin creates POST request to create users with all valid and invalid requests forUserModule
 When Admin sends HTTPS Request to create users with endpoint with no auth forUserModule
 Then Admin receives status 401 with Unauthorized message forUserModule
 
 @tag2
 Scenario: Check if admin is able to retreive all the available roles without Authorization
 Given Admin creates GET Request forUserModule
 When Admin sends HTTPS Request with GET All Roles endpoint with no auth forUserModule
 Then Admin receives status 401 with Unauthorized message forUserModule

 
  @02getmapcontrol401response
  Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
    When Admin sends HTTPS Request No Auth
    Then Verify 401 response displayed

  @05getmapcontrol401response
  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId  with No Authorization
    When Admin sends HTTPS Request with validAdminId and NoAuth
    Then Verify 401 response displayed

  @03deletemapcontrol401response
  Scenario: Check if admin is able to delete the program batch for valid Admin and No Authorization
    When Admin creates DELETE Request to delete Admin assigned to programbatch by valid AdminId NoAuth
    Then Verify 401 response displayed

  @01getlogoutFailure401
  Scenario: Check if Admin not able to logout
    When Admin calls Get Https method with valid endpoint No Auth
    Then Verify 401 response displayed