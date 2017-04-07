package pomPages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import genericMethods.ExtentReportClass;
import genericMethods.FrameworkMethods;
import genericMethods.MethodToCaptureScreenshot;
import genericMethods.ReadingDataFromExcel;

public class HandlingNewTabPage extends FrameworkMethods {
	String text;
	public String url;
	public HandlingNewTabPage(WebDriver driver) {
		super(driver);
		test=ExtentReportClass.creatingTest(EXCEL_PATH, test, extent, 4);
		url="http://localhost/login.do";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(linkText="actiTIME Inc.")
	private WebElement linkElement;

	@FindBy (xpath="//li[@id='nav-startusingat']")
	private WebElement childLinkElement;

	public void parentBrowser() throws IOException{
		ExtentReportClass.browserMethod();
		test.log(Status.INFO, "Opening "+url);
		test.log(Status.INFO, "Clicking on 'actiTIME Inc'link");
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 8, 0);
		String img=MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		test.pass("Screenshot of the Parent Browser", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		String parentTitle = driver.getTitle();
		if(!parentTitle.equals("actiTIME - Login")){
			String name1 = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 8, 0);
			String img1=MethodToCaptureScreenshot.appendingScreenshotToTheReport(name1);
			test.fail("Screenshot of the Parent Browser", MediaEntityBuilder.createScreenCaptureFromPath(img1).build());
		}

		linkElement.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String wh:allWindowHandles){
			driver.switchTo().window(wh);
			text = driver.getTitle();
			System.out.println(text);
		}
	}

	public void childBrowser() throws IOException{
		test.log(Status.INFO, "Click on the 'Try Free' link of child browser");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(childLinkElement));
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 9, 0);
		String img=MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		test.pass("Screenshot of the Child Browser before clicking on link", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		if(!text.equals("actiTIME – Timesheet Software")){
			String name1 = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 9, 0);
			String img1=MethodToCaptureScreenshot.appendingScreenshotToTheReport(name1);
			test.fail("Screenshot of the Child Browser", MediaEntityBuilder.createScreenCaptureFromPath(img1).build());
			Assert.fail();
		}
		childLinkElement.click();
	}

}
