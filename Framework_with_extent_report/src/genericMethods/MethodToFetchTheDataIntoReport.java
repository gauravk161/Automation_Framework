package genericMethods;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pomPages.FacebookListBoxPage;

public class MethodToFetchTheDataIntoReport extends FacebookListBoxPage{
	static private String[] str;
	static private String[] str1;

	public MethodToFetchTheDataIntoReport(WebDriver driver) {
		super(driver);
	}

	
	public static String printTheContentBeforeSorting(){
		 str =new String[listBoxContent.size()];
		listBoxContent.toArray(str);
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
		}
		
		StringBuilder strBuild = new StringBuilder();
		for(int i=0;i<str.length;i++){
			strBuild.append(str[i]+" ");
		}
		String newStr=strBuild.toString();
		test.log(Status.INFO, "Before Sorting: "+newStr);
		return newStr;
}

	
	public static String printTheContentAfterSorting(){
		
		str1=new String[cloneListBoxContent.size()];
		cloneListBoxContent.toArray(str1);
		
		
		StringBuilder strBuild = new StringBuilder();
		for(int i=0;i<str1.length;i++){
			strBuild.append(str1[i]+" ");
		}
		
		String newStr1 = strBuild.toString();
		test.log(Status.INFO, "After Sorting: "+newStr1);
		return newStr1;
		
	}

}
