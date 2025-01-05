package SeleniumFrameworkTestProjectPageobeject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public Boolean VerifyOrderDisplay(String productName) throws InterruptedException {
		Thread.sleep(2000);
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}
}
