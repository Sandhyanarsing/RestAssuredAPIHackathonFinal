package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	//Test comments
	public static int totalRow;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;



	public static List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}

	private static List<Map<String, String>> readSheet(Sheet sheet) {

	    totalRow = sheet.getLastRowNum();

	    List<Map<String, String>> excelRows = new ArrayList<>();
	    DataFormatter dataFormatter = new DataFormatter();

	    for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
	        Row row = sheet.getRow(currentRow);

	        if (row != null) {
	            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();

	            int totalColumn = row.getLastCellNum();

	            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
	                Cell cell = row.getCell(currentColumn);
	                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                            .getStringCellValue();

	                if (cell != null) {
	                    

	                    // Use a DataFormatter to handle different cell types
	                    String cellValue = dataFormatter.formatCellValue(cell);

	                    columnMapdata.put(columnHeaderName, cellValue);
	                } else {
	                    // Handle the case when the cell is null, for example, by adding an empty string
	                    columnMapdata.put(columnHeaderName, "");
	                }
	            }

	            excelRows.add(columnMapdata);
	        }
	    }

	    return excelRows;
	}
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}

		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);

		sheet=workbook.getSheet(sheetName);

		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);

		cell=row.createCell(colnum);
		cell.setCellValue(data);

		fo=new FileOutputStream(path);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}	

	
}