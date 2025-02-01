package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.DashboardPage;
import pages.ProjectPage;

public class ProjectTests extends BaseClass1{
	private static final Logger logger =  LogManager.getLogger(LoginTests.class);
	ProjectPage project;
	DashboardPage dashboard;

	//Verify that page loaded with all the components
	//@Test(priority =1)
	public void AECP_ProjectManager_Project_TC001() {
		test = extent.createTest("Verify that page loaded successfully");
		project = new ProjectPage();
		try {
		project.getLink_project().click();
		waitExplicit(project.getPageHeader_project());
		Assert.assertTrue(project.getPageHeader_project().isDisplayed());
		test.pass("Page load test passed");
		}catch(Exception e)
		{
			 logger.error("An error occured while loading page", e);
			 test.fail("Page logo verification failed: "+e.getMessage());
			 throw e;
		}
	}
	
	//Verify that page title is present
	//@Test(priority =2)
	public void AECP_ProjectManager_Project_TC002() {
		test = extent.createTest("Verify whether page title is present");
		logger.info("Verifying page title");
		project = new ProjectPage();
		try {
		project.verifyPageTitle();
		test.pass("Verify page title test passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying page title", e);
			test.fail("verify page title test failed: "+e.getMessage());
			throw e;
		}
		
	}

	//Verify logo is displayed.
	//@Test(priority = 3)
	public void AECP_ProjectManager_Dashboard_TC004() {
		logger.info("Verify logo", "Ensure logo is displayed in the page");
		dashboard = new DashboardPage();
		project = new ProjectPage();
		project.getLink_project().click();
		test = extent.createTest("Verify logo", "Ensure the logo is displayed in the page");
		 try {
		Assert.assertTrue(dashboard.getLogo().isDisplayed());
		test.pass("Page logo verification passed");
		 }catch(Exception e)
		 {
			 logger.error("An error occured while validating the logo:", e);
			 test.fail("Page logo verification failed: "+e.getMessage());
			 throw e;
		 }		
	}
	
	//Verify Footer Links are Working Correctly
	//@Test(priority =4)
	public void AECP_ProjectManager_Project_TC005() {
		logger.info("Verify Footer Links are Working Correctly");
		project = new ProjectPage();
		project.getLink_project().click();
		test = extent.createTest("Verify footer link", "Ensure that footer link is working fine");
		try {
		project.clickFooterLink();
		test.pass("Verifying footer link functionality got passed");
		}catch(Exception e)
		{
			logger.error("An error occured while checking the footer function", e);
			 test.fail("Verifying footer link functionality failed: "+e.getMessage());
			 throw e;
		}
	}
	
	//Verify Footer is Sticky (Remains at the Bottom)
	//@Test(priority = 5)
	public void AECP_ProjectManager_Project_TC006() {
		logger.info("Verify Footer is sticky");
		test = extent.createTest("Verify footer sticky", "Ensure that footer is sticky");
		project = new ProjectPage();
		try {
		project.getLink_project().click();	
		project.checkFooterSticky();
		test.pass("Footer sticky verification passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying footer stickyness", e);
			test.fail("Footer sticky verification failed "+e.getMessage());
			throw e;
		}
	}
	
	//Ensure that tooltip is displayed for icons on hover.
	//@Test(priority = 6)
	public void AECP_ProjectManager_Project_TC009() {
		logger.info("Hovering over message icon");
		test = extent.createTest("Verify tooltip is displayed for message icon on hovering");
		project = new ProjectPage();
		try {
			project.getLink_project().click();
			project.hoveringMsgIcon();
			test.pass("The test for checking tooltip for message icon is passed");
		}catch(Exception e)
		{
			logger.error("An error occured while checking tooltip for message icon", e);
			test.fail("The test for checking tooltip for message icon is failed "+e.getMessage());
			throw e;
		}
	}
	
	//Verify that the search field returns the correct results when a valid search query is entered.
	@Test(priority = 7)
	public void AECP_ProjectManager_Project_TC015() {
		logger.info("Verify search field displays valid result ");
		test = extent.createTest("Verify that valid results are displayed when matching text is entered");
		project = new ProjectPage();
		try {
			project.getLink_project().click();
			project.searchfieldFunctionality("vaibhavi");
			test.pass("search field function for matching result passed");
		}catch(Exception e)
		{
			logger.error("An error occured while checking searchfield functionality for valid results", e);
			test.fail("verifying searchfield functionality test failed "+e.getMessage());
			throw e;
		}
	}
	
}
