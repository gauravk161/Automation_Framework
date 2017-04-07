package genericMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass extends BaseClassForAllTestCases implements InterfaceForDriversAndImages {


	//Method to take data from excel and generate the report
	public static  void reportConfig(String path,int row){

		String reportName=ReadingDataFromExcel.getCellValue(path, 0, row, 0);
		String titleOfReport=ReadingDataFromExcel.getCellValue(path, 0, row, 1);

		if(extent==null){
			extent = new ExtentReports();
		}else if(!(extent==null)){
			extent = new ExtentReports();
		}

		htmlreporter =new ExtentHtmlReporter(REPORT_PATH+reportName+".html");

		htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setDocumentTitle(titleOfReport);
		htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlreporter.config().setTheme(Theme.DARK);

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Windows 7 : Home Edition", "Computer Name: GAURAV-PC");
	}

	//Method to create Test
	public static ExtentTest creatingTest(String path,ExtentTest test, ExtentReports extent,int row){
		String testName=ReadingDataFromExcel.getCellValue(path, 2, row, 0);
		String testCategory=ReadingDataFromExcel.getCellValue(path, 2, row, 1);
		test=extent.createTest(testName);
		test.assignAuthor(author);
		test.assignCategory(testCategory);
		return test;
	}

	//Method for Browser
	public static void browserMethod(){

		test.log(Status.INFO, "Opening "+browser+ " browser");

	}
}
