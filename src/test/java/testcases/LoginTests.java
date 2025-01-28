package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.DataProviders;


public class LoginTests extends BaseClass{
	 private static final Logger logger =  LogManager.getLogger(LoginTests.class);
	 public LoginPage login;
	 
	//Verify page is loaded successfully.
		@Test(priority =1)
		public void AECP_ProjectManager_Login_TC001() throws InterruptedException {
			
			test = extent.createTest("Verify Page load", "Ensure the page loads successfully");
			 // Wait for the page to fully load
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        boolean isPageLoaded = false;

	        for (int i = 0; i < 10; i++) { // Max 10 retries
	            if (js.executeScript("return document.readyState").equals("complete")) {
	                isPageLoaded = true;
	                break;
	            }
	            Thread.sleep(1000); // Wait 1 second before checking again
	        }

	        if (isPageLoaded) {
	            System.out.println("Page has fully loaded!");
	        } else {
	            System.out.println("Page load timed out.");
	        }
		}
	
	//Verify Page title is displayed and it describes the page content	
	@Test(priority = 2)
	public void AECP_ProjectManager_Login_TC002() throws Exception {   //PageTitle
		
		test = extent.createTest("Verify Page Title", "Ensure the page title matches the expected title");
		 try {
		String expectedTitle="AECP";
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
	

	//Verify Page header is present and is valid
		//@Test(priority = 3)
		public void AECP_ProjectManager_Login_TC003() {
			login = new LoginPage();
			 WebElement header = login.getLogin_header();
			 String actualHeader = header.getText();
			logger.info("Get the actual page header");
			String expectedHeader = "Login";
			Assert.assertEquals(actualHeader, expectedHeader, "Page header not proper!.");
			logger.info("Actual header matches with actual header");
			
		}
	
	
	//Verify successful login by entering valid email and password
	@Test(priority = 4)
	public void AECP_ProjectManager_Login_TC006() throws Exception {   //successful login
		test = extent.createTest("Verify successful login with valid credentials", "Ensure logged in successfully and dashboard page is displayed");
		login = new LoginPage();
		login.successfulLogin();
		logger.info("Login happened successfully");
		String currentUrl = driver.getCurrentUrl();
		logger.info("current url captured in a variable");
		Assert.assertEquals(currentUrl, "https://aecp.aecearth.io/project-admin/project-management/dashboard");
		logger.info("current url matches with the expected url - 'https://aecp.aecearth.io/project-admin/project-management/dashboard'");
	}
	
	//Verify proper error message is displayed when invalid credentials are entered
	@Test(dataProvider = "Logindata", priority = 5, dataProviderClass = DataProviders.class)
	public void AECP_ProjectManager_Login_TC007(String email, String password) throws InterruptedException {   //Invalid login credentials
		test = extent.createTest("Verify error message while logging in", "Ensure valid error message is displayed when invalid data is entered");
		login = new LoginPage();
		login.invalidCredentials(email, password);
		logger.info("Entered invalid login credentials");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://aecp.aecearth.io/login");
		logger.info("URL does not changed login not happened with invalid credentials");
	}
	
	
	
	
	
	
	
	
}
