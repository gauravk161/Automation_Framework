package testScripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import pomPages.FacebookListBoxPage;

public class FacebookListBoxTest extends BaseClassForAllTestCases {


	@Test
	public void listBoxContent(){
		ExtentReportClass.reportConfig(EXCEL_PATH,2);
		FacebookListBoxPage fb = new FacebookListBoxPage(driver);
		try {
			fb.getContentOfListBox();
		} catch (IOException e) {
			Reporter.log("Could not proceed with the test case",true);
			e.printStackTrace();
		}
	}

}
