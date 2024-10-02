package MPTechpractise.BaseTestPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MPTech.pageobjectpractise.landingpage;

public class BaseTestPractise {
	public WebDriver driver;
	public landingpage landingpage;
	
public WebDriver InitializeDriver() throws IOException {
	
	Properties proppractise=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\MPTech\\resourcespractise\\resourcespractise.properties");
	proppractise.load(fis);
	String browsername=System.getProperty("browser")!=null?System.getProperty("browser"):proppractise.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("Chrome")) {
		
		driver=new ChromeDriver();
		
	}
	
	else if(browsername.equalsIgnoreCase("FireFox")) {
		
		driver=new FirefoxDriver();
	}
	
	else if (browsername.equalsIgnoreCase("Edge")) {
		
		driver=new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	
}	

	@BeforeMethod(alwaysRun=true)
	public landingpage launchapplication() throws IOException {
		
		driver=InitializeDriver();
		landingpage=new landingpage(driver);
		landingpage.goTo();
		return landingpage;
		
	}
	
	
	//Taking Screenshot
	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+TestCaseName +".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"//reports//"+TestCaseName +".png";
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
	driver.close();	
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {
		
		//first convert json into a String 
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+path),
				StandardCharsets.UTF_8);  //StandardCharsets.UTF_8 is the encoding format to write the string
			
		//Now String into HashMap using Jackson databind from MVN repository
		
		ObjectMapper mapper=new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;
		}
		
		//in above we are creating object for the class "ObjectMapper" in that we are calling the class "readValue" in which there are 2 things expected 
		//1st is which file we want to read
		//2nd is in what type we want to convert that file, in that we want to be in List , We have 2 data set so we are giving <String , String>
}
	