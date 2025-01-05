package SeleniumFrameworkTestProjectPageobeject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	
	
	@FindBy(css=".mb-3")  
	List<WebElement> product;

	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
//	@FindBy(id="toast-container")
//	WebElement toast;
	
	By productList = By.cssSelector(".mb-3");    //getting list of products in productlist
	By addToCart = By.cssSelector(".card-body button:last-of-type");      //cannot have pagefactory on webelement on webelement
	By toast = By.id("toast-container");
	
	public  List<WebElement> getProductList()
	{
		waitForElementToAppear(productList);
		return product;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement obj =  getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return obj;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toast);
		//waitForElementToDisappear(spinner);
	}
}
