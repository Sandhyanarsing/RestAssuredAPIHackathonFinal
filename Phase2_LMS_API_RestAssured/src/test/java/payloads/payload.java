package payloads;

import java.util.List;
import java.util.Map;

public class payload {
	
public static String UserLogin(List<Map<String, String>> data,int i) {
		
		String requestBody = "{\n" +
	            "  \"password\": \""+ data.get(i).get("password") +"\",\n" +
	            "  \"userLoginEmailId\": \""+ data.get(i).get("userLoginEmailId") +"\"\n" +
	            "}";
		
		//String maskedRequestBody = requestBody.replaceAll("\"password\":\\s*\"[^\"]+\"", "\"password\": \"*****\"");
		
		return requestBody;
	}
	
	


	public static String UserRequestBody(List<Map<String, String>> data, int i) {
	         String requestBody = "{" +
				    "\"userComments\": \"" + data.get(i).get("userComments") + "\",\n" +
				    "\"userEduPg\": \"" + data.get(i).get("userEduPg") + "\",\n" +
				    "\"userEduUg\": \"" + data.get(i).get("userEduUg") + "\",\n" +
				    "\"userFirstName\": \"" + data.get(i).get("userFirstName") + "\",\n" +
				    "\"userLastName\": \"" + data.get(i).get("userLastName") + "\",\n" +
				    "\"userLinkedinUrl\": \"" + data.get(i).get("userLinkedinUrl") + "\",\n" +
				    "\"userLocation\": \"" + data.get(i).get("userLocation") + "\",\n" +
				    "\"userLogin\": {" +
				        "\"loginStatus\": \"" + data.get(i).get("loginStatus") + "\",\n" +
				        "\"password\": \"" + data.get(i).get("password") + "\",\n" +
				        "\"userLoginEmail\": \"" + data.get(i).get("userLoginEmail") + "\"" +
				    "}," +
				    "\"userMiddleName\": \"" + data.get(i).get("userMiddleName") + "\",\n" +
				    "\"userPhoneNumber\": " + data.get(i).get("userPhoneNumber") + ",\n" +
				    "\"userRoleMaps\": [" +
				        "{" +
				            "\"roleId\": \"" + data.get(i).get("roleId") + "\",\n" +
				            "\"userRoleStatus\": \"" + data.get(i).get("userRoleStatus") + "\"" +
				        "}" +
				    "]," +
				    "\"userTimeZone\": \"" + data.get(i).get("userTimeZone") + "\",\n" +
				    "\"userVisaStatus\": \"" + data.get(i).get("userVisaStatus") + "\"" +
				"}";
	         
	         return requestBody;
	    }
	
