package genericMethods;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MethodToCaptureScreenshot extends BaseClassForAllTestCases implements InterfaceForDriversAndImages {
	public static String appendingScreenshotToTheReport(String name){

	/*	System.out.print("Enter the name of the PNG file: ");
		@SuppressWarnings("resource")
		Scanner sc3 = new Scanner(System.in);
		String name = sc3.nextLine();*/
		
//		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 1,0);
		
		TakesScreenshot snap = (TakesScreenshot) driver;
		
		File newFile = snap.getScreenshotAs(OutputType.FILE);
		
		String filePath = IMAGE_PATH+name+".PNG";
		
		File destFile = new File (filePath);
		
		

		try {
			org.apache.commons.io.FileUtils.copyFile(newFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}


}
