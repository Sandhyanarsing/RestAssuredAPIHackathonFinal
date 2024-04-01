
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