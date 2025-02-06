package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass1;

public class EngineersPage extends BaseClass1{
	
	@FindBy(xpath = "(//ul[@class='navbar-nav']//li//a)[5]")
	WebElement lnk_Engineers;
	
	@FindBy(xpath="//div[@class='header bg-gradient-info py-7 py-lg-8']")
	WebElement pageLoad_Verification;
	
	@FindBy(xpath="//h1[text()='Employee Details']")
	WebElement Header;
	
	@FindBy(xpath="//img[@alt='#']")
	WebElement logo;
	
	@FindBy(xpath = "//a[@class='font-weight-bold ml-1']")
	WebElement link_footer;
	
	@FindBy(xpath="//a[normalize-space()='About Us']")
	WebElement link_aboutUs;
	
	@FindBy(xpath="//a[normalize-space()='Services']")
	WebElement link_services;
	
	@FindBy(xpath="//div[text()='mineit.tech']")
	WebElement footerVerification;
	
	@FindBy(xpath="//span[@class='mb-0 text-sm font-weight-bold']")
	WebElement profile_name;

	@FindBy(xpath="//button[@role='menuitem']//span[contains(text(),'Logout')]")
	WebElement btn_logout;
	
	
	
	public EngineersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void pageLoad() {
		lnk_Engineers.click();
		waitImplicit();
		Assert.assertTrue(pageLoad_Verification.isDisplayed());
	}
	
	public WebElement getLnk_Engineers() {
		return lnk_Engineers;
	}
	
	public void pageTitle() {
		lnk_Engineers.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "AECP";
		Assert.assertEquals(actualTitle, expectedTitle,"Title does not match!");
	}
	
	public void pageHeader() {
		lnk_Engineers.click();
		Assert.assertTrue(Header.isDisplayed());
	}
	
	public void isLogoDisplayed() {
		lnk_Engineers.click();
		Assert.assertTrue(logo.isDisplayed());
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
	
	public void logout() {
		profile_name.click();
		btn_logout.click();
	}

}
