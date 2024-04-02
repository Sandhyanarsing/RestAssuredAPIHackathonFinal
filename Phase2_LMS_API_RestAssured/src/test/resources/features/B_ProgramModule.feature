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
 
 #@11getallprogramswithinvalidmethod
 #Scenario: Check if Admin able to retrieve all programs with invalid method
 #Given Admin creates GET Request for the LMS API with invalid methodpm
 #When Admin sends HTTPS Request with invalidmethodpm
 #Then Admin receives appropriate Status code with response body IMpm
 #
 #@12getallprogramswithinvalidBaseUrl
 #Scenario: Check if Admin able to retrieve all programs with invalid BaseUrl
 #Given Admin creates GET Request for the LMS API with invalid baseurlpm
 #When Admin sends HTTPS Request with invalid baseurlpm
 #Then Admin receives appropriate Status code with response body inburlpm
 
#@13getallprogramswithprogramname
 #Scenario: Check if Admin able to retrieve all programs with valid Endpoint
 #Given Admin creates GET Request for the LMS APIpm
 #When Admin sends HTTPS Request with valid endpoint userspm 
 #Then Admin receives appropriate Status code with response body userspm
 #
 #@14getallprogramwithprogramnamebyinvalidendpoint
 #Scenario: Check if Admin able to retrieve all programs with invalid endpoint
 #Given Admin creates GET Request for the LMS APIpm 
 #When Admin sends HTTPS Request with invalid endpoint userspm
 #Then Admin receives appropriate Status code with response body users invalid endpointpm
 #
 #@15getallprogramwithprogramnamebyinvalidmethod
 #Scenario: Check if Admin able to retrieve all programs with invalid method
 #Given Admin creates GET Request for the LMS APIpm 
 #When Admin sends HTTPS Request with invalid method userspm
 #Then Admin receives appropriate Status code with response body users invalid methodpm
 #
 #@16getallprogramwithprogramnamebyinvalidBaseurl
 #Scenario: Check if Admin able to retrieve all programs with invalid base url
 #Given Admin creates GET Request for the LMS APIpm 
 #When Admin sends HTTPS Request with invalid base urlpm  
 #Then Admin receives appropriate Status code with response body users invalid base urlpm
 
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
 
 
 
                                                        