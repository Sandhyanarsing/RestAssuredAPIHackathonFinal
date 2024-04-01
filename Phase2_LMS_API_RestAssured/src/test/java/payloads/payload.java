package payloads;

import java.util.List;
import java.util.Map;

public class payload {
	public static String UserLogin(List<Map<String, String>> data, int i) {
		String requestBody = "{\n" + "  \"password\": \"" + data.get(i).get("password") + "\",\n"
				+ "  \"userLoginEmailId\": \"" + data.get(i).get("userLoginEmailId") + "\"\n" + "}";
		// String maskedRequestBody =
		// requestBody.replaceAll("\"password\":\\s*\"[^\"]+\"", "\"password\":
		// \"*****\"");
		return requestBody;
	}
	
	public static String UserLoginInvalidCredential() {
		String requestBody = "{\n" + "  \"password\": \"Test123\",\n"
				+ "  \"userLoginEmailId\": \"Test123\",\n" + "}";
		// String maskedRequestBody =
		// requestBody.replaceAll("\"password\":\\s*\"[^\"]+\"", "\"password\":
		// \"*****\"");
		return requestBody;
	}
}