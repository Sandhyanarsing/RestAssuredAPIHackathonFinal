Feature: Post Request

 Background: 
 Given Admin sets Authorization
 
 Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives appropriate Status code with response body.
 
 @05getprogrambyprogramId
  Scenario: Check if Admin able to retrieve a program with valid program ID
 Given Admin creates GET Request for the LMS API                                   
 When Admin sends HTTPS Request with endpoint in PM
 Then Admin receives Status with response body.