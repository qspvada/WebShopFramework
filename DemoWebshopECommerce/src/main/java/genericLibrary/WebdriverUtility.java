package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This class created for all reusable methods
 * @author User
 *
 */
public class WebdriverUtility implements FrameworkConstants {
	public static Actions action;
	public static JavascriptExecutor je;
	public static ExtentReports report;
	public static ExtentTest test;

	public static void selectOptionByIndex(WebElement dropdown, int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public static void selectOptionByValue(WebElement dropdown, String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
	}
	
	public static void selectOptionByVisibleText(WebElement dropdown, String  text) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(text);
	}

//	Switch to window using title
	public static void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
		
	}
	
//	Switch to window using URL
	public static void switchToWindowByURL(WebDriver driver, String url) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
		
	}
	
	
//	Switch to frame using index
	public static void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
//	Switch to frame using name or id
	public static void switchToFrameByNameorId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
//	Switch to frame using webelement
	public static void switchToFrameByWebElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
//	all webdriver methods
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
		/**
		 * This method is used to take the screenshot of entire webpage
		 * @param driver
		 */
	public static String getScreenshotOfWebPage(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		String imagePath=SCREENSHOT_PATH+getSystemDate()+".png";
		File perm=new File(imagePath);
		
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+imagePath;
	}
	
	/**
	 * This method is used to take screenshot of webelement
	 * @param element
	 */
	public static String getScreenshotOfWebElement(WebElement element) {
		File temp=element.getScreenshotAs(OutputType.FILE);
		
		String imagepath=SCREENSHOT_PATH+getSystemDate()+".png";
		File perm=new File(imagepath);
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+imagepath;
	}
//	 method to handle alert
	public static void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public static void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public static String switchToAlertAndGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	
	public static void switchToAlertAndSsndText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
//	methods to handle mouse actions
	public static void mouseHover(WebDriver driver,WebElement element) {
		action.moveToElement(element).perform();
	}
	
	public static void mouseClick(WebDriver driver,WebElement element) {
		action.click(element).perform();
	}
	
	public static void rightClick(WebDriver driver, WebElement element) {
		action.contextClick(element).perform();
	}
	
	
	//Get the system date and time
	public static String getSystemDate() {
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}
	
	
	/**
	 * Method to handle Hidden or Disabled button 
	 */
	public static void clickOnHiddenOrDisabledElement(WebDriver driver,WebElement element) {
		
		je.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Method to handle Hidden or Disabled text field 
	 */
	public static void enterTextToHiddenOrDisabledElement(WebDriver driver,WebElement element, String value) {
		
		je.executeScript("arguments[0].value='"+value+"';", element);
	}
	
	/**
	 * Method to scroll the window by given x and y value
	 */
	public static void scrollByXAndYValue(WebDriver driver, int x, int y) {
		je.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	
	/**
	 * Method to scroll the window to the given x and y
	 */
	public static void scrollToXAndYValue(WebDriver driver, int x, int y) {
		je.executeScript("window.scrollTo("+x+","+y+");");
	}
	
	/**
	 * method to scroll the window to the top of the webelement
	 */
	public static void scrollIntoView(WebDriver driver, WebElement element, boolean position) {
		je.executeScript("arguments[0].scrollIntoView("+position+");",element);
	}
	
	
	/**
	 * Method initialize Objects like Actions and JavaScriptExecutor
	 */
	public static void initObjects(WebDriver driver) {
		action=new Actions(driver);
		je=(JavascriptExecutor) driver;
	}
}
