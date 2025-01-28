package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.DataProviders;

public class DashbaordTests extends BaseClass1{
	 private static final Logger logger =  LogManager.getLogger(LoginTests.class);
	 public LoginPage login;
	 public DashboardPage dashboard;
	 
	//Verify page is loaded successfully.
		@Test(priority =1)
		public void AECP_ProjectManager_Dashboard_TC001() throws InterruptedException {
			logger.info("Validating page load");
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
	        logger.info("Page loaded successfully with all content");
		}
		
		//Verify Page title is displayed and it describes the page content	
		@Test(priority = 2)
		public void AECP_ProjectManager_Dashboard_TC002() throws Exception {   //PageTitle
			
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
		
		//Verify logo is displayed.
		@Test(priority = 3)
		public void AECP_ProjectManager_Dashboard_TC004() {
			logger.info("Verify logo", "Ensure logo is displayed in the page");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify logo", "Ensure the logo is displayed in the page");
			 try {
			Assert.assertTrue(dashboard.getLogo().isDisplayed());
			
			logger.info("Logo is displayed in the page");
			test.pass("Page logo verification passed");
			 }catch(Exception e)
			 {
				 logger.error("An error occured while validating the logo:", e);
				 test.fail("Page logo verification failed: "+e.getMessage());
				 throw e;
			 }
			
		}
		
		//Login to the  Project Manager Dashboard module Verify Navigation Links
		@Test(dataProvider = "DashboardNavigation", priority = 4, dataProviderClass = DataProviders.class)
		public void AECP_ProjectManager_Dashboard_TC008(String link_text) throws Exception {
			logger.info("Verify navigation links are working fine");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify navigation links", "Ensure each navigation link navigates to expected page");
			try {
				dashboard.navigationLinks(link_text);
				test.pass("Each navigation link is redirecting to respective page");
			}catch(Exception e) {
				 logger.error("An error occured while navigating to other page:", e);
				 test.fail("navigation link verification failed: "+e.getMessage());
				 throw e;
			}
		}
	

}
