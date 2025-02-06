package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass1;

public class MaterialsPage extends BaseClass1{
	
	@FindBy(xpath = "//a[text()='Materials']")
	WebElement lnk_Materials;
	
	@FindBy(xpath = "//h1[text()='Materials Details']")
	WebElement header;
	
	@FindBy(xpath="//img[@alt='#']")
	WebElement logo;
	
	@FindBy(xpath="//div[@class='copyright text-center text-xl-left text-muted']")
	WebElement copyright;
	
	@FindBy(xpath = "//a[@class='font-weight-bold ml-1']")
	WebElement link_footer;
	
	@FindBy(xpath="//a[normalize-space()='About Us']")
	WebElement link_aboutUs;
	
	@FindBy(xpath="//a[normalize-space()='Services']")
	WebElement link_services;
	
	@FindBy(xpath="//div[text()='mineit.tech']")
	WebElement footerVerification;
	
	@FindBy(xpath="//button[normalize-space()='Request Materials']")
	WebElement btn_RequestMaterials;
	
	@FindBy(xpath="//form[@enctype='multipart/form-data']")
	WebElement form_RequestMaterials;
	
	
	public MaterialsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMaterialsLink() {
		lnk_Materials.click();
	}
	
	public WebElement getHeader() {
		return header;
	}
	
	public void isLogoDisplayed() {
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void pageTitle() {
		lnk_Materials.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "AECP";
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	}
	
	public void clickFooterLink() {
		String parentWindow = driver.getWindowHandle();
		waitExplicit(link_footer);
		link_footer.click();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window:allWindows)
		{
			 if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);  // Switch to the new window
	                break;
	            }
		}
		waitExplicit(footerVerification);
	    Assert.assertTrue(footerVerification.isDisplayed());
        driver.switchTo().window(parentWindow);
	    link_aboutUs.click();
	    Set<String> allWindows1 = driver.getWindowHandles();
		for(String window:allWindows1)
		{
			 if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);  // Switch to the new window
	                break;
	            }
		}
		waitExplicit(footerVerification);
	    Assert.assertTrue(footerVerification.isDisplayed());
	    driver.switchTo().window(parentWindow);
	    link_services.click();
	    Set<String> allWindows2 = driver.getWindowHandles();
		for(String window:allWindows2)
		{
			 if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);  // Switch to the new window
	                break;
	            }
		}
		waitExplicit(footerVerification);
	    Assert.assertTrue(footerVerification.isDisplayed());
	    driver.close();
	}
	
	public boolean checkFooterSticky() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Object footer = driver.findElement(By.xpath("//body/div[@id='root']/div[@class='main-content']/div[2]"));
		 // Get the CSS position property of the footer
		
		return (boolean) js.executeScript("var rect = arguments[0].getBoundingClientRect();"
				+ "return (rect.bottom <= window.innerHeight && rect.bottom > 0);", footer);
       
	}
	
	public void checkRequestMaterialsBtnFunction() {
		lnk_Materials.click();
		btn_RequestMaterials.click();
		waitExplicit(form_RequestMaterials);
		Assert.assertTrue(form_RequestMaterials.isDisplayed(),"RequestMaterials button is not clickable!");
	}

}
