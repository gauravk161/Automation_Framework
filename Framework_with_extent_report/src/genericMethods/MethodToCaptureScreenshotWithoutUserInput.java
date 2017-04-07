package genericMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MethodToCaptureScreenshotWithoutUserInput extends BaseClassForAllTestCases {

	public static String snap(){

		TakesScreenshot snap = (TakesScreenshot) driver;

		File newFile = snap.getScreenshotAs(OutputType.FILE);

		String filePath = "C:\\Users\\GAURAV\\Desktop\\Selenium\\Workspaces\\Automation FrameWork\\Framework_with_extent_report\\Snapshot\\No_User_Input.PNG";

		File destFile = new File (filePath);



		try {
			org.apache.commons.io.FileUtils.copyFile(newFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

}
