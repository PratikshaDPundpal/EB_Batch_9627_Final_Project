package package_2_mainFunctanalities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutPageTest {
	  private MainLogin mainLogin = new MainLogin(); 
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  MainLogin.setUp();
		  MainLogin.mainLoginpage();
	  }
	  @Test
	  public void runTest() throws InterruptedException {
		  WebDriver driver = mainLogin.getDriver();
		  MainLogin.mainLoginpage();
		  Actions actions = new Actions(driver);
	      actions.moveToElement(driver.findElement(By.xpath("//span[@class='menu_text'][normalize-space()='Checkout']"))).click().perform();
	      Thread.sleep(3000);
	      String title = driver.getTitle();
	      
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 750);"); 
		  
	      driver.findElement(By.xpath("//button[@id='checkout_btn']"));
		  Thread.sleep(2000);
		  
	      Assert.assertEquals(title, "Checkout Confirmation");
		  System.out.println("You are on "+ title + " page");
		  System.out.println("YOUR ORDER HAS BEEN PROCESSED!");
		  MainLogin.takeScreenshot("Order_successful");
	  }
	  
	  @AfterTest
	  public void close() {
		  MainLogin.close();
	  }
}
