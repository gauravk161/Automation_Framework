package testScripts;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import pomPages.HandlingNewTabPage;

public class HandlingNewTabTest extends BaseClassForAllTestCases {
	ITestResult result;
	@Test
	public void newTab(){
		ExtentReportClass.reportConfig(EXCEL_PATH, 4);
		HandlingNewTabPage nTab = new HandlingNewTabPage(driver);
		try {
			nTab.parentBrowser();
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Could not take the screenshot",true);
		}
		try {
			nTab.childBrowser();
		} catch (IOException e) {
			Reporter.log("Could not take the screenshot",true);
			e.printStackTrace();
		}
	}
}
