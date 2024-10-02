package MPTech.pageobjectpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponentspractise.AbstractComponentspractise;

public class landingpage extends AbstractComponentspractise {

	WebDriver driver;
	public landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	
	
	public productpage actionsclass(String Email,String passcode) {
		
		userEmail.sendKeys(Email);
		password.sendKeys(passcode);
		submit.click();
		productpage pp=new productpage(driver);
		return pp;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public String geterrorMessage() {
		
		visibilityOfWebElementwait(errormessage);
		return errormessage.getText();
		
	}

}
