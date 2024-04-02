
Feature: UserLogin Controller

  Background: 
    Given admin sets Authoization to No Auth.

  #@02loginwithinvalidendpoints
  #Scenario: Check if Admin able to generate token with invalid endpoint UL
    #Given Admin creates request with valid credentials UL 
    #When Admin calls Post Https method  with invalid endpoint UL
    #Then Admin receives 401 response
#
  #@03loginwithinvalidcredential
  #Scenario: Check if Admin able to generate token with invalid credentials 
    #Given Admin creates request with invalid credentials UL
    #When Admin calls Post Https method with valid endpoint noschemavalidation UL
    #Then Admin receives 401 response UL

  @01loginwithvalidcredential
  Scenario: Check if Admin able to generate token with valid userlogin credential 
    Given Admin creates request with valid userlogin credentials UL
    When Admin calls Post Https method  with valid userlogin endpoint UL
    Then Admin receives {int} created with auto generated token UL 


