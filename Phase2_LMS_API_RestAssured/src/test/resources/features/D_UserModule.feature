@tag
Feature: UserModule
  I want to use this template for my feature file
  
 Background: 
 Given Admin sets Authorization
 
 @tag1
  Scenario: Check if admin able to retrieve all Admins with roles
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body
    
 @tag2
  Scenario: Check if admin able to retrieve all Admins with roles with invalid endpoint
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with invalid endpoint
    Then Admin receives status 404 with Not Found error message
                                                                    
 @tag3
 Scenario: Check if admin is able to retrieve all Admins with filters
   Given Admin creates GET Request 
   When Admin sends HTTPS Request with the appropriate endpoint and filters
   Then Admin receives 200 OK Status indicating a successful request with filtered results
   
 @tag4
 Scenario: Check if admin is able to retrieve all Admins with filters with invalid endpoint
   Given Admin creates GET Request 
   When Admin sends HTTPS Request with the appropriate invalid endpoint and filters
   Then Admin receives status 404 with Not Found error message for all Admin with filters  

 @tag5
Scenario: Check if admin able to retrieve all active Admins
   Given Admin creates GET Request for all active admins
   When Admin sends HTTPS Request with endpoint for all active admins
   Then Admin receives 200 OK for all active admins
   
@tag6
 Scenario: Check if admin able to retrieve all active Admins with invalid endpoint
   Given Admin creates GET Request 
   When Admin sends HTTPS Request with invalid endpoint for all active admins
   Then Admin receives status 404 with Not Found error message for all active admins
   
@tag7
Scenario: Check if admin is able to get count of active and inactive Admins
   Given Admin creates GET Request
   When Admin sends HTTPS Request with endpoint for all type of users
   Then Admin  receices 200 OK for all type of users
   
@tag8
Scenario: Check if admin is able to get count of active and inactive Admins with invalid endpoint
   Given Admin creates GET Request
   When Admin sends HTTPS Request with invalid endpoint for all type of users
   Then Admin receives status 404 with Not Found error message for all active admins
   
   
 @tag9
Scenario: Check if admin is able to get count of active and inactive Admins by role id
   Given Admin creates GET Request with role id
   When Admin sends HTTPS Request with endpoint
   Then Admin receices 200 OK for active and inactive admins by role id
   
@tag10
Scenario: Check if admin is able to get count of active and inactive Admins by invalid role ID 
   Given Admin creates GET Request with invalid role id
   When Admin sends HTTPS Request with  active and inactive invalid endpoint 
   Then Admin receices 404 OK for active and incative admins by role ID

 @tag11
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
   Given Admin creates GET Request with valid batch Id
   When Admin sends HTTPS Request with endpoint with valid batchID
   Then Admin receives a response with status code 200 OK
   
 @tag12
Scenario: Check if admin is able to get the Admins by program batches for invalid batch ID
   Given Admin creates GET Request  with invalid batchId
   When the Admin sends a GET Request with an invalid batchId to the endpoint
   Then the Admin should receive a 404 Not Found response
   
  @tag13
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint
   Given Admin creates GET Request with valid batch Id with invalid endpoint
   When Admin sends HTTPS Request with endpoint with valid batchID with invalid endpoint
   Then Admin receives a response with status code 404 Not Found response 
   
 @tag14
Scenario: Check if admin is able to get the Admins for valid program Id
   Given Admin creates GET Request with valid program Id
   When Admin sends HTTPS Request with endpoint for valid program Id 
   Then Admin receives a response with status code 200 OK
   
   @tag15
 Scenario: Check if admin is able to get the Admins for invalid program Id
   Given Admin creates GET Request with invalid program Id
   When Admin sends HTTPS Request with endpoint invalid program Id
   Then the Admin should receive a 404 Not Found response
   
   @tag16
 Scenario: Check if admin is able to get the Admins for valid program Id with invalid endpoint
   Given Admin creates GET Request with valid program Id
   When Admin sends HTTPS Request with invalid endpoint and valid program Id 
   Then Admin receives status 404 with Not Found error message
   
    @tag17
Scenario: Check if admin is able to retreive Admins by valid role ID
   Given Admin creates GET Request with valid role ID 
   When Admin sends HTTPS Request with endpoint with valid role ID 
   Then Admin receives a response with status code 200 OK
   
   @tag18
 Scenario: Check if admin is able to retreive Admins by invalid role ID
   Given Admin creates GET Request for GET with invalid role ID
   When Admin sends HTTPS Request with endpoint and invalid role ID
   Then Admin receives status 404 with Not Found error message
   
   @tag19
 Scenario: Check if admin is able to retreive Admins by valid role ID with invalid endpoint
   Given Admin creates GET Request with valid role ID and invalid endpoint
   When Admin sends HTTPS Request with invalid endpoint and valid roleID
   Then Admin receives status 404 with Not Found error message
