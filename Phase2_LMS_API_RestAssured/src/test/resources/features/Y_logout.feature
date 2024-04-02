Feature: Logout 

  Background: 
    Given Admin sets Authorization

  @01getlogoutsuccess
  Scenario: Check if Admin able to logout
    When Admin calls Get Https method with valid endpoint
    Then Verify 200 response displayed Logout

  @01getlogoutFailure404
  Scenario: Check if Admin able to logout  with invalid endpoint
    When Admin calls Get Https method withinvalid endpoint
    Then Verify 404 response displayed Logout

  @01getlogoutFailure401
  Scenario: Check if Admin not able to logout
    When Admin calls Get Https method with valid endpoint No Auth
    Then Verify 401 response displayed Logout
