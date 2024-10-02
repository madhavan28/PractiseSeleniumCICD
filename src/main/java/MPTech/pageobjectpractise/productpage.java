package MPTech.pageobjectpractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponentspractise.AbstractComponentspractise;

public class productpage extends AbstractComponentspractise{

	WebDriver driver;
	public productpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By firstwait=By.cssSelector(".mb-3");
	By cartbutton=By.cssSelector(".card-body button:last-of-type");
	By secondwait=By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement spinny;
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	public List<WebElement> listofelements() {
		
		visibilityOfElementwait(firstwait);
		return products;
		
	}
		
	public WebElement findproduct(String productName) {
		
		WebElement prod=listofelements().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addingtocart(String productName) {
		
		WebElement prod=findproduct(productName);
		prod.findElement(cartbutton).click();
		visibilityOfElementwait(secondwait);
		invisibilityof(spinny);
		}
	
}
