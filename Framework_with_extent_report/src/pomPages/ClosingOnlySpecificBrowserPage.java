package pomPages;

import java.io.IOException;
import java.util.Set;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import genericMethods.BaseClassForAllTestCases;
import genericMethods.MethodToCaptureScreenshot;

public class ClosingOnlySpecificBrowserPage extends BaseClassForAllTestCases {
	
	//cannot automate as the child browsers have been changed
	
	public void closeSpecificBrowser() throws IOException{
		String parentBrowser = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		test.log(Status.INFO, "Stored all the values of browser into a variable");
		for(String wh:allWindowHandles){
			driver.switchTo().window(wh);
			String text=driver.getTitle();
			if(text.equals("Amazon")){
				driver.close();
				test.log(Status.INFO, "'Amazon' browser is closed");
			}
			if(text.equals("J P Morgan")){
			//	String browserImage=MethodToCaptureScreenshot.appendingScreenshotToTheReport();
				//test.pass("Screenshot of 'J P Morgan' Browser", MediaEntityBuilder.createScreenCaptureFromPath(browserImage).build());
			}
			if(text.equals("RBS")){
			//	String browserImage=MethodToCaptureScreenshot.appendingScreenshotToTheReport();
			//	test.pass("Screenshot of 'RBS' Browser", MediaEntityBuilder.createScreenCaptureFromPath(browserImage).build());
			}
		}
		driver.switchTo().window(parentBrowser);
		test.log(Status.INFO, "At last only parent browser Screenshot should appear");
	}
	
}
