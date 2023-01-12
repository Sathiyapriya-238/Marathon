package first.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase3 {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--diable-notifications");
		ChromeDriver dr=new ChromeDriver(option);
		dr.get("https://login.salesforce.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dr.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		dr.findElement(By.id("password")).sendKeys("Testleaf$321");
		dr.findElement(By.id("Login")).click();
		dr.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		dr.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		dr.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement st=dr.findElement(By.xpath("//span[text()='Opportunities']"));
		dr.executeScript("arguments[0].click();", st);
		dr.findElement(By.xpath("//div[@title='New']")).click();
		WebElement text=dr.findElement(By.xpath("//input[@name='Name']"));
		text.sendKeys("Salesforce Automation by Sathiyapriya");
		
		dr.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("1/12/2023");
		dr.findElement(By.xpath("(//button[@role='combobox'])[1]")).click();
		WebElement sl=dr.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']"));
		dr.executeScript("arguments[0].click();", sl);
		dr.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement text1 = dr.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		String result1 = text1.getText();
		System.out.println("The opportunity name is: "+result1);
		if(result1.contains("Sathiyapriya")) {
			System.out.println("Verified");
		}else {
			System.out.println("Not Verified");
		}
	}

}
