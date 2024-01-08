package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import genericLibrary.WebdriverUtility;
import objectRepository.BookPage;
import objectRepository.HomePage;

public class BooksTest extends BaseClass{

	@Test
	public void verifyBookPage_001() {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		Reporter.log("Verify books pageis displayed",true);
		
		//Click on BOOKS Link
		homePage.getBooksLink().click();
		test.log(LogStatus.INFO, "Clicked on books link");
		
		String pageHeading=bookPage.getBooksPageHeading().getText();
	
		try {
		Assert.assertEquals(pageHeading, "Computer", "Books is not dispalyed");
		test.log(LogStatus.PASS, "Test case completed");
		}
		
		catch (AssertionError e) {
			String path=getScreenshotOfWebPage(driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(path));
		}
		
		Reporter.log("Test case Completed and It passed",true);
	}
	
	
	@Test
	public void sortBooksByNameAndPrice_002() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		//Click on Books Link
		homePage.getBooksLink().click();
		
		//Sort the books from Z to A
		selectOptionByIndex(bookPage.getSortByDropDown(), 2);
	    Thread.sleep(2000);
	    test.log(LogStatus.INFO, "option selected");
	    selectOptionByVisibleText(bookPage.getSortByDropDown(), "Created on");
	    Thread.sleep(2000);
	    test.log(LogStatus.FAIL, "Test case 2 failed");
	   
	}
	
	@Test
	public void sortBooksByPageSize_003() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		//Click on Books Link
		homePage.getBooksLink().click();
		
		//Sort the books from Z to A
		selectOptionByIndex(bookPage.getPageSizeDropdown(), 2);
		Thread.sleep(2000);
	test.log(LogStatus.PASS, "Pass");
		
		switchToWindowByTitle(driver, "flipkart");
		
		switchToWindowByURL(driver, "https://flipkart.com");
	}
	}
