package testScripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.BaseClass;
import objectRepository.HomePage;
import objectRepository.JewelryPage;

public class JewelryTest extends BaseClass{

	@Test
	public void diamondHeartTest_001() {
		HomePage homePage=new HomePage(driver);
		JewelryPage jewelryPage=new JewelryPage(driver); 
		
		//Take screenshot of webpage
		getScreenshotOfWebPage(driver);
		
		//Click on Jewelry
		clickElement(homePage.getJewelryLink());
		test.log(LogStatus.ERROR, "Error occured");
		//Take screenshot of Diamond heart
		getScreenshotOfWebElement(jewelryPage.getBlackAndWhiteDiamondHeartImage());
		
		String str="hi";
		
	}
}
