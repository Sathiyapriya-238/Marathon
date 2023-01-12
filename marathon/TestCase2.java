package first.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver dr=new ChromeDriver();
		dr.get("https://www.redbus.in/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dr.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		dr.findElement(By.xpath("//li[@class='selected']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		dr.findElement(By.xpath("(//i[@class='icon solr-icon icon-ic-city'])[1]")).click();
		dr.findElement(By.xpath("//input[@id='onward_cal']")).click();
		dr.findElement(By.xpath("//label[text()='Date']")).click();
		dr.findElement(By.xpath("//td[text()='13']")).click();
		dr.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(2000);
		WebElement text=dr.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String result = text.getText();
		System.out.println("Bus Found: "+result);
		
		WebElement sleeper=dr.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]"));
		dr.executeScript("arguments[0].click();", sleeper);
		Thread.sleep(2000);
		WebElement text1=dr.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]"));
		String result1 = text1.getText();
		System.out.println("The Second bus is: "+result1);
		Thread.sleep(2000);
		WebElement seats=dr.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]"));
		dr.executeScript("arguments[0].click();", seats);
		WebElement text2=dr.findElement(By.xpath(("(//div[text()='13'])[1]")));
		String result2 = text2.getText();
		System.out.println("The number of seats available: "+result2);
	}

}
