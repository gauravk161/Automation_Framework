package testScripts;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import pomPages.IframeZohoLoginPage;

public class IframeZohoLoginTest extends BaseClassForAllTestCases{

	@Test
	public void iFrameMethod(){
		ExtentReportClass.reportConfig(EXCEL_PATH,1);
		IframeZohoLoginPage iframe = new IframeZohoLoginPage(driver);
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			iframe.clickOnLoginLink();
			iframe.enteringDetails();
			iframe.switchingToParentPage();

		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			Reporter.log("Test Case failed",true);

		}

	}

}
