package EndPoints;

public class URLs {
	
	
	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String createProgram ="/saveprogram";
	public static String  GetAllPrograms = "/allPrograms";
	public static String  GetAllProgramswithUsers = "/allProgramsWithUsers";
	public static String  GetProgramByProgramId = "/programs/{programId}";
	public static String  UpdateProgramByProgramName = "/program/{programName}";
	public static String  UpdateProgramByProgramId = "/putprogram/{programId}";
	public static String  DeleteProgramByProgramId = " /deletebyprogid/{programId}";
	public static String  DeleteProgramByProgramName = " /deletebyprogname/{programName}";
	public static String  InvalidEndPoint = "/byprogna";
	public static String userLogin = "/login";
	public static String ExcelPath = ".\\src\\main\\resources\\Data\\DataforTest.xlsx";
    public static String Invalidprogramid = "145";
    public static String InvalidBaseURL = "https://lms-marchapi-hackathocom/lms";
	
	public static String Invalidprogramname = "rose";
	//public static String token ="";

}
