package testScripts;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	ExtentReports report=new ExtentReports("./Reports/report.html");
	ExtentTest test=report.startTest("loginTest");
	@Test
	public void reportTest() {		
		WebDriver driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome browser launched");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome browser maximized");
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nandanms@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nandan@1234");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true, "Log out not displaed");
		test.log(LogStatus.FAIL, "Log in succesful");
		report.endTest(test);		
	driver.quit();
	}
	@Test
	public void reportTest2() {	
		test=report.startTest("log in 2");
		WebDriver driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome browser launched");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome browser maximized");
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nandanms@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nandan@1234");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true, "Log out not displaed");
		test.log(LogStatus.PASS, "Log in succesful");
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
