package payloads;

import java.util.List;
import java.util.Map;

public class payload {
	public static String ProgramData(List<Map<String, String>> data,int i) {
		String  requestBody = "{\n" +
                 "  \"programDescription\": \"" + data.get(i).get("ProgramDescription") + "\",\n" +
                 "  \"programName\": \"" + data.get(i).get("ProgramName") + "\",\n" +
                 "  \"programStatus\": \"" + data.get(i).get("ProgramStatus") + "\"\n" +
                 "}";
		return requestBody;
	}
		public static String UpdateProgramData(List<Map<String, String>> data,int i) {
			String  requestBody = "{\n" +
	                 "  \"programDescription\": \"" + data.get(i).get("ProgramDescription") + "\",\n" +
	                 "  \"programName\": \"" + data.get(i).get("UpdateProgramByProgramName") + "\",\n" +
	                 "  \"programStatus\": \"" + data.get(i).get("UpdatedStatus") + "\"\n" +
	                 "}";
			return requestBody;
			}
		

			
		
}
