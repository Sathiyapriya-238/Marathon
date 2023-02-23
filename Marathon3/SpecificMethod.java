package first.marathon2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week7.day1.ReadExcelDynamic;

public class SpecificMethod {
	public RemoteWebDriver driver;
	public String excelFile;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void Launch(String browser,String url, String username, String password) {
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge")){
		driver=new EdgeDriver();
	}
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