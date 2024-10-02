package MPTech.pageobjectpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponentspractise.AbstractComponentspractise;

public class finalpage extends AbstractComponentspractise {

	WebDriver driver;
	public finalpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String getconfirmMessage() {
		return message.getText();
	}
	
	
}
