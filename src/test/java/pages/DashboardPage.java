package pages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class DashboardPage extends BaseClass{
	@FindBy(xpath="//img[@class='navbar-brand-img']")
	WebElement logo;
	
   @FindBy(xpath="//div[@class='react-calendar']")
   WebElement calender;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogo() {
		return logo;
	}
	
	public void navigationLinks(String link_text) throws InterruptedException {
		List<WebElement> nav_links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//a"));
		for (WebElement link : nav_links) {
            // Step 4: Check if the link's text matches the target string
            if (link.getText().equalsIgnoreCase(link_text)) {
                // Step 5: If it matches, click the link
                link.click();
                driver.getPageSource().contains(link_text);
                 System.out.println("Clicked on the navigation link: " + link_text);
                
                // Exit the loop once the link has been clicked
                break;
            }
        }
	}
	
	public void calenderData() {
		// Get today's date
        LocalDate today = LocalDate.now();
        String todayDay = String.valueOf(today.getDayOfMonth()); // Get today's day as string
        String todayMonth = today.getMonth().toString().substring(0, 3).toLowerCase(); // Get today's month abbreviation (e.g., "jan")
        String todayYear = String.valueOf(today.getYear()); // Get the current year
        
	}
	
	
	
	

}
