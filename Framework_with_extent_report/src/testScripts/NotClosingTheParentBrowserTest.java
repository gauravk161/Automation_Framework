package testScripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import pomPages.NotClosingTheParentBrowserPage;

public class NotClosingTheParentBrowserTest extends BaseClassForAllTestCases {

	@Test
	public void closingChildBrowser(){
		ExtentReportClass.reportConfig(EXCEL_PATH, 5);
		try {
			NotClosingTheParentBrowserPage.parentBrowserOpen();
		} catch (IOException e) {
			Reporter.log("Test is failed",true);
			e.printStackTrace();
		}
	}
}