	public static String UpdateUserByRoleID() {
		
		String requestBody = "{\n" +
                "  \"userRoleList\": [\n" +
                "    \"ROLE_ADMIN\"\n" +
                "  ]\n" +
                "}";
		
		return requestBody;
	}
	
public static String UpdateUserByRoleIDwithInvReqBody() {
		
		String requestBody = "{\n" +
                "  \"userRoleList\": [\n" +
                "    1234\n" +
                "  ]\n" +
                "}";
		
		return requestBody;
	}

public static String UpdateUserRoleStatusByAdminID() {
	
	String requestBody = "{\n" +
            "  \"roleId\": \"R01\",\n" +
            "  \"userRoleStatus\": \"InActive\"\n" +
            "}";
	
	return requestBody;
}

public static String UpdateUserRoleStatusByInvRoleStatus() {
	
	String requestBody = "{\n" +
            "  \"roleId\": \"R01\",\n" +
            "  \"userRoleStatus\": \"ABCD\"\n" +
            "}";
	
	return requestBody;
}

public static String UpdateUserRoleStatusByInvRoleID() {
	
	String requestBody = "{\n" +
            "  \"roleId\": \"ABC\",\n" +
            "  \"userRoleStatus\": \"Active\"\n" +
            "}";
	
	return requestBody;
}
	

public static String UpdateUserRoleProgramBatchStatus() {
	
	String requestBody = "{\n" +
            "  \"programId\": %d,\n" +
            "  \"roleId\": \"R01\",\n" +
            "  \"userRoleProgramBatches\": [\n" +
            "    {\n" +
            "      \"batchId\": %d,\n" +
            "      \"userRoleProgramBatchStatus\": \"Active\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";	
	return requestBody;
}

public static String UpdateUserRoleProgramBatchStatuswithInvData() {
	
	String requestBody = "{\n" +
            "  \"programId\": %d,\n" +
            "  \"roleId\": \"ABC\",\n" +
            "  \"userRoleProgramBatches\": [\n" +
            "    {\n" +
            "      \"batchId\": %d,\n" +
            "      \"userRoleProgramBatchStatus\": \"Active\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";	
	return requestBody;
}
public static String UpdateAdminLoginStatusyAdminID() {
	
	String requestBody = "{\n" +
            "  \"loginStatus\": \"Active\",\n" +
            "  \"password\": \"SDet01\",\n" +
            "  \"roleIds\": [\n" +
            "    \"R01\"\n" +
            "  ],\n" +
            "  \"status\": \"Active\",\n" +
            "  \"userLoginEmail\": \"abc@hij.com\"\n" +
            "}";

	return requestBody;
}

public static String UpdateAdminLoginStatusyAdminIDAndInvData() {
	
	String requestBody = "{\n" +
            "  \"loginStatus\": \"ABC\",\n" +
            "  \"password\": \"SDet01\",\n" +
            "  \"roleIds\": [\n" +
            "    \"R01\"\n" +
            "  ],\n" +
            "  \"status\": \"AbC\",\n" +
            "  \"userLoginEmail\": \"abc@hij.com\"\n" +
            "}";

	return requestBody;
}

public static String UpdateAdminInfoOnlyMandateFileds() {
	
	String requestBody = "{\n" +
			"  \"userComments\": \"\",\n" +
			"  \"userEduPg\": \"\",\n" +
			"  \"userEduUg\": \"\",\n" +
			"  \"userFirstName\": \"UpdatedFirstName\",\n" +
			"  \"userLastName\": \"UpdatedLastName\",\n" +
			"  \"userMiddleName\": \"\",\n" +
			"  \"userLinkedinUrl\": \"\",\n" +
			"  \"userLocation\": \"\",\n" +
			"  \"userPhoneNumber\": 3456781230,\n" +
			"  \"userTimeZone\": \"MST\",\n" +
			"  \"userVisaStatus\": \"H1B\"\n" +
			"}";

	return requestBody;
}

public static String UpdateAdminInfoWithAllFileds() {
	
	String requestBody = "{\n" +
			"  \"userComments\": \"ok\",\n" +
			"  \"userEduPg\": \"PUC\",\n" +
			"  \"userEduUg\": \"MBA\",\n" +
			"  \"userFirstName\": \"UpdatedFirstName2\",\n" +
			"  \"userLastName\": \"UpdatedLastName2\",\n" +
			"  \"userMiddleName\": \"AM\",\n" +
			"  \"userLinkedinUrl\": \"www.linkedin.com/asss\",\n" +
			"  \"userLocation\": \"MI\",\n" +
			"  \"userPhoneNumber\": 3456781231,\n" +
			"  \"userTimeZone\": \"MST\",\n" +
			"  \"userVisaStatus\": \"H1B\"\n" +
			"}";

	return requestBody;
}

public static String UpdateAdminInfoWithInvData() {
	
	String requestBody = "{\n" +
			"  \"userComments\": \"ok\",\n" +
			"  \"userEduPg\": \"PUC\",\n" +
			"  \"userEduUg\": \"MBA\",\n" +
			"  \"userFirstName\": \"\",\n" +
			"  \"userLastName\": \"\",\n" +
			"  \"userMiddleName\": \"AM\",\n" +
			"  \"userLinkedinUrl\": \"www.linkn.com/asss\",\n" +
			"  \"userLocation\": \"MI\",\n" +
			"  \"userPhoneNumber\": 34561231,\n" +
			"  \"userTimeZone\": \"MST\",\n" +
			"  \"userVisaStatus\": \"H1B\"\n" +
			"}";

	return requestBody;
}
public static String DummyRequestBody()
{
	
		String requestBody =  "{\n" +
				"  \"userComments\": \"ok\",\n" +
				"  \"userEduPg\": \"PUC\",\n" +
				"  \"userEduUg\": \"MBA\",\n" +
				"  \"userFirstName\": \"\",\n" +
				"  \"userLastName\": \"\",\n" +
				"  \"userMiddleName\": \"AM\",\n" +
				"  \"userLinkedinUrl\": \"www.linkn.com/asss\",\n" +
				"  \"userLocation\": \"MI\",\n" +
				"  \"userPhoneNumber\": 34561231,\n" +
				"  \"userTimeZone\": \"MST\",\n" +
				"  \"userVisaStatus\": \"H1B\"\n" +
				"}";
		return requestBody;

	}
}

