package SeleniumFrameworkTestProjectPageobeject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")  
	WebElement submit;
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	WebElement country;
	
	By results = By.cssSelector(".ta-results"); // because we dont have any webelement
	
	
	public void SelectCountry(String countryName)
	{ 	    
		Actions act = new Actions(driver);  // used for advanced selenium interactions
		act.sendKeys(SelectCountry, countryName).build().perform();
		waitForElementToAppear(results);
		country.click();	
	}
	

	public ConfirmationPage SubmitOrder()
	{ 	    
		submit.click();	
		return new ConfirmationPage(driver);
	}

}
