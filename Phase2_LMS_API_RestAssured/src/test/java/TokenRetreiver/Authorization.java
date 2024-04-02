package TokenRetreiver;

import Utilities.ScenarioContext;

public class Authorization {
	
		public static ScenarioContext scenarioContext = new ScenarioContext();
		String token;
		String parsedPID;
		String pNM;
		String userId;
		
	public String setAuthorisation() {	
	
		String retrievedToken =scenarioContext.getContext("Token", token);
		return retrievedToken;
	}
	
//	public String setPMProgramID() {	
//	String ProgramID =scenarioContext.getContext("programID", parsedPID);
//	return ProgramID;
//	}
//	
//	public String setPMProgramName() {
//	String ProgramName =scenarioContext.getContext("programName", pNM);
//	return ProgramName;
//}
//	
//	public String setUserID() {
//		String userID =scenarioContext.getContext("userId", userId);
//		return userID;
//}
}

