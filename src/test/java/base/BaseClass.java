package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.UtilClass;

public class BaseClass extends UtilClass{
	public static ExtentTest test;
	public static ExtentReports extent;
	
	
	 private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	@BeforeMethod
	public void setUp() throws Exception {
		launchBrowser(readProperty("browser", "/src/test/resources/configfiles/config.properties"));
		logger.info("launching browser");
		getApplication(readProperty("url", "/src/test/resources/configfiles/config.properties"));
		logger.info("Entering url in the browser");
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
