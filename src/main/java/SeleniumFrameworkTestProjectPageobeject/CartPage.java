package SeleniumFrameworkTestProjectPageobeject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	@FindBy(xpath="//*[@class='totalRow']/button[text()='Checkout']")
	WebElement checkOut;
	
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	public Boolean VerifyProductDisplayed(String productName)
	{ 	    
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName)); // anymatch used for matching data as required , present in stream class
		return match;
	}
	
	public CheckOutPage checkOut()
	{ 	    
		checkOut.click();
		return new CheckOutPage(driver);
		
	}
	

}
