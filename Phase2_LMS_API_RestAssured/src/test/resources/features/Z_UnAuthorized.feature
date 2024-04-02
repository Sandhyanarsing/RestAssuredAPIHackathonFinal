#
#Feature: Request with  no auth
  #I want to use this template for my feature file
#
  #
  #Background: 
 #Given admin sets Authoization to No  Auth.
#
 #@tag1
 #Scenario: Check if admin able to create a new Admin with request body without authorization
 #Given Admin creates POST request to create users with all valid and invalid requests forUserModule
 #When Admin sends HTTPS Request to create users with endpoint with no auth forUserModule
 #Then Admin receives status 401 with Unauthorized message forUserModule
 #
 #@tag2
 #Scenario: Check if admin is able to retreive all the available roles without Authorization
 #Given Admin creates GET Request forUserModule
 #When Admin sends HTTPS Request with GET All Roles endpoint with no auth forUserModule
 #Then Admin receives status 401 with Unauthorized message forUserModule