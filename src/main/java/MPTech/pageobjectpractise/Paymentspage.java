package MPTech.pageobjectpractise;

import java.util.List;

import javax.security.auth.callback.ConfirmationCallback;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponentspractise.AbstractComponentspractise;

public class Paymentspage extends AbstractComponentspractise{

	WebDriver driver;
	public Paymentspage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By wait1=By.cssSelector(".ta-results");
	
	@FindBy(xpath="//div[@class='form__cc']/div[2]/div[2]/input")
	WebElement cvv;

	@FindBy(xpath="//div[@class='form__cc']/div[3]/div/input")
	WebElement nameoncard;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	public void paymentandcountryinfo(String countryName) throws InterruptedException {
		
		cvv.sendKeys("123");
		nameoncard.sendKeys("Shreenidhi Madhavan");
		Thread.sleep(3000);
		Actions a = new Actions(driver);
	    a.sendKeys(country, countryName).build().perform();
	    visibilityOfElementwait(wait1);
	    selectCountry.click();
	    
	}

	public finalpage checkout() {
		
		WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", placeOrder);
		return new finalpage(driver);
		
		
	}

	
}
