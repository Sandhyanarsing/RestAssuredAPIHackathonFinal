package EndPoints;

public class URLs {
	
	
	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static String createProgram ="/saveprogram";
	public static String userLogin = "/login";
	public static String ExcelPath = ".\\src\\main\\resources\\Data\\DataforTest.xlsx";
	public static String createBatch ="/batches";
	public static String createBatchInvalidEP ="/batches-lms";
	public static String GetallBatch ="/batches";
	public static String GetbyBatchID ="/batches/batchId/{batchId}";
	public static String GetbyBatchName ="/batches/batchName/{batchName}";
	public static String GetBatchbyProgramID ="/batches/program/{programId}";
	public static String updateBatch ="/batches/{batchId}";
	public static String updateBatchInvalidEP ="/batches-lms/{batchId}";
	public static String deleteBatch = "/batches/{id}";


}
