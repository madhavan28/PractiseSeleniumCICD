package MPTech.AbstractComponentspractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MPTech.pageobjectpractise.Orderpage;
import MPTech.pageobjectpractise.cartpage;

public class AbstractComponentspractise {

	WebDriver driver;
	public AbstractComponentspractise(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//By.cssSelector(".mb-3")

	public void visibilityOfElementwait(By find) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	
	public void visibilityOfWebElementwait(WebElement find) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(find));
	}
	
	public void invisibilityof(WebElement find) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
	wait.until(ExpectedConditions.invisibilityOf(find));
		
	}
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy(css="[routerlink*='cart']")
	WebElement cartbtn;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement myorders;
	
	public cartpage cartbtnclick() {
		cartbtn.click();
		cartpage cp=new cartpage(driver);
		return new cartpage(driver);

	}
	
	public Orderpage gotoOrderspage() {
	
		visibilityOfWebElementwait(myorders);
		myorders.click();
		//Orderpage op=new Orderpage(driver);
		return new Orderpage(driver);
		
	}
	
}
