
Feature: Post Request - Login

  Background: 
    Given admin sets Authoization to No  Auth.

  @02loginwithinvalidendpoints
  Scenario: Check if Admin able to generate token with invalid endpoint
    Given Admin creates request with valid credentials UL 
    When Admin calls Post Https method  with invalid endpoint
    Then Admin receives 401 response

  @03loginwithinvalidcredential
  Scenario: Check if Admin able to generate token with invalid credentials
    Given Admin creates request with invalid credentials
    When Admin calls Post Https method  with valid endpoint noschemavalidation
    Then Admin receives 401 response

  @01loginwithvalidcredential
  Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with valid credentials UL
    When Admin calls Post Https method  with valid endpoint UL
    Then Admin receives 200 created with auto generated token 


