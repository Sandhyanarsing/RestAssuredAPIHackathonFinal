
@tag
Feature: Delete Opeartion
  I want to use this template for my feature file
  
  Background:
  Given Admin sets Authorization

  @tag1
  Scenario: Check if Admin able to delete a Admin with valid Admin Id
    Given Admin creates DELETE Request to delete Admin details forUserModule
    When Admin sends HTTPS request with endpoiint to delete Admin details forUserModule
    Then Admin receives 200 Ok status with message forUserModule

@tag1
  Scenario: Check if Admin able to delete a invalid Admin Id 
    Given Admin creates DELETE Request to delete Admin details forUserModule
    When Admin sends HTTPS request with endpoiint to delete Admin details with Inv AdminID forUserModule
    Then Admin receives status 404 with Not Found error message forUserModule
   
