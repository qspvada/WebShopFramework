package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.FileUtility;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id = "Email")
	private WebElement emailTextField;

	@FindBy(id = "Password")
	private WebElement passwordTextField;

	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckbox;

	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPasswordLink;

	@FindBy(css = "[value='Log in']")
	private WebElement loginButton;
	
	
	
	/**
	 * Used to login to application by using valid email and password
	 * 
	 */
	public void login(WebDriver driver) {
		
		HomePage homePage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
		
		//Click on login link
		homePage.getLoginLink().click();
		
		//Enter the email
		loginPage.getEmailTextField().sendKeys(FileUtility.getProperty("email"));

		//Enter password
		loginPage.getPasswordTextField().sendKeys(FileUtility.getProperty("password"));

		//Click on Remember me check box
		loginPage.getRememberMeCheckbox().click();
		
		//Click on Login button
		loginPage.getLoginButton().click();
	}
	
	
	/**
	 * Used to logout from the application
	 */
	public void logOut(WebDriver driver) {
	HomePage homePage=new HomePage(driver);
	//Click on Log out link
	homePage.getLogOutLink().click();
   }

}