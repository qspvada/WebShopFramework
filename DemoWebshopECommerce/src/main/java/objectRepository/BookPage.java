package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BasePage{

	public BookPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='page-title']//h1")
	private WebElement booksPageHeading;
	
	@FindBy(id = "products-orderby")
	private WebElement sortByDropDown;
	
	@FindBy(id = "products-pagesize")
	private WebElement pageSizeDropdown;
	
	
	@FindBy(id = "products-viewmode")
	private WebElement viewAsDropdown;

	public WebElement getPageSizeDropdown() {
		return pageSizeDropdown;
	}


	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}


	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}


	public WebElement getBooksPageHeading() {
		return booksPageHeading;
	}
}
