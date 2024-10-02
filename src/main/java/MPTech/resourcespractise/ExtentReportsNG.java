package MPTech.resourcespractise;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReportsNG {
	
	@Test
	public static ExtentReports getReportObject() {
		
		File file=new File(System.getProperty("user.dir")+"\\reports\\index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setReportName("Practise Test");
		reporter.config().setDocumentTitle("Practise Automation Report");
		
		ExtentReports er=new ExtentReports();
		er.attachReporter(reporter);
		return er;
		
	}

}
