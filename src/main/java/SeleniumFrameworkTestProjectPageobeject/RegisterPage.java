package SeleniumFrameworkTestProjectPageobeject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkTestProjectAbstractComponent.AbstractComponent;

public class RegisterPage extends AbstractComponent {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
		//initialization of driver
		this.driver= driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver of this class to the object driver passed
	}
	
	@FindBy(xpath="//a[@href='/client/auth/register']")
	WebElement registerBtn;
	
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@formcontrolname='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@formcontrolname='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@formcontrolname='userMobile']")
	WebElement userMobile;
	@FindBy(xpath="//input[@formcontrolname='userPassword']")
	WebElement userPassword;
	@FindBy(xpath="//input[@formcontrolname='confirmPassword']")
	WebElement confirmPassword;
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBoxof18;
	
	public void ClickOnRegister()
	{ 	    
		registerBtn.click();
		}
	
	public void NewRegistration()
	{ 	    
		
		
	}
	

}
