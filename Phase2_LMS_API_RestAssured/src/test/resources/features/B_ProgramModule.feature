
Feature: Program Module


 Background: 
 Given Admin sets Authorization
 

 @01creatingprogram
 Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admin creates POST Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with endpointpm
 Then Admin receives appropriate Status code with response bodypm
 
 
 @02createaprogrmwithinvalidmethod
 Scenario: Check if Admin able to create a program with invalid methodpm
 Given Admin creates Request for the LMS with request bodypm
 When Admin sends HTTPS Request and  request Body with invalidpm 
 Then Admin receives appropriate Status code with response body invalidpm
  
 @03createprogrmwithinvalidendpoint
  Scenario: Check if Admin able to create a program with invalid endpointpm
 Given Admin creates POST Request for the LMS with request body and invalid endpointpm
 When Admin sends HTTPS Request and  request Body with invalid endpointpm
 Then Admin receives appropriate Status code with response body invalidendpointpm
 
 @04getprogrambyprogramId
 Scenario: Check if Admin able to retrieve a program with valid program ID
 Given Admin creates GET Request for the LMS APIpm                                   
 When Admin sends HTTPS Request with endpointpm
 Then Admin receives Status with response bodypm 
 
 @5getprogrambyprogramIdwithinvalidendpoint
 Scenario: Check if Admin able to retrieve a program with invalid endpoint
 Given Admin creates GET Request for the LMS APIpm                                  
 When Admin sends HTTPS Request with invalid endpointpm
 Then Admin receives Status with response body with invalid endpointpm
  
 @6getprogrambyprogramIdwithinvalidprogramId
 Scenario: Check if Admin able to retrieve a program with invalid programId
 Given Admin creates GET Request for the LMS APIpm                                   
 When Admin sends HTTPS Request with invalid programidpm
 Then Admin receives Status with response body with invalid programidpm
 
 #@7getprogrambyprogramIdwithinvalidmethod
 #Scenario: Check if Admin able to retrieve a program with invalid method
 #Given Admin creates GET Request for the LMS APIpm                                   
 #When Admin sends HTTPS Request with invalid methodpm
 #Then Admin receives Status with response body with invalid methodpm
  
 #@8getprogrambyprogramIdwithinvalidBaseUrl
 #Scenario: Check if Admin able to retrieve a program with invalid BaseUrl
 #Given Admin creates GET Request for the LMS APIpm                                   
 #When Admin sends HTTPS Request with invalid BaseUrlpm
 #Then Admin receives Status with response body with invalid BaseUrlpm
  
 @9getallprograms
 Scenario: Check if Admin able to retrieve all programs with valid Endpoint
 Given Admin creates GET Request for the LMS API with valid endpointpm
 When Admin sends HTTPS Request with valid enpointpm
 Then Admin receives appropriate Status code with response bodypm
 
 @10getallprogramswithinvalidEndpoint
  Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
 Given Admin creates GET Request for the LMS API with invalid endpointpm
 When Admin sends HTTPS Request with invalid enpointpm
 Then Admin receives appropriate Status code with response body inpm

 @18UpdateprogramwithprogramnamewithInvalidendpoit
 Scenario: Check if Admin able to update a program with  invalid endpoint 
 Given Admin creates PUT Request for the LMS API with invalid endpointpm
 When Admin sends HTTPS Request with invalid endpoint updatepm
 Then Admin receives Status with message and boolean success details invalid endpoint update programnamepm
 
 @19UpdateprogramwithprogramnamewithInvalidMethod
  Scenario: Check if Admin able to update a program with  invalid method
 Given Admin creates PUT Request for the LMS API endpoint with valid request Body with invalid methodpm
 When Admin sends HTTPS Request with invalid method using programnamepm
 Then Admin receives Status with message and boolean success details invalidmethod using programnamepm
 
 @20UpdateprogramwithprogramnamewithInvalidBaseurl
  Scenario: Check if Admin able to update a program with invalid baseurl
 Given Admin creates PUT Request for the LMS API endpoint with valid request Body with invalid baseurlpm
 When Admin sends HTTPS Request with invalid endpoint update with invalid baseurlusing programnamepm
 Then Admin receives Status with message and boolean success details with invalid baseurlusing programnamepm
 
 
 
 @17Updateprogramwithprgramname
 Scenario: Check if Admin able to update a program with  Valid program Name and request body
 Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fieldspm
 When Admin sends HTTPS Request with valid endpoint updatepm
 Then Admin receives Status with updated value in response bodypm
 

 @21UpdateprogramwithprogramId
  Scenario: Check if Admin able to update a program with valid programid
 Given Admin creates PUT Request for the LMS API endpoint with valid request Body with programidpm
 When Admin sends HTTPS Request with endpoint update programidpm
 Then Admin receives Status with message and boolean success details  update programidpm
 
 @22UpdateprogramwithprogramIdwithInvalidendpoit
 Scenario: Check if Admin able to update a program with  invalid endpoint 
 Given Admin creates PUT Request for the LMS API with invalid enpoint By programidpm
 When Admin sends HTTPS Request with invalid endpoint update with progamidpm
 Then Admin receives Status with message and boolean success details with progmidpm

@23UpdateprogramwithprogramIdwithoutrequestbody
 Scenario: Check if Admin able to update a program without request body
 Given Admin creates PUT Request for the LMS API without request bodypm
 When Admin sends HTTPS Request with out request bodypm
 Then Admin receives Status with message and boolean success details without request bodypm
 
@24UpdateprogramwithprogramIdwithinvalidmethod
Scenario: Check if Admin able to update a program with invalid method
Given Admin creates PUT Request for the LMS API with invalid methodpm
When Admin sends HTTPS Request with invalid method with program idpm
Then Admin receives Status with message and boolean success details with invalid methodpm
 
 @25UpdateprogramwithprogramIdwithinvalidbaseurl
Scenario: Check if Admin able to update a program with invalid base url
Given Admin creates PUT Request for the LMS API with invalid base urlpm
When Admin sends HTTPS Request with invalid base urlpm
Then Admin receives Status with message and boolean success details with invalid base urlpm                                        
 
 
 
                                                        
 
 @05getprogrambyprogramId
  Scenario: Check if Admin able to retrieve a program with valid program ID
 Given Admin creates GET Request for the LMS API                                   
 When Admin sends HTTPS Request with endpoint in PM
 Then Admin receives Status with response body.

