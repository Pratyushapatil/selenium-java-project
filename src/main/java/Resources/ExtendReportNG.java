package Resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {

	@BeforeTest
	public static ExtentReports getExtentReports()
	{
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Web Automation Selenium");
		rep.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "Pratyusha");
		return extent;
		
	}
	
}
