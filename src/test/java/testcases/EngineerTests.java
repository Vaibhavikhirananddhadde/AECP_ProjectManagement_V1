package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.EngineersPage;

public class EngineerTests extends BaseClass1{
	public static Logger logger = LogManager.getLogger(EngineerTests.class);
	public static EngineersPage eng;
	
	//Verify Page Loads within acceptable time limit.
	@Test(priority =1)
	void AECP_ProjectManager_Engineers_TC001() {
		eng = new EngineersPage();
		test = extent.createTest("Verify Page Loads within acceptable time limit.");
		try {
			eng.pageLoad();
			test.pass("Page load verification passed");
		}catch(Exception e)
		{
			logger.error("An error occured while verifying page load", e);
			test.fail("Page load verification passed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that pagetitle is displayed.
	@Test(priority = 2)
	void AECP_ProjectManager_Engineers_TC002() {
		eng = new EngineersPage();
		test = extent.createTest("Verify that pagetitle is displayed.");
		try {
	        eng.pageTitle();
	        test.pass("Page Title verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying page title", e);
			test.fail("Page title verification failed"+e.getMessage());
			throw e;
		}
	}

	//Verify the visibility of the page header.
	@Test(priority = 3)
	void AECP_ProjectManager_Engineers_TC003() {
		eng = new EngineersPage();
		test = extent.createTest("Verify the visibility of the page header.");
		try {
			eng.pageHeader();
			test.pass("Page Header verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying page header!",e);
			test.fail("Page header verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that logo is displayed at appropriate place.
	@Test(priority = 4)
	void AECP_ProjectManager_Engineers_TC004() {
		eng = new EngineersPage();
		test = extent.createTest("Verify that logo is displayed at appropriate place.");
		try {
			eng.isLogoDisplayed();
			test.pass("Logo verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying logo",e);
			test.fail("Logo verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify Footer Links are Working Correctly
	@Test(priority = 5)
	void AECP_ProjectManager_Engineers_TC005() {
		eng = new EngineersPage();
		test = extent.createTest("Verify Footer Links are Working Correctly");
		try {
			eng.getLnk_Engineers().click();
			eng.clickFooterLink();
			test.pass("Footer links verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying footer links",e);
			test.fail("Footer links verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify Footer is Sticky (Remains at the Bottom)
	@Test(priority = 6)
	void AECP_ProjectManager_Engineers_TC006() {
		eng = new EngineersPage();
		test = extent.createTest("Verify Footer is Sticky (Remains at the Bottom)");
		try {
			eng.getLnk_Engineers().click();
			eng.checkFooterSticky();
			test.pass("Footer sticky verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying footer sticky!",e);
			test.fail("Footer sticky verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify the Logout Behavior
	@Test(priority = 7)
	void AECP_ProjectManager_Engineers_TC018() {
		eng = new EngineersPage();
		test = extent.createTest("Verify the Logout Behavior");
		try {
			eng.getLnk_Engineers().click();
			eng.logout();
			test.pass("logout verification passed");
		}catch(Exception e) {
			logger.error("An error occured while logging out!",e);
			test.fail("logout verification failed"+e.getMessage());
			throw e;
		}
	}
}
