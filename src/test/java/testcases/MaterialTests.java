package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass1;
import pages.MaterialsPage;

public class MaterialTests extends BaseClass1{
	public static Logger logger = LogManager.getLogger(MaterialTests.class);
	public static MaterialsPage materials;
	
	//Verify Page Loads within acceptable time limit.
	@Test(priority =1)
	public void AECP_ProjectManager_Materials_TC001() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify Page Loads within acceptable time limit.");
		try {
		materials.clickOnMaterialsLink();
		waitExplicit(materials.getHeader());
		Assert.assertTrue(materials.getHeader().isDisplayed());
		test.pass("Page load test passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying page load",e);
			test.fail("Page load test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that proper page title is displayed
	@Test(priority =2)
	void AECP_ProjectManager_Materials_TC002() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify that proper page title is displayed");
		try {
			materials.pageTitle();
			test.pass("Page title verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying page title",e);
			test.fail("Page title verification failed"+e.getMessage());
			throw e;
		}
		
	}
	
	//Verify the visibility of the page header.
	@Test(priority =3)
	void AECP_ProjectManager_Materials_TC003() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify that page header is displayed.");
		try {
			materials.clickOnMaterialsLink();
			waitExplicit(materials.getHeader());
			Assert.assertTrue(materials.getHeader().isDisplayed());
			test.pass("Page header verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying page header",e);
			test.fail("Page header verification failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify that logo is displayed at appropriate place.
	@Test(priority =4)
	public void AECP_ProjectManager_Materials_TC004() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify that logo is displayed in pagetitle.");
		try {
			materials.clickOnMaterialsLink();
			waitImplicit();
			materials.isLogoDisplayed();
			test.pass("Verify that logo is displayed at appropriate place. test passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying logo", e);
			test.fail("Logo verification test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify Footer Links are Working Correctly
	@Test(priority=5)
	void AECP_ProjectManager_Materials_TC005() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify Footer Links are Working Correctly");
		try {
			materials.clickOnMaterialsLink();
			materials.clickFooterLink();
			test.pass("Footer links verification test passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying footer links",e);
			test.fail("Footer links verification test failed"+e.getMessage());
			throw e;
		}
	}
	
	//Verify Footer is Sticky (Remains at the Bottom)
	@Test(priority = 6)
	void AECP_ProjectManager_Materials_TC006() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify Footer is Sticky (Remains at the Bottom)");
		try {
			materials.clickOnMaterialsLink();
			materials.checkFooterSticky();
			test.pass("footer sticky verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying footer sticky test!");
			test.fail("footer sticky verification failed");
			throw e;
		}
	}
	
	//Verify the functionality of the "Request Materials" button.
	@Test(priority=7)
	void AECP_ProjectManager_Materials_TC017() {
		materials = new MaterialsPage();
		test = extent.createTest("Verify the functionality of the \"Request Materials\" button.");
		try {
			materials.checkRequestMaterialsBtnFunction();
			test.pass("Request Materials button function verification passed");
		}catch(Exception e) {
			logger.error("An error occured while verifying Request Materials button function!",e);
			test.fail("Request Materials button function verification failed!"+e.getMessage());
			throw e;
		}
	}

}
