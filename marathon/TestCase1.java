package first.marathon;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver dr=new ChromeDriver(options);
		dr.get("https://www.amazon.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops",Keys.ENTER);
		WebElement tx=dr.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[3]"));
		String rs = tx.getText();
		System.out.println(rs);
		WebElement text=dr.findElement(By.xpath("//span[contains(text(),'results for')]"));
		String result = text.getText();
		System.out.println(result);
		dr.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::i)[2]")).click();
		dr.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')]//label)[3]")).click();
		WebElement text1=dr.findElement(By.xpath("//span[contains(text(),'results for')]"));
		String result1 = text1.getText();
		System.out.println(result1);
		if(result1.equals(result)) {
			System.out.println("the result does not reduce");
		}
		else
		{
			System.out.println("the result reduce");
		}
		dr.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		dr.findElement(By.xpath("//a[text()='Avg. Customer Review']")).click();
		Thread.sleep(2000);
		WebElement text2=dr.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
		String result2 = text2.getText();
		System.out.println(result2);
		Thread.sleep(2000);
		WebElement text3=dr.findElement(By.xpath("//span[@class='a-price-whole']"));
		String result3=text3.getText();
		System.out.println(result3);
	}

}
