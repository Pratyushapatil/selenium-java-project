package TestProject.SeleniumFrameworkTestProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkTestProjectPageobeject.CartPage;
import SeleniumFrameworkTestProjectPageobeject.CheckOutPage;
import SeleniumFrameworkTestProjectPageobeject.ConfirmationPage;
import SeleniumFrameworkTestProjectPageobeject.LandingPage;
import SeleniumFrameworkTestProjectPageobeject.OrderPage;
import SeleniumFrameworkTestProjectPageobeject.ProductCatalog;
import SeleniumFrameworkTestProjectTestComponents.BaseTest;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrderTest extends BaseTest{

 String productName = "ADIDAS ORIGINAL";
	//Test1
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
	
      
		ProductCatalog productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Thread.sleep(2000);
		Boolean match = cartPage.VerifyProductDisplayed(input.get("product"));
		Thread.sleep(2000);
		Assert.assertTrue(match);
		Thread.sleep(2000);
		CheckOutPage checkoutPage = cartPage.checkOut();
		Thread.sleep(2000);
		checkoutPage.SelectCountry("india");
		Thread.sleep(2000);
		ConfirmationPage confirmationPage = checkoutPage.SubmitOrder();
		Thread.sleep(2000);
		String confirmMessage = confirmationPage.VerifyMsg();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	//Test2
	@Test(dependsOnMethods= {"SubmitOrder"}) //depends on test to be executed
	public void OrderHistoryTest() throws InterruptedException
	{
		
		ProductCatalog productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
}
	@DataProvider
	public Object[][] getData() throws IOException
	{
        
		
		/*HashMap<String,String> map = new HashMap<String, String>();
		map.put("email", "Testselenium@ex.com");
		map.put("password", "Test@selenium8");
		map.put("product","ADIDAS ORIGINAL"); 
		
		HashMap<String,String> map1 = new HashMap<String, String>();
		map1.put("email", "anshika@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product","ZARA COAT 3"); */
		
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\Pratyusha\\eclipse-workspace\\SeleniumFrameworkTestProject\\src\\test\\java\\SeleniumFrameworkTestProjectTestData\\PurchseOrder.json");
	return new Object[][]  {{data.get(0)}, {data.get(1)} };
//	C:\Users\Pratyusha\eclipse-workspace\SeleniumFrameworkTestProject\TestSuites
	}
	
	
}
