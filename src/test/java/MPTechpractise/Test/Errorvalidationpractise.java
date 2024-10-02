package MPTechpractise.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MPTech.pageobjectpractise.Paymentspage;
import MPTech.pageobjectpractise.cartpage;
import MPTech.pageobjectpractise.finalpage;
import MPTech.pageobjectpractise.landingpage;
import MPTech.pageobjectpractise.productpage;
import MPTechpractise.BaseTestPractise.BaseTestPractise;
import MPTechpractise.BaseTestPractise.retry;

public class Errorvalidationpractise extends BaseTestPractise{

	@Test(retryAnalyzer=retry.class)
	public void asubmitOrder() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

	
		landingpage.actionsclass("madhavan28@gmail.com", "123");
		Assert.assertEquals("Incorrect email or password.", landingpage.geterrorMessage());
			
	}

	@Test(retryAnalyzer=retry.class)
	public void productvalidation() {
		String productName="ADIDAS ORIGINAL";
		productpage pp=landingpage.actionsclass("madhavan@gmail.com", "Madhavan@28");
		pp.addingtocart(productName);
		cartpage cp=pp.cartbtnclick();
		Boolean match=cp.productcheck(productName);
		Assert.assertTrue(match);
	}
}
