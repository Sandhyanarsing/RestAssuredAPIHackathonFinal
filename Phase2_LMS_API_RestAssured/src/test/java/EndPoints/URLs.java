package EndPoints;

public class URLs {
	
	
	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String createProgram ="/saveprogram";
	public static String userLogin = "/login";
	public static String ExcelPath = ".\\src\\main\\resources\\Data\\DataforTest.xlsx";
	public static String createUser ="/users/roleStatus";
	public static String getAllRoles ="/users";
	public static String getAllAdmins ="/users/roles/{roleId}";
	public static String InvgetAllRoles ="/uses";
	public static String UpdateUserByRoleID ="/users/roleId/{userID}";
	public static String UpdateUserRoleStatusByAdminID ="/users/roleStatus/{userID}";
	public static String UpdateUserRoleProgramBatchStatus="/users/roleProgramBatchStatus/{userId}";
	public static String UpdateAdminLoginStatusyAdminID="/users/userLogin/{userId}";
	public static String UpdateAdminInfo="/users/{userId}";
	public static String DeleteUser="/users/{userID}";
	public static String  GetProgramByProgramId = "/programs/{programId}";
	
	public static String AdminwthAllRoles = "/roles";
	public static String InvalidendPoint = "/abcd";
	public static String RoleIDV2 = "/v2/users";
	public static String RoleIDV2Invalid = "/bear";
	public static String GetAllActiveUsers = "/users/activeUsers";
	public static String GetAllActiveUsersIVEndpoint = "/http";
	public static String AllTypeofUsers =  "/users/byStatus";
	public static String AllTypeofUsersInValid =  "/upon";
	public static String AllTypeofUsersRollID = "/users/byStatus";
	public static String AllTypeofUsersRollIDInV = "/grey";
    public static String GetProgramBatches = "/users/programBatch/{Id}";
    public static String GetProgramBatchesInVBatchID = "/book";
    public static String ValidBatchIDandInvalidEndpoint = "/pong/{Id}";
    public static String ValidProgramID = "/users/programs/{programId}";
    public static String InValidProgramID = "/users/programs/{programId}";
    public static String ValidProgIDWthInvalidEndpoint = "/GoodVibes/{programId}";
    public static String GetUserByRoleID = "/users/roles/{roleId}";
    public static String GetUserByInvalidRoleID = "/users/roles/{roleId}";
    public static String InvalidEndpointwthValidRoleID = "/master/{roleId}";

    public static String PutUserUserID = "/users/";
	public static String PutUserRoleStatus = "/users/roleStatus/";
	public static String PutUserRoleID = "/users/roleId/";
	 

}
