package MPTechpractise.Stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MPTech.pageobjectpractise.Paymentspage;
import MPTech.pageobjectpractise.cartpage;
import MPTech.pageobjectpractise.finalpage;
import MPTech.pageobjectpractise.landingpage;
import MPTech.pageobjectpractise.productpage;
import MPTechpractise.BaseTestPractise.BaseTestPractise;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTestPractise{

	public landingpage landingpage;
	public productpage pp;
	public finalpage fp;
	
	@Given("I landed on the Ecommerce page")
	public void I_landed_on_the_Ecommerce_page() throws IOException {
	
		landingpage=launchapplication();
	}


	@Given("^Logged in with username(.+) and password(.+)$")
	public void logged_in_with_username_password(String username , String password) {
		pp=landingpage.actionsclass(username,password);
	}

	@When("^I add the product (.+) to cart$")
	public void I_add_the_product(String productname) throws InterruptedException {
		List<WebElement> products=pp.listofelements();
		pp.addingtocart(productname);
		Thread.sleep(2000);
	}
	
	@And("^Checkout(.+) and submit the order$")
	public void checkout_and_submit_the_order(String productname) throws InterruptedException {
		cartpage cp=pp.cartbtnclick();
		Boolean match=cp.productcheck(productname);
		Assert.assertTrue(match);
		Thread.sleep(5000);
		Paymentspage pay=new Paymentspage(driver);
		pay.paymentandcountryinfo("India");
		fp=pay.checkout();
		
	}
	
		
	@Then("{string} is displayed on the confirmation page")
	public void message_displayed_confirmation_page(String string) {
		String confirmessage=fp.getconfirmMessage();
		Assert.assertTrue(confirmessage.equalsIgnoreCase(string));
		driver.close();

	}
	
	@Then("{string} message is displayed")
	public void error_message_is_displayed(String string) {
		
		Assert.assertEquals(string, landingpage.geterrorMessage());
		driver.close();
	}
	}
