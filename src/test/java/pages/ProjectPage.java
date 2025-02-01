package pages;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import io.reactivex.rxjava3.functions.Action;

public class ProjectPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='order-xl-2 mb-5 mb-xl-0 text-left  col']")
	WebElement pageHeader_project;
	
	@FindBy(xpath="//a[normalize-space()='Project']")
	WebElement link_project;
	
	@FindBy(css = ".copyright.text-center.text-xl-left.text-muted")
	WebElement link_footer;
	
	@FindBy(xpath="//a[normalize-space()='About Us']")
	WebElement link_aboutUs;
	
	@FindBy(xpath="//a[normalize-space()='Services']")
	WebElement link_services;
	
	@FindBy(xpath="//div[text()='mineit.tech']")
	WebElement footerVerification;
	
	@FindBy(xpath="//div[@class='dropdown-menu-arrow dropdown-menu dropdown-menu-right show']")
	WebElement dd_message;
	
	@FindBy(xpath="//ul[@class='align-items-center d-none d-md-flex navbar-nav']//i[@class='fa-solid fa-comment']")
    WebElement icon_msg;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement txt_searchbox;
	
	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPageHeader_project() {
		return pageHeader_project;
	}
	
	public WebElement getLink_project() {
		return link_project;
	}
	
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "AECP";
		Assert.assertEquals(actualTitle, expectedTitle);
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
	
	public void hoveringMsgIcon() {
		mouseOvering(driver, icon_msg);
		Assert.assertTrue(dd_message.isDisplayed());
	}
	
	public void searchfieldFunctionality(String text) {
		txt_searchbox.sendKeys(text,Keys.ENTER);
	}
	
	

}
