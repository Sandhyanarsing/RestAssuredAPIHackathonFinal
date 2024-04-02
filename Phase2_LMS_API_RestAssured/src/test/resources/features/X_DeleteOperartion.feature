Feature: Program Module

 Background: 
 Given Admin sets Authorization
 
 @01DeleteprogramwithinvalidprogramName
 Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName
 Given Admin creates POST Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with endpoint with invalid programNamepm
 Then Admin receives appropriate Status code with response body with invalid pname&idpm
 
 @02DeleteprogramwithinvalidprogramID
 Scenario: Check if Admin able to delete a program with valid LMS API,invalid programID
 Given Admin creates POST Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with endpoint with invalid programIDpm
 Then Admin receives appropriate Status code with response body with invalid pname&idpm
 
 @03DeleteprogramwithvalidprogramID
 Scenario: Check if Admin able to delete a program with valid LMS API,valid programID
 Given Admin creates POST Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with endpoint with valid programIDpm
 Then Admin receives appropriate Status code with response body with valid pname&idpm
 
 @04DeleteprogramwithvalidprogramName
 Scenario: Check if Admin able to delete a program with valid LMS API,valid programName
 Given Admin creates POST Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with endpoint with valid programNamepm
 Then Admin receives appropriate Status code with response body with valid pname&idpm
 
 