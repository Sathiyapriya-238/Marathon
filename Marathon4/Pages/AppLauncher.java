package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SpecificMethod1;

public class AppLauncher extends SpecificMethod1 {
	public AppLauncher(ChromeDriver driver) {
        this.driver=driver;  
    }
	public AppLauncher clickIndividual() {
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		return this;
	}
	public AppLauncher dropDown() {
		WebElement click=driver.findElement(By.xpath("(//span[text()='Individuals']//following::span)[1]"));
		 driver.executeScript("arguments[0].click();", click);
		 return this;
	}
	public CreateIndividual newIndividual() {
		 WebElement clk =driver.findElement(By.xpath("//span[text()='New Individual']"));
		 driver.executeScript("arguments[0].click();", clk);
		 return new CreateIndividual(driver);
	}
	public AppLauncher search(String ename) throws InterruptedException {
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(ename);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	public AppLauncher clickdrop() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		return this;
	}
	public CreateIndividual clickEdit() {
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		return new CreateIndividual(driver);
	}
	public VerifyIndividual clickDelete() throws InterruptedException {
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		return new VerifyIndividual(driver);
	}
	
}
