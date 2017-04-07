/**
 * 
 */
package genericMethods;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author GAURAV
 *@Desciption:
 *All the generic methods are defined here
 */
public class FrameworkMethods extends BaseClassForAllTestCases implements InterfaceForDriversAndImages {


	//Page Factory Constructor
	@SuppressWarnings("static-access")
	public FrameworkMethods (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Method for get title
	public static String gettingTitle(){
		String title= driver.getTitle();
		return title;
	}


	//Method to get all text present in list box
	public static ArrayList<String> getListBox(WebElement element){
		Select select = new Select(element);
		List<WebElement> allContentOfListBox = select.getOptions();
		ArrayList<String> newArrayList = new ArrayList<String>();
		for(WebElement ele:allContentOfListBox){
			String text = ele.getText();
			newArrayList.add(text);
		}
		return newArrayList;
	}

}
