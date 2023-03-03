package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SpecificMethod1;

public class CreateIndividual extends SpecificMethod1 {
	public CreateIndividual(ChromeDriver driver) {
        this.driver=driver;  
	}
	public CreateIndividual enterSalutaion() {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mrs.']")).click();
		return this;
	}
	public CreateIndividual enterfname(String lname) {
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(lname);
		return this;
	}
	public CreateIndividual enterName(String name) {
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(name);
		return this;
	}
	public VerifyIndividual clickSave() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		return new VerifyIndividual(driver);
	}
}
