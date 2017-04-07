package genericMethods;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel{
	public static Workbook wb;
	public static FileInputStream fis;
	
	public static String getCellValue(String filePath,int sheetNumber,int row,int col){
		String cellValue="";
		try{
		fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
		cellValue=wb.getSheetAt(sheetNumber).getRow(row).getCell(col).toString();
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
		return cellValue;
	}
	
	public static int getRow(String filePath,int sheetNumber){
		int rowValue=0;
		try{
		fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
		rowValue=wb.getSheetAt(sheetNumber).getLastRowNum();
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
		return rowValue;
	}
	
	
}
