package MPTechpractise.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MPTech.pageobjectpractise.Orderpage;
import MPTech.pageobjectpractise.Paymentspage;
import MPTech.pageobjectpractise.cartpage;
import MPTech.pageobjectpractise.finalpage;
import MPTech.pageobjectpractise.productpage;
import MPTechpractise.BaseTestPractise.BaseTestPractise;

public class Originalcodepractise2 extends BaseTestPractise{

	public String productName="ADIDAS ORIGINAL";
	
	@Test(dataProvider= "getData")
	
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		String countryName="Ind";
		productpage pp=landingpage.actionsclass(input.get("username"), input.get("password"));
		List<WebElement> products=pp.listofelements();
		pp.addingtocart(input.get("product"));
		cartpage cp=pp.cartbtnclick();
		Boolean match=cp.productcheck(input.get("product"));
		Assert.assertTrue(match);
		Thread.sleep(5000);
		Paymentspage pay=new Paymentspage(driver);
		pay.paymentandcountryinfo(countryName);
		finalpage fp=pay.checkout();
		String confirmessage=fp.getconfirmMessage();
		Assert.assertTrue(confirmessage.equalsIgnoreCase("Thankyou for the order."));
			
	}

	//Verify wheather the ordered product is in the cart

	@Test(dependsOnMethods= {"submitOrder"})
	public void orderhistory() {
	
	productpage pp=landingpage.actionsclass("madhavan@gmail.com", "Madhavan@28");
	Orderpage op=pp.gotoOrderspage();
	Assert.assertTrue(op.Verifyorderdisplay(productName));
	
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		

	List<HashMap<String,String>> data =getJsonDataToMap("\\src\\test\\java\\MPTechpractise\\Data\\PurchaseOrder.json");

	return new Object[][] {{data.get(0)},{data.get(1)}};
	  
	
	}
	
}

//HashMap<String,String> map=new HashMap<String,String>();
//map.put("username", "madhavan@gmail.com");
//map.put("password", "Madhavan@28");
//map.put("product", "ADIDAS ORIGINAL");
//
//HashMap<String,String> map1=new HashMap<String,String>();
//map1.put("username", "bm@gmail.com");
//map1.put("password", "Stonecold@0");
//map1.put("product", "IPHONE 13 PRO");

//return new Object[][] {{"madhavan@gmail.com","Madhavan@28","ADIDAS ORIGINAL"},{"bm@gmail.com","Stonecold@0","IPHONE 13 PRO"}};