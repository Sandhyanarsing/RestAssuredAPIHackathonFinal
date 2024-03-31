package TokenRetreiver;

import Utilities.ScenarioContext;

public class Authorization {
	
		public static ScenarioContext scenarioContext = new ScenarioContext();
		String token;
		
	public String getAuthorisation() {	
	
		String retrievedToken =scenarioContext.getContext("Token", token);
		//RestAssured.given().header("Authorization", "Bearer "+ retrievedToken);
		//System.out.println(retrievedToken);
		return retrievedToken;
	}
}

