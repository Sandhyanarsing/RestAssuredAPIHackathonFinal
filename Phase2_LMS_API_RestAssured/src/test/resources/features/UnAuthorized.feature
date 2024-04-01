
Feature: Request with  no auth
  I want to use this template for my feature file

  Background: 
    Given admin sets Authoization to No  Auth.

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
    Then Verify 401 response displayed Logout




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

