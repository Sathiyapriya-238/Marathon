package first.marathon2;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseSalesForce1 extends SpecificMethod  {
	@BeforeTest
	public void setUp() {
		excelFile="salesforceContent";
	}
@Test(dataProvider = "fetchData")
	public  void runSalesForce(String question,String content) throws InterruptedException {
		
		
		WebElement click=driver.findElement(By.xpath("//p[text()='Content']"));
		driver.executeScript("arguments[0].click();",click);
		WebElement click1=driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", click1);
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println("The title of the page: "+title);
		if(title.contains("Chatter")) {
			System.out.println("The title is verified");
		}
		else {
			System.out.println("The title is not verified");
		}
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(question);
		driver.findElement(By.xpath("(//div[@contenteditable='true'])[1]")).sendKeys(content);
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println("The question is: "+text);
	}

}
