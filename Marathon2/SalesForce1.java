package first.marathon1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForce1 {

	public static void main(String[] args) throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--diable-notifications");
		ChromeDriver dr=new ChromeDriver(option);
		dr.get("https://login.salesforce.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dr.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		dr.findElement(By.id("password")).sendKeys("Leaf@123");
		dr.findElement(By.id("Login")).click();
		WebElement click=dr.findElement(By.xpath("//span[text()='Learn More']"));
		dr.executeScript("arguments[0].click();", click);
		Set<String> handles = dr.getWindowHandles();
		List<String> win=new ArrayList<String>(handles);
		dr.switchTo().window(win.get(1));
		dr.findElement(By.xpath("//button[text()='Confirm']")).click();
				
		Shadow shadow=new Shadow(dr);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		WebElement mouseHover=shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder=new Actions(dr);
		builder.moveToElement(mouseHover).perform();
		builder.scrollToElement(mouseHover).perform();
		WebElement click1=shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		dr.executeScript("arguments[0].click();", click1);
		String title=dr.getTitle();
		System.out.println("The title: "+title);
		
		List<WebElement> lists = dr.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("lists size: "+lists.size());
		for(int i=0;i<lists.size();i++) {
			String title1=lists.get(i).getText();
			System.out.println(title1);
		}
		File source=dr.getScreenshotAs(OutputType.FILE);
		File target= new File("snap/sales.png");
		FileUtils.copyFile(source, target);
		dr.close();
	}

}
