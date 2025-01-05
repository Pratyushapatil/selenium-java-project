package SeleniumFrameworkTestProjectTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkTestProjectPageobeject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver ;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();  //to get values from porp file
		FileInputStream fis = new FileInputStream("C:\\Users\\Pratyusha\\eclipse-workspace\\SeleniumFrameworkTestProject\\src\\main\\java\\Resources\\GlobalData.properties");   // to read file and user.dir->get the user directory dynamically 
	    prop.load(fis);   // loading file via object
	    String browserName = prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome"))
	    {    
	    	WebDriverManager.chromedriver().setup(); // automatically  latest chromedriver would be downloaded
	    	 driver = new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	//firefox driver path
	    }
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.manage().window().maximize();
	    	return driver;
	    }
	
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException{
		String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
			//String to HashMap- Jackson Datbind
			
			ObjectMapper mapper = new ObjectMapper();
			  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		      });
			  return data;
		}
	
/* this will execute the launch application process */	
@BeforeMethod(alwaysRun=true)
public LandingPage launchApplication() throws IOException
{
	
	driver = initializeDriver();
	 landingPage = new LandingPage(driver);
	landingPage.goTo();
	return landingPage;
}

@AfterMethod(alwaysRun=true)

public void tearDown()
{
	driver.close();
}
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  File destFile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	  FileUtils.copyFile(source,destFile);
	  return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
}
