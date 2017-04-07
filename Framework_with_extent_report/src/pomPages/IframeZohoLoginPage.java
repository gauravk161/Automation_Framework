package pomPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import genericMethods.ExtentReportClass;
import genericMethods.FrameworkMethods;
import genericMethods.MethodToCaptureScreenshot;
import genericMethods.ReadingDataFromExcel;

public class IframeZohoLoginPage extends FrameworkMethods {
	 String url;
	public IframeZohoLoginPage(WebDriver driver) {
		super(driver);
		 test = ExtentReportClass.creatingTest(EXCEL_PATH, test, extent, 1);
		 url="https://www.zoho.com/";
		 driver.get(url);
	}

	@FindBy(className="signin")
	private WebElement loginLink;

	@FindBy(id="lid")
	private WebElement idTextBox;

	@FindBy(id="pwd")
	private WebElement passTextBox;

	@FindBy(xpath="//a[.=' ZOHO']")
	private WebElement imgButton;

	public void clickOnLoginLink() throws IOException{
		
		ExtentReportClass.browserMethod();
		test.log(Status.INFO, "Opening "+url);
		
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 1, 0);
		String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		
		String actualTitle = driver.getTitle();
		String expectedTitle=gettingTitle();
		
		if(expectedTitle.equals(actualTitle)){
			test.pass("Home Page is Displayed", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
			loginLink.click();
		}else{
			test.fail("Test is FAILED refer to the screenshot",MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}
	}

	public void enteringDetails() throws Exception{
		String actualTitle = driver.getTitle();
		String expectedTitle=gettingTitle();
		if(expectedTitle.equals(actualTitle)){
			driver.switchTo().frame("zohoiam");
			int row =ReadingDataFromExcel.getRow(EXCEL_PATH, 0);
			for(int i=0;i<=row;i++){
				String username= ReadingDataFromExcel.getCellValue(EXCEL_PATH, 0, i, 0);
				String pass= ReadingDataFromExcel.getCellValue(EXCEL_PATH, 0, i, 1);
				idTextBox.sendKeys(username);
				passTextBox.sendKeys(pass);
				idTextBox.clear();
				passTextBox.clear();
			}
			String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 2, 0);
			String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
			test.pass("Login Page is Displayed", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}else{
			String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 3, 0);
			String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
			test.fail("Test is FAILED refer to the screenshot",MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}
	}

	public void switchingToParentPage() throws IOException{
		String actualTitle = driver.getTitle();
		String expectedTitle=gettingTitle();
		driver.switchTo().defaultContent();
		imgButton.click();
		if(expectedTitle.equals(actualTitle)){
			String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 4, 0);
			String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
			test.pass("Back to Home Page refer to the Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}else{
			String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 5, 0);
			String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
			test.fail("Test is FAILED refer to the screenshot",MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		}
		

	}

}
