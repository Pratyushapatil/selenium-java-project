package SeleniumFrameworkTestProjectPageobeject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//WebElement userPassword = driver.findElement(By.id("userPassword"));
	
	@FindBy(id="userEmail")  // at runtime it gets constructed as driver.findElement(By.id("userEmail"))
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit_button;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	/* creating product catalog object as its going to land in next step and object creation in handled in method itself*/
	public ProductCatalog loginApplication(String uEmail, String uPassword) 
	{ 
		userEmail.sendKeys(uEmail);
		userPassword.sendKeys(uPassword);
		submit_button.click();
		ProductCatalog prodCata = new ProductCatalog(driver);
		return prodCata;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
    public String ErrorMsg()
    {   waitForWebElementToAppear(errorMessage);
         return errorMessage.getText();
    	
    	}
}
