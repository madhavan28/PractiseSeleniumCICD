package MPTech.pageobjectpractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponentspractise.AbstractComponentspractise;

public class Orderpage extends AbstractComponentspractise{

	WebDriver driver;
	public Orderpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// //tr[contains(@class,'star')]/td[2]
	@FindBy(xpath="//tr[contains(@class,'star')]/td[2]")
	List<WebElement> orderproducts;
	

	public Boolean Verifyorderdisplay(String productName) {
		
		Boolean match=orderproducts.stream().anyMatch(products->products.getText().equalsIgnoreCase(productName));
		return match;
	}


	
}
