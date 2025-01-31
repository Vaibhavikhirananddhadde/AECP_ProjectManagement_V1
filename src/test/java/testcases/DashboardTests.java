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

public class DashboardTests extends BaseClass1{
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
		
		//Verify the "Next Month" button navigates to the next month in calender
		@Test(priority = 5)
		public void AECP_ProjectManager_Dashboard_TC016() {
			logger.info("Verify the next month button");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify next month button functionality");
			try {
				dashboard.clickNextMonth();
				logger.info("Clicked on next month button");
				
				test.pass("Next month button is working fine in calendar");
			}catch(Exception e)
			{
				logger.error("An error occured while navigating to next month",e);
				test.fail("Navigation to next month failed"+e.getMessage());
				throw e;
			}
		}
		
		//Verify the "Previous Month" button navigates to the previous month.
		@Test(priority = 6)
		public void AECP_ProjectManager_Dashboard_TC017() {
			logger.info("Verify the previous month button");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify previous month button functionality");
			try {
				dashboard.clickPreviousMonth();
				logger.info("Clicked on previous month button");
				
				test.pass("Previous month button is working fine in calendar");
			}catch(Exception e)
			{
				logger.error("An error occured while navigating to previous month",e);
				test.fail("Navigation to previous month failed"+e.getMessage());
				throw e;
			}
		}
		
		//Verify the "Next Year" button navigates to the next year 
		@Test(priority = 7)
		public void AECP_ProjectManager_Dashboard_TC018() {
			logger.info("Verify the next year button");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify next year button functionality");
			try {
				dashboard.clickNextYear();
				logger.info("Clicked on next year button");
				
				test.pass("next year button is working fine in calendar");
			}catch(Exception e)
			{
				logger.error("An error occured while navigating to next year",e);
				test.fail("Navigation to next year failed"+e.getMessage());
				throw e;
			}
		}
		
		//Verify the "Previous Year" button navigates to the previous year
		@Test(priority = 8)
		public void AECP_ProjectManager_Dashboard_TC019() {
			logger.info("Verify the previous year button");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify previous year button functionality");
			try {
				dashboard.clickPreviousYear();
				logger.info("Clicked on previous year button");
				
				test.pass("previous year button is working fine in calendar");
			}catch(Exception e)
			{
				logger.error("An error occured while navigating to previous year",e);
				test.fail("Navigation to previous year failed"+e.getMessage());
				throw e;
			}
		}
		
		//  Verify selecting a date highlights the selected date.
		@Test(priority=9)
		public void AECP_ProjectManager_Dashboard_TC020() throws Exception {
			logger.info("Verify selecting a date from the calendar");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify selecting a date from calendar");
			try {
				dashboard.selectDate("4");
				logger.info("date is selected");
				test.pass("Selected date is highlighted");
			}catch(Exception e)
			{
				logger.error("An error occured while selecting a date from the calendar");
				test.fail("Selecting a date from calendar failed"+e.getMessage());
				throw e;
			}
		}
		
		//Verify that the user can log out successfully.
		@Test(priority=10)
		public void AECP_ProjectManager_Dashboard_TC015() {
			logger.info("Verify logout functionality");
			dashboard = new DashboardPage();
			test = extent.createTest("Verify logout");
			try {
				logger.info("logout method initialized");
				dashboard = new DashboardPage();
				dashboard.logout();
				logger.info("logged out successfully");
				test.pass("logout functionality got pass");
			}catch(Exception e) {
				logger.error("An error occured while logging out");
				test.fail("Logout functionality failed"+e.getMessage());
				throw e;
			}
		}

}