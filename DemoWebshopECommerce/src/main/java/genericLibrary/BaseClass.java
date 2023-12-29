package genericLibrary;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass extends WebdriverUtility {
	public WebDriver driver;
	@BeforeSuite
	public void beforeSuit() {
		
		report=new ExtentReports(REPORT_PATH+getSystemDate()+".html");	
	}
	@AfterSuite
	public void afterSuite() {
		report.flush();
		Reporter.log("Close connection to database",true);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		String methodName=method.getName();
		test=report.startTest(methodName);
		
		Reporter.log("Login");
		LoginPage loginpage=new  LoginPage(driver);
		
		loginpage.login(driver);
	}
	
	@AfterMethod
	public void aftermethod() {
		Reporter.log("Log out");
LoginPage loginpage=new  LoginPage(driver);
		
		loginpage.logOut(driver);
		report.endTest(test);
	}
	
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before test",true);
	}
	@AfterTest
	public void afterTest() {
		Reporter.log("After test",true);	
	}
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before class",true);
		String browser=FileUtility.getProperty("browser");
		String url=FileUtility.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		initObjects(driver);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After class",true);
		driver.quit();
	}
	
	
	
}
