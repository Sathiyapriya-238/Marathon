package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadExcelDynamic;



public class SpecificMethod1 {
	public ChromeDriver driver;
	public String excelFile;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName,testDescription,testCategory,testAuthor;
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");		
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
//	public int takeSnap() throws IOException {
//        int ranNum = (int) (Math.random() * 999999 + 1000000); //2424
//        File source = driver.getScreenshotAs(OutputType.FILE);
//        File target = new File("./snaps/img" + ranNum + ".png");
//        FileUtils.copyFile(source, target);
//        return ranNum; //4234324
//    }
//	public void reportStep(String stepDesc, String status) throws IOException {
//        if (status.equalsIgnoreCase("Pass")) {
//            node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
//        } else if (status.equalsIgnoreCase("fail")) {
//            node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
//            throw new RuntimeException("Please look into report for failure details");
//        }
//    }
	
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);

	}
	@AfterSuite
	public void stopReport() {
		extent.flush();

	}

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void Launch(String url, String username, String password) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
	String[][] Data = ReadExcelDynamic.readData(excelFile);
	return Data;
}
}