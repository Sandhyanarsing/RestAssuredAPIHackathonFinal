Feature: Get/Delete Request- AdminRoleProgramBatchmap

  Background: 
    Given Admin sets Authorization

  @01getmapcontrol200response
  Scenario: Check if admin is able to retreive all Admins with assigned program batches
    When Admin sends HTTPS Request With Auth
    Then Verify 200 response displayed

  @03getmapcontrol200response
  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId
    When Admin sends HTTPS Request with ValidAdminId and Auth
    Then Verify 200 response displayed

  @04getmapcontrol404response
  Scenario: Check if admin is able to retreive assigned program batches for invalid AdminId
    When Admin sends HTTPS Request with InvalidAdminId and Auth
    Then Verify 404 response displayed

  

  @01deletemapcontrol200response
  Scenario: Check if admin is able to delete the program batch for a Admin
    When Admin creates DELETE Request to delete Admin assigned to programbatch by AdminId
    Then Verify 200 response displayed

  @02deletemapcontrol404response
  Scenario: Check if admin is able to delete the program batch for a invalid Admin
    When Admin creates DELETE Request to delete Admin assigned to programbatch by invalid AdminId
    Then Verify 404 response displayed

  