package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import pages.LoginPage;


public class LoginTests extends BaseClass{
	 private static final Logger logger =  LogManager.getLogger(LoginTests.class);
	
	//Verify Page title is displayed and it describes the page content
	
	@Test(priority = 1)
	public void AECP_ProjectManager_Login_TC002() throws Exception {   //PageTitle
		
		ExtentTest test = extent.createTest("Verify Page Title", "Ensure the page title matches the expected title");
		 try {
		String expectedTitle="AEC";
		String actualTitle= driver.getTitle();
		logger.info("Fetched the actual title: " + actualTitle);

		Assert.assertEquals(actualTitle, expectedTitle);			
		logger.info("actual title matches with expected title");
		
		test.pass("Page title verification passed.");
		 }catch (Exception e) {
	            logger.error("An error occurred while verifying the page title: ", e);
	            test.fail("Page title verification failed: " + e.getMessage());
	            throw e;  // Rethrow the exception to ensure test failure is logged
	        }
		
	}
	
//	@Test(priority = 2)
	public void AECP_ProjectManager_Login_TC007() throws Exception {   //successful login
		LoginPage login = new LoginPage();
		login.successfulLogin();
		logger.info("Login happened successfully");
		String currentUrl = driver.getCurrentUrl();
		logger.info("current url captured in a variable");
		Assert.assertEquals(currentUrl, "https://aecp.aecearth.io/project-admin/project-management/dashboard");
		logger.info("current url matches with the expected url - 'https://aecp.aecearth.io/project-admin/project-management/dashboard'");
	}
	
//	@Test(dataProvider = "Logindata", priority = 3, dataProviderClass = DataProviders.class)
	public void AECP_ProjectManager_Login_TC008(String email, String password) throws InterruptedException {   //Invalid login credentials
		LoginPage login = new LoginPage();
		login.invalidCredentials(email, password);
		logger.info("Entered invalid login credentials");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://aecp.aecearth.io/login");
		logger.info("URL does not changed login not happened with invalid credentials");
	}
}
