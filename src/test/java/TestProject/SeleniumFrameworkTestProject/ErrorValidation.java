package TestProject.SeleniumFrameworkTestProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkTestProjectPageobeject.CartPage;
import SeleniumFrameworkTestProjectPageobeject.ProductCatalog;
import SeleniumFrameworkTestProjectTestComponents.BaseTest;


public class ErrorValidation extends BaseTest{

	
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException{
	
        //String productname = "ADIDAS ORIGINAL";		
		landingPage.loginApplication("test@gmail.com", "Testproject@0091166"); 
		//landingPage.loginApplication("test@gmail.com", "Testproject@91166"); 
		Assert.assertEquals("Incorrect email or password.", landingPage.ErrorMsg());
		
		
	}
	
//	@Test
//	public void ProductErrorValidation() throws IOException, InterruptedException{
//	
//        String productname = "ADIDAS ORIGINAL";
//		ProductCatalog productCatalogue = landingPage.loginApplication("pratyushatest@gmail.com", "Testproject@1166");
//		List<WebElement> products = productCatalogue.getProductList();
//		productCatalogue.addProductToCart(productname);
//		CartPage cartPage = productCatalogue.goToCartPage();
//
//		Boolean match = cartPage.VerifyProductDisplayed("ADIDAS ORIIIGINAL");
//		Assert.assertFalse(match);
//
//}
}
