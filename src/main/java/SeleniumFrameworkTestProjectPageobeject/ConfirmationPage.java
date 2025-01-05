package SeleniumFrameworkTestProjectPageobeject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Text;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement TextMsg;
	
	public String VerifyMsg() {
	 CheckOutPage cp = new CheckOutPage(driver);
	 return TextMsg.getText();
		
	}
	
}
