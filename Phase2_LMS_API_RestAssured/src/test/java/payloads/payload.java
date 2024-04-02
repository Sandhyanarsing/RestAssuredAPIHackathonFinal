package payloads;

import java.util.List;
import java.util.Map;

import TokenRetreiver.Authorization;
import lmsApiConstants.LMSConstants;

public class payload {
//Program Module Payloads
	public static String ProgramData(List<Map<String, String>> data, int i) {
		String requestBody = "{\n" + "  \"programDescription\": \"" + data.get(i).get("ProgramDescription") + "\",\n"
				+ "  \"programName\": \"" + data.get(i).get("ProgramName") + "\",\n" + "  \"programStatus\": \""
				+ data.get(i).get("ProgramStatus") + "\"\n" + "}";
		return requestBody;
	}
	public static String ProgramData_invalidreqbody() {
		String requestBody = "{\n" + "  \"programDescription\": \"" +"ProgramDescription" + "\",\n"
				+ "  \"programName\": \"" +"ProgramName" + "\",\n" + "  \"programStatus\": \""
				+ "Active" + "\"\n" + "}";
		return requestBody;
	}
	public static String UpdateProgramData(List<Map<String, String>> data, int i) {
		String requestBody = "{\n" + "  \"programDescription\": \"" + data.get(i).get("ProgramDescription") + "\",\n"
				+ "  \"programName\": \"" + data.get(i).get("UpdateProgramByProgramName") + "\",\n"
				+ "  \"programStatus\": \"" + data.get(i).get("UpdatedStatus") + "\"\n" + "}";
		return requestBody;
	}
	public static String inavaliddata() {
		String  requestBody = "{\n" +
                 "  \"programDescription\":  \"rost\",\n"  + "\",\n" +
                 "  \"programName\":  \"strt\",\n"  + "\",\n" +
                 "  \"programStatus\":  \"Active\",\n"  + "\"\n" +
                 "}";
		return requestBody;
		}

//UserLogin Payloads
	public static String UserLoginInvalidCredential() {
		String requestBody = "{\n" + "  \"password\": \"Test123\",\n" + "  \"userLoginEmailId\": \"Test123\",\n" + "}";
		// String maskedRequestBody =
		// requestBody.replaceAll("\"password\":\\s*\"[^\"]+\"", "\"password\":
		// \"*****\"");
		return requestBody;
	}

	public static String UserLogin(List<Map<String,String>> data,int i) {

		String requestBody = "{\n" + "  \"password\": \"" + data.get(i).get("password") + "\",\n"
				+ "  \"userLoginEmailId\": \"" + data.get(i).get("userLoginEmailId") + "\"\n" + "}";

       //System.out.println(requestBody);
		return requestBody;
	}
//User Module Payloads
	public static String UserRequestBody(List<Map<String, String>> data, int i) {
		String requestBody = "{" + "\"userComments\": \"" + data.get(i).get("userComments") + "\",\n"
				+ "\"userEduPg\": \"" + data.get(i).get("userEduPg") + "\",\n" + "\"userEduUg\": \""
				+ data.get(i).get("userEduUg") + "\",\n" + "\"userFirstName\": \"" + data.get(i).get("userFirstName")
				+ "\",\n" + "\"userLastName\": \"" + data.get(i).get("userLastName") + "\",\n"
				+ "\"userLinkedinUrl\": \"" + data.get(i).get("userLinkedinUrl") + "\",\n" + "\"userLocation\": \""
				+ data.get(i).get("userLocation") + "\",\n" + "\"userLogin\": {" + "\"loginStatus\": \""
				+ data.get(i).get("loginStatus") + "\",\n" + "\"password\": \"" + data.get(i).get("password") + "\",\n"
				+ "\"userLoginEmail\": \"" + data.get(i).get("userLoginEmail") + "\"" + "}," + "\"userMiddleName\": \""
				+ data.get(i).get("userMiddleName") + "\",\n" + "\"userPhoneNumber\": "
				+ data.get(i).get("userPhoneNumber") + ",\n" + "\"userRoleMaps\": [" + "{" + "\"roleId\": \""
				+ data.get(i).get("roleId") + "\",\n" + "\"userRoleStatus\": \"" + data.get(i).get("userRoleStatus")
				+ "\"" + "}" + "]," + "\"userTimeZone\": \"" + data.get(i).get("userTimeZone") + "\",\n"
				+ "\"userVisaStatus\": \"" + data.get(i).get("userVisaStatus") + "\"" + "}";

		return requestBody;
	}

	public static String UpdateUserByRoleID() {

		String requestBody = "{\n" + "  \"userRoleList\": [\n" + "    \"ROLE_ADMIN\"\n" + "  ]\n" + "}";

		return requestBody;
	}

