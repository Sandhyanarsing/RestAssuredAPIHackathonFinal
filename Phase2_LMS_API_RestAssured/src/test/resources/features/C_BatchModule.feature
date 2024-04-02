Feature: Batch Module Controller

 Background: 
 Given Admin sets Authorization Token for Batch
 
@01CreateBatchID
Scenario: Check if admin able to create a Batch with valid Batch ID
 Given User creates POST request for the LMS API endpoint	
 When  User sends HTTPS post request for batch and request body with endpoint
 Then  Admin receives appropriate batch POST response Status code with response body.
 
@02CreateBatchInvalidEndpoint404
Scenario: Check if admin able to create a batch with invalid endpoint
  Given User creates POST request for the LMS API  invalid endpoint
  When  User sends HTTPS post request for batch and request body with invalid endpoint
  Then  Admin receives 404 not found Status code .                                        
  
@03GetAllBatches 
Scenario: Check if admin able to retrieve all batches  with valid LMS API
  Given Admin creates GET Request for all batches
  When  Admin sends HTTPS GetallBatches Request with endpoint  
  Then  Admin receives 200 OK Status with response body.                                                                
  
@04GetAllBatches_InvalidEndpoint 
Scenario: Check if admin able to retrieve all batches with invalid Endpoint
  Given Admin creates GetAllBatches_InvalidEndpoint 
  When Admin sends HTTPS Request with invalid endpoint 
  Then Admin receives 404 GetAllBatches_InvalidEndpoint status with error message Not Found .    
  
@05GetAllBatches_SearchString
Scenario: Check if admin able to retrieve all batches with search string
  Given Admin creates GET Request SearchString 
  When Admin sends HTTPS GetAllBatches_SearchString Request with endpoint 
  Then Admin receives 200 GetAllBatches_SearchString Ok status with response body   
 
@06GetbyvalidBatchID
Scenario: Check if admin able to retrieve a batch with valid BATCH ID
  Given Admin creates GetbyvalidBatchID Request with valid Batch ID
  When  Admin sends HTTPS GetbyvalidBatchID Request with endpoint 
  Then Admin receives 200 OK Status with response body GetbyvalidBatchID.                                                                   
  
@07GetbyInvalidBatchID
Scenario: Check if admin able to retrieve a batch with invalid BATCH ID
  Given Admin creates GET Request with invalid Batch ID
  When  Admin sends HTTPS GetbyInvalidBatchID Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details GetbyInvalidBatchID. 
  
@08GetbatchID_InvalidEndpoint
Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GetbatchID_InvalidEndpoint Request with valid Batch ID
  When  Admin sends HTTPS GetbatchID_InvalidEndpoint Request with invalid endpoint 
  Then Admin receives 404 not found  Status GetbatchID_InvalidEndpoint
  
@09GetbyvalidBatchName
Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
  Given Admin creates GetbyvalidBatchName Request with valid Batch Name
  When  Admin sends HTTPS GetbyvalidBatchName Request with endpoint 
  Then Admin receives 200 OK Status with response body GetbyvalidBatchName.                                                                   
  
@10GetbyInvalidBatchName
Scenario: Check if admin able to retrieve a batch with invalid BATCH NAME
  Given Admin creates GetbyInvalidBatchName Request with invalid Batch Name
  When  Admin sends HTTPS GetbyInvalidBatchName Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details GetbyInvalidBatchName
  
@11GetBatchName_InvalidEndPoint
Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GetBatchName_InvalidEndPoint Request with valid Batch Name
  When  Admin sends HTTPS GetBatchName_InvalidEndPoint Request with invalid endpoint 
  Then Admin receives 404 Not found GetBatchName_InvalidEndPoint
  
@12GetBatchByProgramID
Scenario: Check if admin able to retrieve a batch with valid Program ID
  Given Admin creates GetBatchByProgramID Request with program id
  When  Admin sends HTTPS GetBatchByProgramID Request with endpoint 
  Then Admin receives 200 OK Status with response body GetBatchByProgramID.                                                                   
  
@13GetBatchBy_InvalidProgramID
Scenario: Check if admin able to retrieve a batch with invalid Program Id
  Given Admin creates GetBatchBy_InvalidProgramID Request with invalid Program Id
  When  Admin sends HTTPS GetBatchBy_InvalidProgramID Request with endpoint 
  Then  Admin receives 404 Not Found Status with message and boolean success details GetBatchBy_InvalidProgramID 
  
@14GetBatch_InvalidEndpoint
Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GetBatch_InvalidEndpoint Request with invalid endpoint
  When  Admin sends HTTPS GetBatch_InvalidEndpoint Request with endpoint 
  Then Admin receives 404 GetBatch_InvalidEndpoint Status with  error message Not Found. 
  
@15UpdateBatchID
Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
  Given Admin creates PUT Request UpdateBatchID with valid BatchId and Data
  When  Admin sends HTTPS UpdateBatchID Request  with endpoint
  Then Admin receives respective batch PUT response Status in response body. 
  
@16UpdateBatchID_InvalidEndpoint
Scenario: Check if admin able to update a Batch with invalid enpoint
  Given Admin creates PUT Request UpdateBatchID_InvalidEndpoint with Valid batch Id
  When Admin sends HTTPS UpdateBatchID_InvalidEndpoint Request  with invalid endpoint
  Then Admin receives 404 UpdateBatchID_InvalidEndpoint not found. 