package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logOutLink;
	
	public WebElement getLogOutLink() {
		return logOutLink;
	}

	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(partialLinkText = "Shopping")
	private WebElement shoppingCartLink;
	
	@FindBy(partialLinkText = "Wishlist")
	private WebElement wishlistLink;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextField;
	
	@FindBy(css = "[value='Search']")
	private WebElement searchButton;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;

	@FindBy(partialLinkText = "JEWELRY")
	private WebElement jewelryLink;
	
	public WebElement getJewelryLink() {
		return jewelryLink;
	}



	public WebElement getBooksLink() {
		return booksLink;
	}

	

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
}