	public static String UpdateUserByRoleIDwithInvReqBody() {

		String requestBody = "{\n" + "  \"userRoleList\": [\n" + "    1234\n" + "  ]\n" + "}";

		return requestBody;
	}

	public static String UpdateUserRoleStatusByAdminID() {

		String requestBody = "{\n" + "  \"roleId\": \"R01\",\n" + "  \"userRoleStatus\": \"InActive\"\n" + "}";

		return requestBody;
	}

	public static String UpdateUserRoleStatusByInvRoleStatus() {

		String requestBody = "{\n" + "  \"roleId\": \"R01\",\n" + "  \"userRoleStatus\": \"ABCD\"\n" + "}";

		return requestBody;
	}

	public static String UpdateUserRoleStatusByInvRoleID() {

		String requestBody = "{\n" + "  \"roleId\": \"ABC\",\n" + "  \"userRoleStatus\": \"Active\"\n" + "}";

		return requestBody;
	}

	public static String UpdateUserRoleProgramBatchStatus() {

		String requestBody = "{\n" + "  \"programId\": %d,\n" + "  \"roleId\": \"R01\",\n"
				+ "  \"userRoleProgramBatches\": [\n" + "    {\n" + "      \"batchId\": %d,\n"
				+ "      \"userRoleProgramBatchStatus\": \"Active\"\n" + "    }\n" + "  ]\n" + "}";
		return requestBody;
	}

	public static String UpdateUserRoleProgramBatchStatuswithInvData() {

		String requestBody = "{\n" + "  \"programId\": %d,\n" + "  \"roleId\": \"ABC\",\n"
				+ "  \"userRoleProgramBatches\": [\n" + "    {\n" + "      \"batchId\": %d,\n"
				+ "      \"userRoleProgramBatchStatus\": \"Active\"\n" + "    }\n" + "  ]\n" + "}";
		return requestBody;
	}

	public static String UpdateAdminLoginStatusyAdminID() {

		String requestBody = "{\n" + "  \"loginStatus\": \"Active\",\n" + "  \"password\": \"SDet01\",\n"
				+ "  \"roleIds\": [\n" + "    \"R01\"\n" + "  ],\n" + "  \"status\": \"Active\",\n"
				+ "  \"userLoginEmail\": \"abc@hij.com\"\n" + "}";

		return requestBody;
	}

	public static String UpdateAdminLoginStatusyAdminIDAndInvData() {

		String requestBody = "{\n" + "  \"loginStatus\": \"ABC\",\n" + "  \"password\": \"SDet01\",\n"
				+ "  \"roleIds\": [\n" + "    \"R01\"\n" + "  ],\n" + "  \"status\": \"AbC\",\n"
				+ "  \"userLoginEmail\": \"abc@hij.com\"\n" + "}";

		return requestBody;
	}

	public static String UpdateAdminInfoOnlyMandateFileds() {

		String requestBody = "{\n" + "  \"userComments\": \"\",\n" + "  \"userEduPg\": \"\",\n"
				+ "  \"userEduUg\": \"\",\n" + "  \"userFirstName\": \"UpdatedFirstName\",\n"
				+ "  \"userLastName\": \"UpdatedLastName\",\n" + "  \"userMiddleName\": \"\",\n"
				+ "  \"userLinkedinUrl\": \"\",\n" + "  \"userLocation\": \"\",\n"
				+ "  \"userPhoneNumber\": 3456781230,\n" + "  \"userTimeZone\": \"MST\",\n"
				+ "  \"userVisaStatus\": \"H1B\"\n" + "}";

		return requestBody;
	}

	public static String UpdateAdminInfoWithAllFileds() {

		String requestBody = "{\n" + "  \"userComments\": \"ok\",\n" + "  \"userEduPg\": \"PUC\",\n"
				+ "  \"userEduUg\": \"MBA\",\n" + "  \"userFirstName\": \"UpdatedFirstName2\",\n"
				+ "  \"userLastName\": \"UpdatedLastName2\",\n" + "  \"userMiddleName\": \"AM\",\n"
				+ "  \"userLinkedinUrl\": \"www.linkedin.com/asss\",\n" + "  \"userLocation\": \"MI\",\n"
				+ "  \"userPhoneNumber\": 3456781231,\n" + "  \"userTimeZone\": \"MST\",\n"
				+ "  \"userVisaStatus\": \"H1B\"\n" + "}";

		return requestBody;
	}

