package TestProject.SeleniumFrameworkTestProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFrameworkTestProjectPageobeject.LandingPage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String productname = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup(); // automatically  latest chromedriver would be downloaded
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("pratyushatest@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Testproject@11");
		driver.findElement(By.id("login")).click();
		/*explicit wait logic */
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		
		List<WebElement> prod = driver.findElements(By.cssSelector(".mb-3"));
		//WebElement obj =  prod.stream().filter(product->
		//product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null); // return first appearance or return null if not found any
//		System.out.println(obj);
//		obj.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container")))); //improves performance as in loading issues failure 
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 
		List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	    
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname)); // anymatch used for matching data as required , present in stream class
		System.out.println(match);
		Assert.assertTrue(match);  //using assert to verify data is correct
		driver.findElement(By.xpath("//*[@class='totalRow']/button[text()='Checkout']")).click();
		
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("sinagpore");
			
		
		Actions act = new Actions(driver);  // used for advanced selenium interactions
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "singapore").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".action__submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String confirmText = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(confirmText);
		
		Assert.assertTrue(confirmText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.close();
	
		
		
		
		
		
		 
		
		
	}

}
