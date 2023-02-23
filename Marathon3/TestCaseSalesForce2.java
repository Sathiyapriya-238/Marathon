package first.marathon2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseSalesForce2 extends SpecificMethod {
	@BeforeTest
	public void setUp() {
		excelFile="salesforcename";
	}
	@Test(dataProvider = "fetchData")
	public void runSalesForce1(String amount,String name) {
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	WebElement key=driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	Actions builder = new Actions(driver);
	builder.scrollToElement(key).perform();
	driver.executeScript("arguments[0].click();",key);
	driver.findElement(By.xpath("//div[@title='New']")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(amount);
	WebElement text=driver.findElement(By.xpath("//input[@name='Name']"));
	text.sendKeys(name);
	driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("2/14/2023");
	driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
	WebElement type=driver.findElement(By.xpath("//span[text()='New Customer']"));
	driver.executeScript("arguments[0].click();",type);
	WebElement lead=driver.findElement(By.xpath("(//button[@role='combobox'])[3]"));
	Actions builder1= new Actions(driver);
	builder1.scrollToElement(lead).perform();
	driver.executeScript("arguments[0].click();",lead);
	WebElement lead1=driver.findElement(By.xpath("//span[text()='Partner Referral']"));
	driver.executeScript("arguments[0].click();",lead1);
	driver.findElement(By.xpath("(//button[@role='combobox'])[1]")).click();
	WebElement sl=driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']"));
	driver.executeScript("arguments[0].click();", sl);
	WebElement click=driver.findElement(By.xpath("(//input[@role='combobox'])[2]"));
	driver.executeScript("arguments[0].click();", click);
	WebElement campaign=driver.findElement(By.xpath("//span[text()='test']"));
	driver.executeScript("arguments[0].click();", campaign);
	driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	WebElement text1 = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
	String result1 = text1.getText();
	System.out.println("The opportunity name is: "+result1);
	if(result1.contains("Sathiyapriya")) {
		System.out.println("Verified");
	}else {
		System.out.println("Not Verified");
	}
}
}
