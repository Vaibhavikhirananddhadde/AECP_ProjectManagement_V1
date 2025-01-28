package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.LoginPage;
import utilities.SetupExtentReport;
import utilities.UtilClass;

public class BaseClass1 extends UtilClass{
	public static ExtentTest test;
	public static ExtentReports extent;
	
	
	 private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	   
	 
	 @BeforeClass
	    public void setup() {
	        // Initialize the ExtentReports object
	        extent =  SetupExtentReport.setupExtentReport();
	    }
	 
	@BeforeMethod
	public void setUp() throws Exception {
		
		   // Initialize ExtentReports
         // extent = SetupExtentReport.setupExtentReport();
        
		launchBrowser(readProperty("browser", "/src/test/resources/configfiles/config.properties"));
		logger.info("launching browser");
		getApplication(readProperty("url", "/src/test/resources/configfiles/config.properties"));
		logger.info("Entering url in the browser");
		LoginPage login = new LoginPage();
		login.successfulLogin();
		}
	

	

	
	  @AfterMethod
	    public void tearDown() {
	        // Close the browser after each test
	        try {
	            if (driver != null) {
	                driver.quit();
	                logger.info("Browser closed successfully.");
	            }
	        } catch (Exception e) {
	            logger.error("Error occurred while closing the browser: ", e);
	        }
	    }
	 
	 
	 @AfterClass
	    public void teardown() {
	        // Flush the report after all tests have been run
	        extent.flush();
	    }
	
	  

}
