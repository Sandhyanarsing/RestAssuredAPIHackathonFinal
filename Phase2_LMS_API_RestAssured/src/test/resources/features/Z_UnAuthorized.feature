
Feature: Program Module

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
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by programidpm
 Then Admin receives appropriate Status code with response body without Auth by program idpm
 
 @04getallprogramBYAdminwithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by get all programpm
 Then Admin receives appropriate Status code with response body without Auth by get all programpm
 
 @05updateprogramBYprogramIDwithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by updateProgramIDpm
 Then Admin receives appropriate Status code with response body without Auth by updateProgramIDpm
 
 @06updateprogramByprogramNamewithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by update ProgramNamepm
 Then Admin receives appropriate Status code with response body without Auth by update ProgramNamepm
 
 @07DeleteprogramByProgramIDwithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programidpm
 Then Admin receives appropriate Status code with response body without Auth by delete programidpm
 
 @08DeleteprogramBYPorgramNamewithnoAuth 
Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body without Authpm
 When Admin sends HTTPS Request and  request Body with endpoint without Auth by delete programNamepm
 Then Admin receives appropriate Status code with response body without Auth by delete programNamepm
 