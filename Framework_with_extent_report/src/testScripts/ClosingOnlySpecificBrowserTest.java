package testScripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericMethods.BaseClassForAllTestCases;
import pomPages.ClosingOnlySpecificBrowserPage;

public class ClosingOnlySpecificBrowserTest extends BaseClassForAllTestCases {

	@Test
	public void closeAnyBrowser(){
		ClosingOnlySpecificBrowserPage cb=new ClosingOnlySpecificBrowserPage();
		try {
			cb.closeSpecificBrowser();
		} catch (IOException e) {
			Reporter.log("Cannot generate the Report",true);
			e.printStackTrace();
		}
	}
	
}
