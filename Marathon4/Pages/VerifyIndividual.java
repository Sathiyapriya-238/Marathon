package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SpecificMethod1;

public class VerifyIndividual extends SpecificMethod1 {
	public VerifyIndividual(ChromeDriver driver) {
        this.driver=driver;  
	}
	public VerifyIndividual verify() {
		String message;
		
			message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			System.out.println(message);	
		return this;
	}
	public VerifyIndividual editVerify() {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		   System.out.println(msg);
		   return this;
	}
	public VerifyIndividual confirmDelete() {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		 return this;
	}
	public void verifyDelete(String cname) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(cname,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		System.out.println(verify);
	}
}
