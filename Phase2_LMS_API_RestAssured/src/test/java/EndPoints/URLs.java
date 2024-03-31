package EndPoints;

public class URLs {
	
	
	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String createProgram ="/saveprogram";
	public static String userLogin = "/login";
	public static String ExcelPath = ".\\src\\main\\resources\\Data\\DataforTest.xlsx";
	public static String createUser ="/users/roleStatus";
	public static String getAllRoles ="/users";
	public static String InvgetAllRoles ="/uses";
	public static String UpdateUserByRoleID ="/users/roleId/{userID}";
	public static String UpdateUserRoleStatusByAdminID ="/users/roleStatus/{userID}";
	public static String UpdateUserRoleProgramBatchStatus="/users/roleProgramBatchStatus/{userId}";
	public static String UpdateAdminLoginStatusyAdminID="/users/userLogin/{userId}";
	public static String UpdateAdminInfo="/users/{userId}";
	public static String DeleteUser="/users/{userID}";

}
