package pomPages;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.ExtentReportClass;
import genericMethods.MethodToCaptureScreenshot;
import genericMethods.ReadingDataFromExcel;

public class NotClosingTheParentBrowserPage extends BaseClassForAllTestCases {

	public static String url;
	
	public static void parentBrowserOpen() throws IOException{
		url="https://www.naukri.com/";
		driver.get(url);
		test=ExtentReportClass.creatingTest(EXCEL_PATH, test, extent, 5);
		ExtentReportClass.browserMethod();
		test.log(Status.INFO, "Opening "+url);
		String parentBrowser = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles();
		allWindowHandle.remove(parentBrowser);
		test.log(Status.INFO, "Closing only child browsers");
		for(String wh:allWindowHandle){
			driver.switchTo().window(wh);
			driver.close();
			//driver.switchTo().defaultContent();
		}
		driver.switchTo().window(parentBrowser);
		String title=driver.getTitle();
		if(title.contains("Jobs")){
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 10, 0);
		String img=MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		test.pass("Home Page is displayed", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}else{
			test.fail("Test is failed");
			Assert.fail();
		}
		
		
	}
	
}
