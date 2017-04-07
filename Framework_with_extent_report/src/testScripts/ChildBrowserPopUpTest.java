package testScripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import genericMethods.InterfaceForDriversAndImages;
import pomPages.ChildBrowserPopUpPage;

public class ChildBrowserPopUpTest extends BaseClassForAllTestCases implements InterfaceForDriversAndImages{
	
	@Test
	public void testMethod(){
		ExtentReportClass.reportConfig(EXCEL_PATH, 3);
		ChildBrowserPopUpPage cb = new ChildBrowserPopUpPage(driver);
		try {
			cb.windowHandle();
		} catch (IOException e) {
			Reporter.log("Test is failed",true);
			e.printStackTrace();
		}
	}
	
}