	public static String UpdateAdminInfoWithInvData() {

		String requestBody = "{\n" + "  \"userComments\": \"ok\",\n" + "  \"userEduPg\": \"PUC\",\n"
				+ "  \"userEduUg\": \"MBA\",\n" + "  \"userFirstName\": \"\",\n" + "  \"userLastName\": \"\",\n"
				+ "  \"userMiddleName\": \"AM\",\n" + "  \"userLinkedinUrl\": \"www.linkn.com/asss\",\n"
				+ "  \"userLocation\": \"MI\",\n" + "  \"userPhoneNumber\": 34561231,\n"
				+ "  \"userTimeZone\": \"MST\",\n" + "  \"userVisaStatus\": \"H1B\"\n" + "}";

		return requestBody;
	}

	public static String DummyRequestBody() {

		String requestBody = "{\n" + "  \"userComments\": \"ok\",\n" + "  \"userEduPg\": \"PUC\",\n"
				+ "  \"userEduUg\": \"MBA\",\n" + "  \"userFirstName\": \"\",\n" + "  \"userLastName\": \"\",\n"
				+ "  \"userMiddleName\": \"AM\",\n" + "  \"userLinkedinUrl\": \"www.linkn.com/asss\",\n"
				+ "  \"userLocation\": \"MI\",\n" + "  \"userPhoneNumber\": 34561231,\n"
				+ "  \"userTimeZone\": \"MST\",\n" + "  \"userVisaStatus\": \"H1B\"\n" + "}";
		return requestBody;

	}
//Batch Module Payloads
	public static String PostBatchRequestBody(List<Map<String, String>> data, int i) {

		String programId = data.get(i).get("programId") != null && data.get(i).get("programId").equals("")
				? Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY)
				: data.get(i).get("programId");
		String requestBody = "{\n" + "  \"batchDescription\": \"" + data.get(i).get("batchDescription") + "\",\n"
				+ "  \"batchName\": \"" + data.get(i).get("batchName") + "\",\n" + "  \"batchStatus\": \""
				+ data.get(i).get("batchStatus") + "\",\n" + "  \"batchNoOfClasses\": \""
				+ data.get(i).get("batchNoOfClasses") + "\",\n" + "  \"programId\": \"" + programId + "\",\n"
				+ "  \"programName\": \"" + Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY)
				+ "\"\n" + "}";
		return requestBody;

	}

	public static String PutBatchRequestBody(List<Map<String, String>> data, int i) {

		String programId = data.get(i).get("programId") != null && data.get(i).get("programId").equals("")
				? Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY)
				: data.get(i).get("programId");
		String batchId = data.get(i).get("batchId") != null && data.get(i).get("batchId").equals("")
				? Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY)
				: data.get(i).get("batchId");

		String requestBody = "{\n" + "  \"batchDescription\": \"" + data.get(i).get("PUTbatchDescription") + "\",\n"
				+ "  \"batchId\": \"" + batchId + "\",\n" + "  \"batchName\": \"" + data.get(i).get("PUTbatchName")
				+ "\",\n" + "  \"batchStatus\": \"" + data.get(i).get("PUTbatchStatus") + "\",\n"
				+ "  \"batchNoOfClasses\": \"" + data.get(i).get("PUTbatchNoOfClasses") + "\",\n"
				+ "  \"programId\": \"" + programId + "\",\n" + "  \"programName\": \""
				+ Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY) + "\"\n" + "}";

		return requestBody;
	}

	public static String BatchReqBody_Standard() {

		String requestBody = "{\n" + "  \"batchDescription\": \"\" ,\n" + "  \"batchId\": \"\" ,\n"
				+ "  \"batchName\": \"\" ,\n" + "  \"batchStatus\": \"\" ,\n" + "  \"batchNoOfClasses\": \"\" ,\n"
				+ "  \"programId\": \"\" ,\n" + "  \"programName\": \"\" ,\n" + "}";

		return requestBody;
	}

	public static String PutBatchReqBody_Postbatchdelete(List<Map<String, String>> data, int i) {

		String requestBody = "{\n" + "  \"batchDescription\": \"" + data.get(i).get("PUTbatchDescription") + "\",\n"
				+ "  \"batchId\": \"" + Authorization.scenarioContext.getContext(LMSConstants.BATCHID_KEY) + "\",\n"
				+ "  \"batchName\": \"" + "" + "\",\n" + "  \"batchStatus\": \"" + "InActive " + "\",\n"
				+ "  \"batchNoOfClasses\": \"" + data.get(i).get("PUTbatchNoOfClasses") + "\",\n"
				+ "  \"programId\": \"" + Authorization.scenarioContext.getContext(LMSConstants.PROGRAMID_KEY) + "\",\n"
				+ "  \"programName\": \"" + Authorization.scenarioContext.getContext(LMSConstants.PROGRAMNAME_KEY)
				+ "\"\n" + "}";
		// System.out.println(requestBody);
		return requestBody;
	}

}
