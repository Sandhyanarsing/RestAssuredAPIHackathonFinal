Feature: Post Request

 Background: 
 Given Admin sets Authorization
 
 Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives appropriate Status code with response body.