@tag
Feature: Delete Opeartion
  I want to use this template for my feature file
  
  Background:
  Given Admin sets Authorization

  @tag1
  Scenario: Check if Admin able to delete a Admin with valid Admin Id
    Given Admin creates DELETE Request to delete Admin details
    When Admin sends HTTPS request with endpoiint to delete Admin details
    Then Admin receives 200 Ok status with message

@tag1
  Scenario: Check if Admin able to delete a invalid Admin Id
    Given Admin creates DELETE Request to delete Admin details
    When Admin sends HTTPS request with endpoiint to delete Admin details with Inv AdminID
    Then Admin receives status 404 with Not Found error message
    
    
#Feature: DeleteBatch Module 
#
 #Background: 
 #Given Admin sets Authorization Token for Delete Batch
  #
#@01DeleteBatchID
#Scenario: Check if admin able to delete the Batch with valid Batch ID
 #Given Admin creates delete Request with valid BatchId
 #When  Admin sends deletebatch HTTPS Request with endpoint
 #Then  Admin receives 200 Ok status with message "deleted Batch"
  #
#@02DeleteBatch_InvalidEndpoint
#Scenario:  Check if admin able to delete a Batch with invalid endpoint
 #Given Admin creates DELETE batch Request with valid BatchId 
 #When  Admin sends delete HTTPS Request  with invalid endpoint 
 #Then  Admin receives 404 not found
 #
#@03Getbatch_InvalidBatchID
#Scenario: Check if admin able to delete a Batch with invalid Batch ID
 #Given Admin creates DELETE Request with invalid BatchId
 #When  Admin sends HTTPS Request  with endpoint 
 #Then  Admin receives 404 Not Found Status with message and boolean success details
 #
#@04GetBatch_AfterDeleteBatchId
#Scenario: Check if admin able to retrive a batch after deleting the batch 
 #Given Admin creates GET Request with valid Batch ID
 #When  Admin sends HTTPS Request with endpoint  
 #Then  Admin receives 200 OK Status with  batchStatus field "Inactive" in the response body.
 #
#@05GetbatchName_AfterDeleteBatchID
#Scenario: Check if admin able to retrive a deleted batch using batch name 
 #Given Admin creates GET Request with batch Name after deletion of batchID
 #When  Admin sends delete HTTPS Request with endpoint after deletion of batchID
 #Then Admin receives 200 OK Status with  batchStatus field "Inactive" in the response body.
 #
#@06GetBatch_AfterDeleteProgramID
#Scenario: Check if admin able to retrive a batch after the programID is deleted
 #GivenAdmin creates GET Request with program id after deletion of programID
 #When  Admin sends HTTPS DELETE Request  with endpoint after deletion of programID
 #Then  Admin receives 401 unauthorized after deletion of programID
 #
#@07UpdateBatch_DeletedProgramID
#Scenario: Check if admin able to update a Batch with a valid batchID and deleted programID field  in the request body with other mandatory fields
 #Given Admin creates PUT Request with Valid batch Id after deletion of programID
 #When  Admin sends HTTPS Request  with endpoint after deletion of programID
 #Then  Admin receives 400 Bad Request Status with message and boolean success details after deletion of programID
 #
#@08UpdateBatch_DeletedBatchID
#Scenario: Check if admin able to update a Batch with a deleted batchID in the endpoint
 #Given Admin creates PUT Request with Valid batch Id after deletion of batchID
 #When  Admin sends HTTPS Request  with endpoint after deletion of batchID
 #Then  Admin receives 200 Ok status with message after deletion of batchID

