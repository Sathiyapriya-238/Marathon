package first.marathon1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class Service {

	public static void main(String[] args) throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--diable-notifications");
		ChromeDriver dr=new ChromeDriver(option);
		dr.get("https://dev62925.service-now.com/");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		dr.findElement(By.xpath("//input[@id='user_password']")).sendKeys("GAhMak34tH-^");
		dr.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Shadow shadow=new Shadow(dr);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[@aria-label='All']").click();
		WebElement click=shadow.findElementByXPath("//span[text()='Service Catalog']");
		dr.executeScript("arguments[0].click();", click);
		WebElement frame = shadow.findElementByXPath("//iframe[@title='Main Content']");
	    dr.switchTo().frame(frame);
	    dr.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
	    dr.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
	    dr.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
	    WebElement dropdown=dr.findElement(By.xpath("//select[@class='form-control cat_item_option']"));
	    Select drop= new Select(dropdown);
	    drop.selectByIndex(2);
	    dr.findElement(By.xpath("//label[text()='Blue']")).click();
	    dr.findElement(By.xpath("(//label[@class='radio-label'])[10]")).click();
	    dr.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
	    String text=dr.findElement(By.xpath("//span[@aria-live='assertive']")).getText();
	    System.out.println(text);
	    String text1=dr.findElement(By.xpath("//a[@id='requesturl']")).getText();
	    System.out.println(text1);
	    File source=dr.getScreenshotAs(OutputType.FILE);
		File target= new File("snap/sevice.png");
		FileUtils.copyFile(source, target);
	}

}
