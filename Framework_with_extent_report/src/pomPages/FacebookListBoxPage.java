package pomPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import genericMethods.ExtentReportClass;
import genericMethods.FrameworkMethods;
import genericMethods.MethodToCaptureScreenshot;
import genericMethods.MethodToCaptureScreenshotWithoutUserInput;
import genericMethods.MethodToFetchTheDataIntoReport;
import genericMethods.ReadingDataFromExcel;

public class FacebookListBoxPage extends FrameworkMethods {
	public static String[] textOrignial;
	public static String textAfterSorting;
	public static ArrayList<String> listBoxContent;
	public static ArrayList<String> cloneListBoxContent;
	
	public static String url;
	
	public FacebookListBoxPage(WebDriver driver) {
		super(driver);
		test=ExtentReportClass.creatingTest(EXCEL_PATH, test, extent, 2);
		url="https://www.facebook.com/";
		driver.get(url);
	}
	
	
	@FindBy(id="month")
	private WebElement listElement;
	
	public void getContentOfListBox() throws IOException{
		ExtentReportClass.browserMethod();
		test.log(Status.INFO, "Opening "+url);
		WebElement element = driver.findElement(By.id("month"));
		element.click();
	
		listBoxContent = FrameworkMethods.getListBox(element);
		listBoxContent.remove("Month");
		
		System.out.println("Before Sorting: ");
		
		MethodToFetchTheDataIntoReport.printTheContentBeforeSorting();
		
		System.out.println();
		
		cloneListBoxContent= new ArrayList<String>();
		for(String text:listBoxContent){
			cloneListBoxContent.add(text);
		}
		
		System.out.println("After Sorting: ");
		
		Collections.sort(cloneListBoxContent);
		
		for(int i=0;i<cloneListBoxContent.size();i++){
			textAfterSorting=cloneListBoxContent.get(i);
			System.out.print(textAfterSorting+" ");
		}
		System.out.println();
		
		MethodToFetchTheDataIntoReport.printTheContentAfterSorting();
		
		System.out.println();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - Log In or Sign Up";
		softAst.assertEquals(actualTitle, expectedTitle);
		
		String name = ReadingDataFromExcel.getCellValue(EXCEL_PATH, 1, 6, 0);
		String img = MethodToCaptureScreenshot.appendingScreenshotToTheReport(name);
		
		test.info("Facebook Home Page is Displayed", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
	
	}
	
	
}
