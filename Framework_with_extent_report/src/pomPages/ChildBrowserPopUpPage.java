package pomPages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import genericMethods.ExtentReportClass;
import genericMethods.FrameworkMethods;
import genericMethods.MethodToCaptureScreenshot;
import genericMethods.ReadingDataFromExcel;

public class ChildBrowserPopUpPage extends FrameworkMethods {
	public String url;
	public ChildBrowserPopUpPage(WebDriver driver) {
		super(driver);
		test=ExtentReportClass.creatingTest(EXCEL_PATH, test, extent, 3);
		url="https://www.naukri.com/";
		driver.get(url);
	}
	
	public void windowHandle() throws IOException{
		ExtentReportClass.browserMethod();
		test.log(Status.INFO, "Opening "+url);
		Set<String> allWindowHandle = driver.getWindowHandles();
		
		for(String windowHandle:allWindowHandle){
			driver.switchTo().window(windowHandle);
			String text = driver.getTitle();
			System.out.println(text);
			test.log(Status.INFO, "Title are: "+text);
		}
		
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 7, 0);
		String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		test.pass("Last Child PopUp page", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		
	}
	
}
