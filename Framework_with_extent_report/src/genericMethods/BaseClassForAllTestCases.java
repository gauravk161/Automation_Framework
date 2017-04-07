package genericMethods;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

/**
 * 
 * @author GAURAV
 * @Description:
 * This class include @BeforeMethod and @AfterMethod for browsers
 *
 */
public abstract class BaseClassForAllTestCases implements InterfaceForDriversAndImages{
	public static WebDriver  driver;
	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static String browser;

	public static String author = "Gaurav Kumar Kadam";

	public static SoftAssert softAst = new SoftAssert();

	
	@BeforeMethod
	@Parameters("browser")
	public static String selectBrowser(String webBrowser){

		if(webBrowser.equalsIgnoreCase("firefox")){
			System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(webBrowser.equalsIgnoreCase("chrome")){
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		browser=webBrowser;
		return browser;


	}

	@AfterMethod
	public static void closeBrowser(ITestResult result){
		if(result.getStatus()==1){
			test.pass("Test is PASSED");
		}
		else if(result.getStatus()==2){
			test.fail("Test is FAILED");

		}
		softAst.assertAll();
		extent.flush();
		driver.quit();

	}
	
/*	@BeforeSuite
	public void beforeSuiteMethodToGenerateExtentReport(){
		htmlreporter = new ExtentHtmlReporter("C:\\Users\\GAURAV\\Desktop\\Selenium\\Workspaces\\Automation FrameWork\\Framework_with_extent_report\\Reports\\Selenium.html");
		htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlreporter.config().setTheme(Theme.DARK);


		if(extent==null){
			extent = new ExtentReports();
		}

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Windows 7 : Home Edition", "Computer Name: GAURAV-PC");
		
	}*/

}
